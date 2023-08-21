package com.geekaca.mapper;


import com.geekaca.pojo.Type;

import java.util.List;

public interface TypeMapper {
    //添加
    int insertType(Type type);
    //修改
    int updateType(Type type);
    //查询
    List<Type> selectAll();
    //
    List<Type> selectBy(String input);
}
