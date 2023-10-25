package com.geekaca.mall.controller.front;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.common.NewBeeMallException;
import com.geekaca.mall.common.ServiceResultEnum;
import com.geekaca.mall.controller.front.param.SaveOrderParam;
import com.geekaca.mall.controller.front.param.ShoppingCartItemVO;
import com.geekaca.mall.domain.UserAddress;
import com.geekaca.mall.service.MallUserAddressService;
import com.geekaca.mall.service.OrderService;
import com.geekaca.mall.service.ShoppingCartItemService;
import com.geekaca.mall.utils.JwtUtil;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "v1", tags = "订单操作相关接口")
@RequestMapping("/api/v1")
@Slf4j
public class MallOrderController {
    @Autowired
    private ShoppingCartItemService shoppingCartItemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MallUserAddressService mallUserAddressService;

    @PostMapping("/saveOrder")
    @ApiOperation(value = "生成订单接口", notes = "传参为地址id和待结算的购物项id数组")
    public Result<String> saveOrder(@ApiParam(value = "订单参数") @RequestBody SaveOrderParam saveOrderParam, HttpServletRequest request) {
        String token = request.getHeader("token");
        //用token 拿到用户信息  userId
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long userId = Long.parseLong(uid);
        int priceTotal = 0;
        if (saveOrderParam == null || saveOrderParam.getCartItemIds() == null || saveOrderParam.getAddressId() == null) {
            NewBeeMallException.fail(ServiceResultEnum.PARAM_ERROR.getResult());
        }
        if (saveOrderParam.getCartItemIds().length < 1) {
            NewBeeMallException.fail(ServiceResultEnum.PARAM_ERROR.getResult());
        }
        //根据购物车中的item id获取商品信息
        List<ShoppingCartItemVO> itemsForSave = shoppingCartItemService.getCartItemsForSettle(Arrays.asList(saveOrderParam.getCartItemIds()), userId);
        if (CollectionUtils.isEmpty(itemsForSave)) {
            //无数据
            NewBeeMallException.fail("参数异常");
        } else {
            //商品总价
            for (ShoppingCartItemVO mallShoppingCartItemVO : itemsForSave) {
                priceTotal += mallShoppingCartItemVO.getGoodsCount() * mallShoppingCartItemVO.getSellingPrice();
            }
            if (priceTotal < 1) {
                NewBeeMallException.fail("价格异常");
            }
            //根据前端传递过来的地址id，查询地址的详情
            UserAddress address = mallUserAddressService.getMallUserAddressById(saveOrderParam.getAddressId());
            if (userId != (address.getUserId())) {
                return ResultGenerator.genFailResult(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
            }
            //保存订单并返回订单号
            String saveOrderResult = orderService.saveOrder(userId, address, itemsForSave);
            Result result = ResultGenerator.genSuccessResult();
            result.setData(saveOrderResult);
            return result;
        }
        return ResultGenerator.genFailResult("生成订单失败");
    }
}
