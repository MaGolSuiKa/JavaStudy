package com.geekaca.mybatis;

import com.geekaca.mybatis.mapper.BrandMapper;
import com.geekaca.mybatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testSelectAll(){
        String resousrce = "mybatis-config.xml";
        InputStream ips = null;
        try {
            ips = Resources.getResourceAsStream(resousrce);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        //从mybatis获取mapper类
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = mapper.selectAll();
//        brands.forEach((brd)->{
//            System.out.println(brd);
//        });

//        Assert.assertNotNull(brands);
//        Assert.assertTrue(brands.size() > 0);

//        Brand brand = mapper.selectById(3);
//        Assert.assertNotNull(brand);
        //根据id删除
        mapper.deleteById(3);
        sqlSession.commit();
        sqlSession.commit();
    }

}
