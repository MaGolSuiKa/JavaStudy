package com.geekaca.mall.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.geekaca.mall.common.*;
import com.geekaca.mall.controller.front.param.ShoppingCartItemVO;
import com.geekaca.mall.controller.vo.MallOrderListVO;
import com.geekaca.mall.controller.vo.OrderDetailVO;
import com.geekaca.mall.controller.vo.OrderItemVO;
import com.geekaca.mall.controller.vo.StockNumDTO;
import com.geekaca.mall.domain.*;
import com.geekaca.mall.mapper.*;
import com.geekaca.mall.utils.NumUtil;
import com.geekaca.mall.utils.PageQueryUtil;
import com.geekaca.mall.utils.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
    @Transactional
    public String checkDone(Long[] ids) {
        //查询所有的订单 判断状态 修改状态和更新时间
        List<Order> orders = orderMapper.selectByPrimaryKeys(Arrays.asList(ids));
        String orderNos = "";
        if (!CollectionUtils.isEmpty(orders)) {
            for (Order newBeeMallOrder : orders) {
                if (newBeeMallOrder.getIsDeleted() == 1) {
                    orderNos += newBeeMallOrder.getOrderNo() + " ";
                    continue;
                }
                if (newBeeMallOrder.getOrderStatus() != 1) {
                    orderNos += newBeeMallOrder.getOrderNo() + " ";
                }
            }
            if (!StringUtils.hasText(orderNos)) {
                //订单状态正常 可以执行配货完成操作
                if (orderMapper.checkDone(Arrays.asList(ids)) > 0) {
                    return ServiceResultEnum.SUCCESS.getResult();
                } else {
                    return ServiceResultEnum.DB_ERROR.getResult();
                }
            } else {
                //订单此时不可执行出库操作
                if (orderNos.length() > 0 && orderNos.length() < 100) {
                    return orderNos + "订单的状态不是支付成功无法执行出库操作";
                } else {
                    return "你选择了太多状态不是支付成功的订单，无法执行配货完成操作";
                }
            }
        }
        return ServiceResultEnum.DATA_NOT_EXIST.getResult();
    }


    @Override
    @Transactional
    public String checkOut(Long[] ids) {
        //查询所有的订单 判断状态 修改状态和更新时间
        List<Order> orders = orderMapper.selectByPrimaryKeys(Arrays.asList(ids));
        String orderNos = "";
        if (!CollectionUtils.isEmpty(orders)) {
            for (Order newBeeMallOrder : orders) {
                if (newBeeMallOrder.getIsDeleted() == 1) {
                    orderNos += newBeeMallOrder.getOrderNo() + " ";
                    continue;
                }
                if (newBeeMallOrder.getOrderStatus() != 1 && newBeeMallOrder.getOrderStatus() != 2) {
                    orderNos += newBeeMallOrder.getOrderNo() + " ";
                }
            }
            if (!StringUtils.hasText(orderNos)) {
                //订单状态正常 可以执行出库操作
                if (orderMapper.checkOut(Arrays.asList(ids)) > 0) {
                    return ServiceResultEnum.SUCCESS.getResult();
                } else {
                    return ServiceResultEnum.DB_ERROR.getResult();
                }
            } else {
                //订单此时不可执行出库操作
                if (orderNos.length() > 0 && orderNos.length() < 100) {
                    return orderNos + "订单的状态不是支付成功或配货完成无法执行出库操作";
                } else {
                    return "你选择了太多状态不是支付成功或配货完成的订单，无法执行出库操作";
                }
            }
        }
        return ServiceResultEnum.DATA_NOT_EXIST.getResult();
    }

    @Override
    public String closeOrder(Long[] ids) {
        List<Order> orders = orderMapper.selectByPrimaryKeys(Arrays.asList(ids));
        String orderNos = "";
        if (!CollectionUtils.isEmpty(orders)) {
            for (Order newBeeMallOrder : orders) {
                // isDeleted=1 一定为已关闭订单
                if (newBeeMallOrder.getIsDeleted() == 1) {
                    orderNos += newBeeMallOrder.getOrderNo() + " ";
                    continue;
                }
                //已关闭或者已完成无法关闭订单
                if (newBeeMallOrder.getOrderStatus() == 4 || newBeeMallOrder.getOrderStatus() < 0) {
                    orderNos += newBeeMallOrder.getOrderNo() + " ";
                }
            }
            if (!StringUtils.hasText(orderNos)) {
                //订单状态正常 可以执行关闭操作
                if (orderMapper.closeOrder(Arrays.asList(ids), NewBeeMallOrderStatusEnum.ORDER_CLOSED_BY_JUDGE.getOrderStatus()) > 0) {
                    return ServiceResultEnum.SUCCESS.getResult();
                } else {
                    return ServiceResultEnum.DB_ERROR.getResult();
                }
            } else {
                //订单此时不可执行关闭操作
                if (orderNos.length() > 0 && orderNos.length() < 100) {
                    return orderNos + "订单不能执行关闭操作";
                } else {
                    return "你选择的订单不能执行关闭操作";
                }
            }
        }
        return ServiceResultEnum.DATA_NOT_EXIST.getResult();
    }

    @Override
    public String saveOrder(long userId, UserAddress address, List<ShoppingCartItemVO> itemsForSave) {
        //获取信息
        List<Long> itemIdsList = itemsForSave.stream().map(ShoppingCartItemVO -> ShoppingCartItemVO.getCartItemId()).collect(Collectors.toList());
        List<Long> goodsIdsList = itemsForSave.stream().map(ShoppingCartItemVO -> ShoppingCartItemVO.getGoodsId()).collect(Collectors.toList());
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
        //清除购物车内容
        if (!CollectionUtils.isEmpty(itemIdsList) && !CollectionUtils.isEmpty(goodsIdsList) && !CollectionUtils.isEmpty(goodsInfos)) {
            log.info("deleteBatch ", itemIdsList.size());
            if (shoppingCartItemMapper.deleteBatchByIds(itemIdsList) > 0) {
                List<StockNumDTO> stockNumDTOS = BeanUtil.copyToList(itemsForSave, StockNumDTO.class);
                int updateStockNum = goodsInfoMapper.updateStockNum(stockNumDTOS);
                if (updateStockNum < 1) {
                    NewBeeMallException.fail(ServiceResultEnum.SHOPPING_ITEM_COUNT_ERROR.getResult());
                }
                //生成订单号
                String orderNo = NumUtil.genOrderNo();
                int priceTotal = 0;
                //保存订单
                Order mallOrder = new Order();
                mallOrder.setOrderNo(orderNo);
                mallOrder.setUserId(userId);
                //计算总价
                for (ShoppingCartItemVO mallShoppingCartItemVO : itemsForSave) {
                    priceTotal += mallShoppingCartItemVO.getGoodsCount() * mallShoppingCartItemVO.getSellingPrice();
                }
                if (priceTotal < 1) {
                    NewBeeMallException.fail(ServiceResultEnum.ORDER_PRICE_ERROR.getResult());
                }
                mallOrder.setTotalPrice(priceTotal);
                String extraInfo = "";
                mallOrder.setExtraInfo(extraInfo);
                //生成订单项并保存订单项纪录
                if (orderMapper.insertSelective(mallOrder) > 0) {
                    //生成订单收货地址快照，并保存至数据库
                    OrderAddress mallOrderAddress = new OrderAddress();
                    BeanUtil.copyProperties(address, mallOrderAddress);
                    mallOrderAddress.setOrderId(mallOrder.getOrderId());
                    //生成所有的订单项快照，并保存至数据库
                    List<OrderItem> newBeeMallOrderItems = new ArrayList<>();
                    for (ShoppingCartItemVO mallShoppingCartItemVO : itemsForSave) {
                        OrderItem newBeeMallOrderItem = new OrderItem();
                        //使用BeanUtil工具类将newBeeMallShoppingCartItemVO中的属性复制到newBeeMallOrderItem对象中
                        BeanUtil.copyProperties(mallShoppingCartItemVO, newBeeMallOrderItem);
                        //NewBeeMallOrderMapper文件insert()方法中使用了useGeneratedKeys因此orderId可以获取到
                        newBeeMallOrderItem.setOrderId(mallOrder.getOrderId());
                        newBeeMallOrderItems.add(newBeeMallOrderItem);
                    }
                    //保存至数据库
                    if (orderItemMapper.insertBatch(newBeeMallOrderItems) > 0 && orderAddressMapper.insertSelective(mallOrderAddress) > 0) {
                        //所有操作成功后，将订单号返回，以供Controller方法跳转到订单详情
                        return orderNo;
                    }
                    NewBeeMallException.fail(ServiceResultEnum.ORDER_PRICE_ERROR.getResult());
                }
                NewBeeMallException.fail(ServiceResultEnum.DB_ERROR.getResult());
            }
            NewBeeMallException.fail(ServiceResultEnum.DB_ERROR.getResult());
        }
        NewBeeMallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
        return ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult();
    }

    @Override
    public OrderDetailVO getOrderDetailByOrderNo(String orderNo, long userId) {
        Order newBeeMallOrder = orderMapper.selectByOrderNo(orderNo);
        if (newBeeMallOrder == null) {
            NewBeeMallException.fail(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        if (userId != (newBeeMallOrder.getUserId())) {
            NewBeeMallException.fail(ServiceResultEnum.REQUEST_FORBIDEN_ERROR.getResult());
        }
        List<OrderItem> orderItems = orderItemMapper.selectByOrderId(newBeeMallOrder.getOrderId());
        //获取订单项数据
        if (CollectionUtils.isEmpty(orderItems)) {
            NewBeeMallException.fail(ServiceResultEnum.ORDER_ITEM_NOT_EXIST_ERROR.getResult());
        }
        List<OrderItemVO> newBeeMallOrderItemVOS = BeanUtil.copyToList(orderItems, OrderItemVO.class);
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        BeanUtil.copyProperties(newBeeMallOrder, orderDetailVO);
        orderDetailVO.setOrderStatusString(NewBeeMallOrderStatusEnum.getNewBeeMallOrderStatusEnumByStatus(orderDetailVO.getOrderStatus()).getName());
        orderDetailVO.setPayTypeString(PayTypeEnum.getPayTypeEnumByType(orderDetailVO.getPayType()).getName());
        orderDetailVO.setMallOrderItemVOS(newBeeMallOrderItemVOS);
        return orderDetailVO;
    }

    @Override
    public PageResult getMyOrders(PageQueryUtil pageUtil) {
        int total = orderMapper.getTotalMallOrders(pageUtil);
        List<Order> newBeeMallOrders = orderMapper.findMallOrderList(pageUtil);
        List<MallOrderListVO> orderListVOS = new ArrayList<>();
        if (total > 0) {
            //数据转换 将实体类转成vo
            orderListVOS = BeanUtil.copyToList(newBeeMallOrders, MallOrderListVO.class);

            //设置订单状态中文显示值
            for (MallOrderListVO newBeeMallOrderListVO : orderListVOS) {
                newBeeMallOrderListVO.setOrderStatusString(NewBeeMallOrderStatusEnum.getNewBeeMallOrderStatusEnumByStatus(newBeeMallOrderListVO.getOrderStatus()).getName());
            }
            List<Long> orderIds = newBeeMallOrders.stream().map(Order::getOrderId).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(orderIds)) {
                List<OrderItem> orderItems = orderItemMapper.selectByOrderIds(orderIds);
                Map<Long, List<OrderItem>> itemByOrderIdMap = orderItems.stream().collect(groupingBy(OrderItem::getOrderId));
                for (MallOrderListVO newBeeMallOrderListVO : orderListVOS) {
                    //封装每个订单列表对象的订单项数据
                    if (itemByOrderIdMap.containsKey(newBeeMallOrderListVO.getOrderId())) {
                        List<OrderItem> orderItemListTemp = itemByOrderIdMap.get(newBeeMallOrderListVO.getOrderId());
                        //将MallOrderItem对象列表转换成MallOrderItemVO对象列表
                        List<OrderItemVO> newBeeMallOrderItemVOS = BeanUtil.copyToList(orderItemListTemp, OrderItemVO.class);
                        newBeeMallOrderListVO.setMallOrderItemVOS(newBeeMallOrderItemVOS);
                    }
                }
            }
        }
        PageResult pageResult = new PageResult(orderListVOS, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String cancelOrder(String orderNo, long userId) {
        Order newBeeMallOrder = orderMapper.selectByOrderNo(orderNo);
        if (newBeeMallOrder != null) {
            //验证是否是当前userId下的订单，否则报错
            if (userId != (newBeeMallOrder.getUserId())) {
                NewBeeMallException.fail(ServiceResultEnum.NO_PERMISSION_ERROR.getResult());
            }
            //订单状态判断
            if (newBeeMallOrder.getOrderStatus().intValue() == NewBeeMallOrderStatusEnum.ORDER_SUCCESS.getOrderStatus()
                    || newBeeMallOrder.getOrderStatus().intValue() == NewBeeMallOrderStatusEnum.ORDER_CLOSED_BY_MALLUSER.getOrderStatus()
                    || newBeeMallOrder.getOrderStatus().intValue() == NewBeeMallOrderStatusEnum.ORDER_CLOSED_BY_EXPIRED.getOrderStatus()
                    || newBeeMallOrder.getOrderStatus().intValue() == NewBeeMallOrderStatusEnum.ORDER_CLOSED_BY_JUDGE.getOrderStatus()) {
                return ServiceResultEnum.ORDER_STATUS_ERROR.getResult();
            }
            //修改订单状态&&恢复库存
            if (orderMapper.closeOrder(Collections.singletonList(newBeeMallOrder.getOrderId()), NewBeeMallOrderStatusEnum.ORDER_CLOSED_BY_MALLUSER.getOrderStatus()) > 0 && recoverStockNum(Collections.singletonList(newBeeMallOrder.getOrderId()))) {
                return ServiceResultEnum.SUCCESS.getResult();
            } else {
                return ServiceResultEnum.DB_ERROR.getResult();
            }
        }
        return ServiceResultEnum.ORDER_NOT_EXIST_ERROR.getResult();
    }
    /**
     * 恢复库存
     */
    public Boolean recoverStockNum(List<Long> orderIds) {
        //查询对应的订单项
        List<OrderItem> newBeeMallOrderItems = orderItemMapper.selectByOrderIds(orderIds);
        //获取对应的商品id和商品数量并赋值到StockNumDTO对象中
        List<StockNumDTO> stockNumDTOS = BeanUtil.copyToList(newBeeMallOrderItems, StockNumDTO.class);
        //执行恢复库存的操作
        int updateStockNumResult = goodsInfoMapper.recoverStockNum(stockNumDTOS);
        if (updateStockNumResult < 1) {
            NewBeeMallException.fail(ServiceResultEnum.CLOSE_ORDER_ERROR.getResult());
            return false;
        } else {
            return true;
        }
    }
}
