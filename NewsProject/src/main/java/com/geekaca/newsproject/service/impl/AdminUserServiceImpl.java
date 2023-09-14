package com.geekaca.newsproject.service.impl;

import com.geekaca.newsproject.domain.AdminUser;
import com.geekaca.newsproject.mapper.AdminUserMapper;
import com.geekaca.newsproject.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private AdminUserMapper userMapper;

    @Override
    public AdminUser login(String username, String password) {
        AdminUser user = userMapper.login(username, password);
        return user;
    }
}
