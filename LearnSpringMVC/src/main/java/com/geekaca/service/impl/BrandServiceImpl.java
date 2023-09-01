package com.geekaca.service.impl;

import com.geekaca.dao.BrandMapper;
import com.geekaca.domain.Brand;
import com.geekaca.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper bm;

    @Override
    public List<Brand> searchAllBrand() {
        List<Brand> brands = bm.selectAllBrands();
        return brands;
    }

    @Override
    public Brand searchBrandById(Integer id) {
        Brand brand = bm.selectById(id);
        return brand;
    }

    @Override
    public int addBrand(Brand brand) {
        int i = bm.insertBrand(brand);
        return i;
    }

    @Override
    public int updateBrand(Brand brand) {
        int i = bm.updateBrand(brand);
        return i;
    }

    @Override
    public int delBrand(Integer id) {
        int i = bm.deleteById(id);
        return i;
    }
}
