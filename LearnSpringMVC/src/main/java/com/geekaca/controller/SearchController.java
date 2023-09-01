package com.geekaca.controller;

import com.geekaca.domain.Brand;
import com.geekaca.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class SearchController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/all")
    public List<Brand> findAllBrand(){
        List<Brand> brandList = brandService.searchAllBrand();
        return brandList;
    }
    @RequestMapping("/search")
    public Brand findBrand(Integer id){
        Brand brand = brandService.searchBrandById(id);
        return brand;
    }
    @RequestMapping("/update")
    public void updateBrand(Brand brand){
        int i = brandService.updateBrand(brand);

    }
    @RequestMapping("/add")
    public void addBrand(Brand brand){
        int i = brandService.addBrand(brand);
    }
    @RequestMapping("/del")
    public void deleteBrand(Integer id){
        int i = brandService.delBrand(id);
    }
}
