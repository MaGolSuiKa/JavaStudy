package com.geekaca.mapper;


import com.geekaca.pojo.Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeMapper {
    //添加
    int insertType(Type type);

    //修改
    int updateType(Type type);

    //查询
    List<Type> selectAll();

    //
    List<Type> selectBy(@Param("userInput") String input);

    List<Type> selectType();

    Type selectTypeName(@Param("typeId") Integer id);
}
