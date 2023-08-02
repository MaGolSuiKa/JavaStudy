package com.geekaca.db.mapper;

import com.geekaca.db.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     * 先在mapper类中写方法
     * 然后利用报错，利用mybatisX插件来生成 mapper XML中的语句
     * @return
     */
    //查询所有
    List<Brand> selectAllBrands();

    Brand selectById(Integer id);

    /**
     * 修改类
     * 返回int 代表 收到影响的记录条数
     */
    int insertBrand(Brand brand);

    List<Brand> selectByCondition(Integer id);

    /**
     * 需求： 能够满足不同条件的组合查询
     * 可能只传了一个 参数
     * 可能多个
     * @return
     */
    List<Brand> selectByConditionDynamic(Brand brand);

    /**
     * 多个条件，互斥的
     * 只能有一个生效
     * @param brand
     * @return
     */
    List<Brand> selectByOneCondition(Brand brand);
}
