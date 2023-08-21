package com.geekaca.mapper;

import com.geekaca.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    //获取所有
    List<Brand> selectBrand();

    //获取单项
    Brand selectById(Integer id);

    //模糊查询
    List<Brand> selectByName(String searchInput);

    //添加品牌内容
    int insertBrand(Brand brand);

    //修改品牌内容
    int updateBrand(Brand brand);

    //删除品牌内容
    int deleteBrand(@Param("brandId") Integer id);
}
