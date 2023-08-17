package com.geekaca.service;

import com.geekaca.mapper.UserMapper;
import com.geekaca.pojo.User;
import com.geekaca.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public int searchUser(User user){
        SqlSession sqlSession = SqlSessionFactoryUtils.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.selectByUnamePass(user);
        sqlSession.close();
        return i;
    }
}
