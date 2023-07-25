SELECT 
    id,payment,payment_type,status,title,price
FROM
    tb_order_goods,
    tb_order,
    tb_goods
WHERE
    tb_order_goods.order_id = tb_order.order_id and
    tb_order_goods.goods_id = tb_goods.goods_id