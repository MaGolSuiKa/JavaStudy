package com.geekaca.controller;

import com.geekaca.domain.Brand;
import com.geekaca.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService bs;

    @PostMapping
    public Result add(@RequestBody Brand brand) {
        int i = bs.addBrand(brand);
        boolean flag = false;
        if(i >0){
            flag = true;
        }
        return new Result(flag ? Code.ADD_OK : Code.ADD_ERR, flag);
    }

    @PostMapping
    public Result update(@RequestBody Brand brand) {
        int i = bs.updateBrand(brand);
        boolean flag = false;
        if(i >0){
            flag = true;
        }
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        int i = bs.delBrand(id);
        boolean flag = false;
        if(i >0){
            flag = true;
        }
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping
    public Result searchAll() {
        List<Brand> brandList = bs.searchAllBrand();
        Integer code = brandList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = brandList != null ? "" : "数据查询失败，请重试！";
        return new Result(code, brandList, msg);
    }

    @GetMapping("/{input}")
    public Result searchBy(@PathVariable String input) {
        Brand brand = bs.searchBrandByInput(input);
        Integer code = brand != null ? Code.GET_OK : Code.GET_ERR;
        String msg = brand != null ? "" : "数据查询失败，请重试！";
        return new Result(code, brand, msg);
    }
}
