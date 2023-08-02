package com.geekaca.db.mapper;

import com.geekaca.db.pojo.Order;
import com.geekaca.db.pojo.OrderGoods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    //订单新增
    int addOrder(Order order);

    //根据传递过来的字段决定 更新哪些列
    int updateOrderDynamic(Order order);

    int deleteByIds(@Param("myIds") int[] ids);

    @Select("select * from tb_order")
    List<Order> selectAll();
}
