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
    public List<Brand> getAllBrands(Integer pageNo, Integer pageSize) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //limit 的第一个参数
        int start = (pageNo - 1) * pageSize;
        List<Brand> brands = brandMapper.selectAll(start, pageSize);
        sqlSession.close();
        return brands;
    }
    public int getAllBrandsCount(){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int count = brandMapper.selectAllCount();
        sqlSession.close();
        return count;
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

    public List<Brand> searchWithPage(Brand brand) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int start = (brand.getPageNo() - 1) * brand.getPageSize();
        brand.setPageNo(start);
        List<Brand> brands = brandMapper.selectWithPage(brand);
        sqlSession.close();
        return brands;
    }
    public int getBrandCount(Brand brand){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int start = (brand.getPageNo() - 1) * brand.getPageSize();
        brand.setPageNo(start);
        int count = brandMapper.selectCount(brand);
        sqlSession.close();
        return count;
    }
    public List<Brand> searchByName(Brand brand) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectByName(brand);
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

    public int deleteBrands(String ids) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int i = brandMapper.deleteBrands(ids);
        sqlSession.close();
        return i;
    }
}
