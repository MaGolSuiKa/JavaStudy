package com.geekaca.web.mapper;

import com.geekaca.web.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int selectByUsernamePass(User user);

    int insertUser(User user);
    int selectUserName(User user);
    List<User> selectUserByName(@Param("username") String userName);
}
