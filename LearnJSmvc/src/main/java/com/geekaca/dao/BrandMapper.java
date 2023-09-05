package com.geekaca.dao;

import com.geekaca.domain.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAllBrands();
    Brand selectByInput(String input);
    int updateBrand(Brand brand);
    int deleteById(Integer id);
    int insertBrand(Brand brand);
}
