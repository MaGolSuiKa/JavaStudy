package com.geekaca.service;

import com.geekaca.domain.Brand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BrandService {
    public List<Brand> searchAllBrand();
    public Brand searchBrandByInput(String input);
    public int addBrand(Brand brand);
    public int updateBrand(Brand brand);
    public int delBrand(Integer id);
}
