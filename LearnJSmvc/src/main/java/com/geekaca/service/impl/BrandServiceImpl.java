package com.geekaca.service.impl;

import com.geekaca.controller.Code;
import com.geekaca.dao.BrandMapper;
import com.geekaca.domain.Brand;
import com.geekaca.exception.BusinessException;
import com.geekaca.exception.SystemException;
import com.geekaca.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper bm;


    public List<Brand> searchAllBrand() {
        List<Brand> brands = bm.selectAllBrands();

        if (brands == null) {
            throw new BusinessException(Code.BUSINESS_ERR, "业务逻辑异常");
        }
        try {

        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试!", e);
        }
        return brands;
    }


    public Brand searchBrandByInput(String input) {
        Brand brand = bm.selectByInput(input);
        if (input == null) {
            throw new BusinessException(Code.BUSINESS_ERR, "未输入");
        }
        try {

        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试!", e);
        }
        return brand;
    }


    public int addBrand(Brand brand) {
        int i = bm.insertBrand(brand);
        if (brand == null) {
            throw new BusinessException(Code.BUSINESS_ERR, "业务逻辑异常");
        }
        try {

        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试!", e);
        }
        return i;
    }


    public int updateBrand(Brand brand) {
        int i = bm.updateBrand(brand);
        if (brand == null) {
            throw new BusinessException(Code.BUSINESS_ERR, "业务逻辑异常");
        }
        try {

        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试!", e);
        }
        return i;
    }


    public int delBrand(Integer id) {
        int i = bm.deleteById(id);
        if (id == null) {
            throw new BusinessException(Code.BUSINESS_ERR, "未输入");
        }
        try {

        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试!", e);
        }
        return i;
    }
}
