package com.geekaca.service;

import com.geekaca.domain.Goods;

public interface GoodsService {
    public void save(Goods goods);
    public void delete(Goods goods);
    public void search();
    public void update(Goods goods);
}
