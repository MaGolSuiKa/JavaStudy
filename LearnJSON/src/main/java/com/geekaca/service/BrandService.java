package com.geekaca.service;

import com.geekaca.mapper.BrandMapper;
import com.geekaca.pojo.Brand;
import com.geekaca.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

//service  业务逻辑层
public class BrandService {

    public List<Brand> getAllBrands() {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectBrand();
        sqlSession.close();
        return brands;
    }

    public int addBrand(Brand brand) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.insertBrand(brand);
        sqlSession.close();
        return i;
    }

    public Brand searchById(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public List<Brand> searchByName(String input) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByName(input);
        sqlSession.close();
        return brands;
    }

    public int updateBrand(Brand brand) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.updateBrand(brand);
        sqlSession.close();
        return i;
    }

    public int deleteBrand(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.deleteBrand(id);
        sqlSession.close();
        return i;
    }
}
