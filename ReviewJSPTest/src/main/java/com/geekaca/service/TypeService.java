package com.geekaca.service;

import com.geekaca.mapper.TypeMapper;
import com.geekaca.pojo.Type;
import com.geekaca.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class TypeService {
    public int addType(Type type){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        int i = typeMapper.insertType(type);
        sqlSession.close();
        return i;
    }

    public int updateType(Type type){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        int i = typeMapper.updateType(type);
        sqlSession.close();
        return i;
    }
}
