package com.geekaca.service.impl;

import com.geekaca.dao.UserMapper;
import com.geekaca.domain.User;
import com.geekaca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(User user) {
       int i = userMapper.selectUser(user);
       return i;
    }

    @Override
    public int register(User user) {
        int i = userMapper.insertUser(user);
        return i;
    }
}
