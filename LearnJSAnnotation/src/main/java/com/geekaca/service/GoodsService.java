package com.geekaca.service;

import com.geekaca.domain.Goods;

import java.util.List;

public interface GoodsService {

    public void save(Goods goods);
    public void del(Goods goods);
    public List<Goods> search();
    public void change(Goods goods);
}
