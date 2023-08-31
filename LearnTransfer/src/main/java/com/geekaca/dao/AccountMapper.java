package com.geekaca.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    void outMoney(@Param("name")String name, @Param("money")Double money);

    void inMoney(@Param("name")String name, @Param("money")Double money);
}
