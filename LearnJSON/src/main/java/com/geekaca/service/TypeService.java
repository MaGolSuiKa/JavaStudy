package com.geekaca.service;

import com.geekaca.mapper.TypeMapper;
import com.geekaca.pojo.Type;
import com.geekaca.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TypeService {


    public List<Type> searchType() {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        TypeMapper typeMapper = sqlSession.getMapper(TypeMapper.class);
        List<Type> types = typeMapper.selectType();
        sqlSession.close();
        return types;
    }

}
