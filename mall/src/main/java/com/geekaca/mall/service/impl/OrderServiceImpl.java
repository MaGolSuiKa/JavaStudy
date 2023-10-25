package com.geekaca.mall.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.geekaca.mall.common.Constants;
import com.geekaca.mall.common.NewBeeMallException;
import com.geekaca.mall.common.ServiceResultEnum;
import com.geekaca.mall.controller.front.param.ShoppingCartItemVO;
import com.geekaca.mall.controller.vo.StockNumDTO;
import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.domain.Order;
import com.geekaca.mall.domain.UserAddress;
import com.geekaca.mall.mapper.*;
import com.geekaca.mall.utils.PageQueryUtil;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderServiceImpl implements com.geekaca.mall.service.OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private OrderAddressMapper orderAddressMapper;

    @Override
    public PageResult getOrdersPage(PageQueryUtil pageUtil) {
        List<Order> orderList = orderMapper.findOrderList(pageUtil);
        int totalOrders = orderMapper.getTotalOrders(pageUtil);
        PageResult pageResult = new PageResult(orderList, totalOrders, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String checkDone(Long[] ids) {
        if (orderMapper.checkDone(ids) == 0) {
            return "操作失败";
        } else {
            return "success";
        }
    }

    @Override
    public String checkOut(Long[] ids) {
        if (orderMapper.checkOut(ids) == 0) {
            return "操作失败";
        } else {
            return "success";
        }
    }

    @Override
    public String closeOrder(Long[] ids) {
        if (orderMapper.closeOrder(ids) == 0) {
            return "操作失败";
        } else {
            return "success";
        }
    }

    @Override
    public String saveOrder(long userId, UserAddress address, List<ShoppingCartItemVO> itemsForSave) {
        //获取信息
        List<Long> itemIdsList = itemsForSave.stream().map(ShoppingCartItemVO->ShoppingCartItemVO.getCartItemId()).collect(Collectors.toList());
        List<Long> goodsIdsList = itemsForSave.stream().map(ShoppingCartItemVO->ShoppingCartItemVO.getGoodsId()).collect(Collectors.toList());
        List<GoodsInfo> goodsInfos = goodsInfoMapper.selectByPrimaryKeys(goodsIdsList);
        //检查是否包含已下架商品
        List<GoodsInfo> goodsListNotSelling = goodsInfos.stream()
                .filter(mallGoodsTemp -> mallGoodsTemp.getGoodsSellStatus() != Constants.SELL_STATUS_UP)
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(goodsListNotSelling)) {
            //goodsListNotSelling 对象非空则表示有下架商品
            NewBeeMallException.fail(goodsListNotSelling.get(0).getGoodsName() + "已下架，无法生成订单");
        }
        //库存判断
        Map<Long, GoodsInfo> mallGoodsMap = goodsInfos.stream().collect(Collectors.toMap(GoodsInfo::getGoodsId, Function.identity(), (entity1, entity2) -> entity1));
        for (ShoppingCartItemVO shoppingCartItemVO : itemsForSave) {
            //查出的商品中不存在购物车中关联商品数据，返回错误提醒
            if (!mallGoodsMap.containsKey(shoppingCartItemVO.getGoodsId())) {
                NewBeeMallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
            }
            //存在数量大于库存，返回错误提醒
            if (shoppingCartItemVO.getGoodsCount() > mallGoodsMap.get(shoppingCartItemVO.getGoodsId()).getStockNum()) {
                NewBeeMallException.fail(ServiceResultEnum.SHOPPING_ITEM_COUNT_ERROR.getResult());
            }
        }
        if(!CollectionUtils.isEmpty(itemIdsList) && !CollectionUtils.isEmpty(goodsIdsList) && !CollectionUtils.isEmpty(goodsInfos)){
            log.info("deleteBatch " , itemIdsList.size());
            if(shoppingCartItemMapper.deleteBatchByIds(itemIdsList) > 0){
                List<StockNumDTO> stockNumDTOS = BeanUtil.copyList(itemsForSave, StockNumDTO.class);
            }
        }
        return null;
    }
}
