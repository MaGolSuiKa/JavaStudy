package com.geekaca.mall.controller.front;

import com.auth0.jwt.interfaces.Claim;
import com.geekaca.mall.common.Constants;
import com.geekaca.mall.common.NewBeeMallException;
import com.geekaca.mall.common.ServiceResultEnum;
import com.geekaca.mall.controller.front.param.SaveOrderParam;
import com.geekaca.mall.controller.front.param.ShoppingCartItemVO;
import com.geekaca.mall.controller.vo.MallOrderListVO;
import com.geekaca.mall.controller.vo.OrderDetailVO;
import com.geekaca.mall.domain.UserAddress;
import com.geekaca.mall.service.MallUserAddressService;
import com.geekaca.mall.service.OrderService;
import com.geekaca.mall.service.ShoppingCartItemService;
import com.geekaca.mall.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
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
    @GetMapping("/order/{orderNo}")
    @ApiOperation(value = "订单详情接口", notes = "传参为订单号")
    public Result<OrderDetailVO> orderDetailPage(@ApiParam(value = "订单号") @PathVariable("orderNo") String orderNo, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long UserId = Long.parseLong(uid);
        return ResultGenerator.genSuccessResult(orderService.getOrderDetailByOrderNo(orderNo, UserId));
    }

    @GetMapping("/order")
    @ApiOperation(value = "订单列表接口", notes = "传参为页码")
    public Result<PageResult<List<MallOrderListVO>>> orderList(@ApiParam(value = "页码") @RequestParam(required = false) Integer pageNumber,
                                                               @ApiParam(value = "订单状态:0.待支付 1.待确认 2.待发货 3:已发货 4.交易成功") @RequestParam(required = false) Integer status,
                                                               HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long UserId = Long.parseLong(uid);
        Map params = new HashMap(8);
        if (pageNumber == null || pageNumber < 1) {
            pageNumber = 1;
        }
        params.put("userId", UserId);
        params.put("orderStatus", status);
        params.put("page", pageNumber);
        params.put("limit", Constants.ORDER_SEARCH_PAGE_LIMIT);
        //封装分页请求参数
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(orderService.getMyOrders(pageUtil));
    }

    @PutMapping("/order/{orderNo}/cancel")
    @ApiOperation(value = "订单取消接口", notes = "传参为订单号")
    public Result cancelOrder(@ApiParam(value = "订单号") @PathVariable("orderNo") String orderNo, HttpServletRequest request) {
        String token = request.getHeader("token");
        Map<String, Claim> stringClaimMap = JwtUtil.verifyToken(token);
        Claim idClaim = stringClaimMap.get("id");
        String uid = idClaim.asString();
        long UserId = Long.parseLong(uid);
        String cancelOrderResult = orderService.cancelOrder(orderNo, UserId);
        if (ServiceResultEnum.SUCCESS.getResult().equals(cancelOrderResult)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(cancelOrderResult);
        }
    }
    
}
