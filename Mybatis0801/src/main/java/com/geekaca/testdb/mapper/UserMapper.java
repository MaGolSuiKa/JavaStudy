package com.geekaca.testdb.mapper;

import com.geekaca.testdb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int updateUser(User user);
    int deleteById(@Param("userid") Integer id);
    List<User> selectById(@Param("userIds") Integer[] ids);
    List<User> loginByUser(User user);
}
