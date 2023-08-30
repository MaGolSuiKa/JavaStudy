package com.geekaca.service.impl;

import com.geekaca.dao.GoodsDao;
import com.geekaca.domain.Goods;
import com.geekaca.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service("goodsService")
@Scope("singleton")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private DataSource dataSource;

    @Override
    public void save(Goods goods) {
        System.out.println("save");
        goodsDao.save(goods);
    }

    @Override
    public void delete(Goods goods) {
        System.out.println("delete");
        goodsDao.delete(goods);
    }

    @Override
    public void search() {
        System.out.println("search");
        goodsDao.search();
    }

    @Override
    public void update(Goods goods) {
        System.out.println("update");
        goodsDao.update(goods);
    }
}
