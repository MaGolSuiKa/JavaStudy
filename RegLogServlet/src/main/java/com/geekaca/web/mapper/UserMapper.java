package com.geekaca.web.mapper;

import com.geekaca.web.pojo.User;

public interface UserMapper {
    int selectByUsernamePass(User user);

    int insertUser(User user);
}
