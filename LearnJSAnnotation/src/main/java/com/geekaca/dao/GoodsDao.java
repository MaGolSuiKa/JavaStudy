package com.geekaca.dao;

import com.geekaca.domain.Goods;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsDao {
    public void save(Goods goods);
    public void delete(Goods goods);
    public void search();
    public void update(Goods goods);
}
