package com.geekaca.db;

import cn.hutool.core.util.IdUtil;
import com.geekaca.db.mapper.BrandMapper;
import com.geekaca.db.mapper.OrderGoodsMapper;
import com.geekaca.db.mapper.OrderMapper;
import com.geekaca.db.pojo.Brand;
import com.geekaca.db.pojo.Order;
import com.geekaca.db.pojo.OrderGoods;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
//        testInsert();
//        testSelect();
//        testSearch();
//        testWhen();
//        for (int i = 0; i < 5; i++) {
//            long l = IdUtil.getSnowflake(1, 20).nextId();
//            System.out.println(l);
//        }
        //主键返回
        testInsertGen();
        //根据用户发送的值，来动态的决定更新哪些字段
//        testUpdateDynamic();
        //testDeleteIds();
    }
    private static void testDeleteIds(){
        SqlSession sqlSession = openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        int[] ids = {10, 12, 13};
        int deleted = orderMapper.deleteByIds(ids);
        System.out.println("删除了: " +deleted);
    }
    private static void testUpdateDynamic(){
        SqlSession sqlSession = openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setId(10);
        order.setPayment(8.8);
        order.setPaymentType(3);
        orderMapper.updateOrderDynamic(order);
    }

    private static void testWhen(){
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
//        brand.setBrandName("米");
//        // 再加条件
//        brand.setCompanyName("小");
//        brand.setStatus(0);
        List<Brand> brands = brandMapper.selectByOneCondition(brand);
        brands.forEach(brd -> System.out.println(brd));
    }

    private static void testSearch() {
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("米");

        // 再加条件
        brand.setCompanyName("小");
        //其他属性默认值？
        /**
         * 类对象 成员变量默认值
         */
        List<Brand> brands = brandMapper.selectByConditionDynamic(brand);
        System.out.println("品牌名字含有米的：");
        brands.forEach(brd -> System.out.println(brd));
    }


    private static void testSelect() {
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByCondition(3);
        brands.forEach(brd -> System.out.println(brd));
    }

    private static void testInsert() {
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("大米");
        brand.setCompanyName("大米科技");
        brand.setOrdered(0);
        brand.setDescription("大米科技手机");
        brand.setStatus(1);
        int inserted = brandMapper.insertBrand(brand);
        System.out.println("执行insert后，受到影响的记录条数:" + inserted);
//        sqlSession.commit();
        sqlSession.close();
    }

    private static void test() {
        /**
         * 获取Mybatis Session
         * 获取mapper
         */
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brandList = brandMapper.selectAllBrands();
        brandList.forEach(brd -> System.out.println(brd));
        System.out.println("======================");

        Brand brand = brandMapper.selectById(1);
        if (brand != null) {
            /**
             * #{ }
             *  select * from tb_brand where id = ?
             *  说明内部用的是PreparedStatement ，优点： 防止sql注入攻击
             *  mybatis内部就是用JDBC来实现的
             *  ${} 无法预防sql注入攻击
             */
            System.out.println("找到了id是1的： " + brand);
        }
        sqlSession.close();
    }

    private static SqlSession openSession() {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //会话
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
    //主键回填
    private static void testInsertGen() {
        SqlSession sqlSession = openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        OrderGoodsMapper ogMapper = sqlSession.getMapper(OrderGoodsMapper.class);
        Order order = new Order();
        order.setStatus(1);
        order.setPayment(999.9);
        order.setPaymentType(2);
        int inserted = orderMapper.addOrder(order);
        System.out.println("执行insert后，受到影响的记录条数:" + inserted);
        System.out.println("order id：" + order.getId());
        //todo: 用这个orderId，向 tb_order_goods 中插入两条数据
        OrderGoods og1 = new OrderGoods();
        og1.setGoodsId(17);
        og1.setOrderId(order.getId());
        og1.setCount(1);
        int ogInserted1 = ogMapper.addOrderGoods(og1);
        OrderGoods og2 = new OrderGoods();
        og2.setGoodsId(18);
        og2.setOrderId(order.getId());
        og2.setCount(1);
        int ogInserted2 = ogMapper.addOrderGoods(og2);


        System.out.println("执行insert后，order_goods受到影响的记录条数:" + (ogInserted1+ogInserted2));
        sqlSession.close();
    }
}
