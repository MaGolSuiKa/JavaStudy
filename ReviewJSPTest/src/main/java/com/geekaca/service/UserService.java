package com.geekaca.service;


import com.geekaca.mapper.UserMapper;
import com.geekaca.pojo.User;
import com.geekaca.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public int findUser(User user){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.selectByUnamePass(user);
        sqlSession.close();
        return i;
    }

    public int searchUserName(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.selectUserName(user);
        sqlSession.close();
        return i;
    }

    public int addUser(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.insertUser(user);
        sqlSession.close();
        return i;
    }
}
