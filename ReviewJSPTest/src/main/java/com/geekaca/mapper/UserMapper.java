package com.geekaca.mapper;

import com.geekaca.pojo.User;

public interface UserMapper {
    //用户名和密码登陆验证
    int selectByUnamePass(User user);

    //注册
    int insertUser(User user);

    //检测同名
    int selectUserName(User user);
}
