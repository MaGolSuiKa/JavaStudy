package com.geekaca.mapper;

import com.geekaca.pojo.User;

public interface UserMapper {
    //用户名和密码登陆验证
    int selectByUnamePass(User user);
}
