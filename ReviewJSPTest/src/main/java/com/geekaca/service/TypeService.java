package com.geekaca.service;

import com.geekaca.mapper.TypeMapper;
import com.geekaca.pojo.Type;
import com.geekaca.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TypeService {
    public int addType(Type type) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        int i = typeMapper.insertType(type);
        sqlSession.close();
        return i;
    }

    public int updateType(Type type) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        int i = typeMapper.updateType(type);
        sqlSession.close();
        return i;
    }

    public List<Type> searchAll() {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        List<Type> types = typeMapper.selectAll();
        sqlSession.close();
        return types;
    }

    public List<Type> searchBy(String input) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        List<Type> types = typeMapper.selectBy(input);
        sqlSession.close();
        return types;
    }
}
