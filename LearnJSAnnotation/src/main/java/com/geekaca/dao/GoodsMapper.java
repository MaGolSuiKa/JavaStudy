package com.geekaca.dao;

import com.geekaca.domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    public void insert(Goods goods);
    public void delete(Integer id);
    List<Goods> select();
    public void update(Goods goods);
}
