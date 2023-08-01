package com.geekaca.mydb.mapper;

import com.geekaca.mydb.pojo.Brand;

import java.util.List;


public interface BrandMapper {
    //插入数据
    int insertBrand(Brand brand);

    //模糊查询
    List<Brand> selectBy(Brand brand);

    //多条件组合
    List<Brand> selectByConditionDynamic(Brand brand);
}
