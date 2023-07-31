package com.geekaca.mybatis.mapper;

import com.geekaca.mybatis.pojo.Brand;
import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(Integer id);
    Brand deleteById(Integer id);
}
