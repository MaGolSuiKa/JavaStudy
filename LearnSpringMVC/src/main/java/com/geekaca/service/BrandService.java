package com.geekaca.service;

import com.geekaca.domain.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> searchAllBrand();
    Brand searchBrandById(Integer id);
    int addBrand(Brand brand);
    int updateBrand(Brand brand);
    int delBrand(Integer id);
}
