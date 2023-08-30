package com.geekaca.service.impl;

import com.geekaca.dao.GoodsMapper;
import com.geekaca.domain.Goods;
import com.geekaca.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service("goodsService")
@Scope("singleton")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private DataSource dataSource;

    @Override
    public void save(Goods goods) {
        System.out.println("save");
        goodsMapper.insert(goods);
    }


    @Override
    public void del(Goods goods) {
        System.out.println("delete");
        goodsMapper.delete(goods.getId());
    }

    @Override
    public List<Goods> search() {
        System.out.println("search");
        return  goodsMapper.select();
    }

    @Override
    public void change(Goods goods) {
        System.out.println("update");
        goodsMapper.update(goods);
    }
}
