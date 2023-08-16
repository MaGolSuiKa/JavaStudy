package com.geekaca.mapper;

import com.geekaca.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
        List<Brand> selectBrand();
        int insertBrand(Brand brand);
        int updateBrand(Brand brand);
        int deleteBrand(@Param("brandId") Integer id);
}
