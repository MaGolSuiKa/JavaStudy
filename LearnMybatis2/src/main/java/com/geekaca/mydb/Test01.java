package com.geekaca.mydb;

import com.geekaca.mydb.mapper.BrandMapper;
import com.geekaca.mydb.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

//作业:
//1，向商品表tb goods中插入数据
//2，根据商品名字 模糊查询
//3，多条件组合，商品名字，价格，
// 可能只有名字参数，可能只有价格，可能两者都有，可能两者都没有)
public class Test01 {
    public static void main(String[] args) {
        //testInsert();
        //testSearchByName();
        testSearchByAll();
    }

    /**
     * 向商品表tb goods中插入数据
     */
    private static void testInsert() {
        Scanner scanner = new Scanner(System.in);
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        System.out.println("请输入商品名：");
        String goodsTitle = scanner.next();
        brand.setGoodsTitle(goodsTitle);
        System.out.println("请输入商品价格：");
        double goodsPrice = scanner.nextDouble();
        brand.setGoodsPrice(goodsPrice);
        int inserted = brandMapper.insertBrand(brand);
        System.out.println("受影响数据条数：" + inserted);
        sqlSession.close();
    }

    /**
     * 根据商品名字 模糊查询
     */

    private static void testSearchByName() {
        Scanner scanner = new Scanner(System.in);
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        System.out.println("请输入搜索内容：");
        String goodsTitle = scanner.next();
        brand.setGoodsTitle(goodsTitle);

        List<Brand> brands = brandMapper.selectBy(brand);
        System.out.println("品牌名字含有" + goodsTitle + "的：");
        brands.forEach(brd -> System.out.println(brd));
    }

    /**
     * 多条件组合，商品名字，价格,可能只有名字参数，可能只有价格，可能两者都有，可能两者都没有
     */
    private static void testSearchByAll() {
        Scanner scanner = new Scanner(System.in);
        SqlSession sqlSession = openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();

        System.out.println("请输入搜索内容(输入pass跳过)：");
        String goodsTitle = scanner.next();
        brand.setGoodsTitle(goodsTitle);
        System.out.println("请输入价格(输入0跳过)：");
        double goodsPrice = scanner.nextDouble();
        brand.setGoodsPrice(goodsPrice);

        List<Brand> brands = brandMapper.selectByConditionDynamic(brand);
        System.out.println("符合条件的：");
        brands.forEach(brd -> System.out.println(brd));
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
}
