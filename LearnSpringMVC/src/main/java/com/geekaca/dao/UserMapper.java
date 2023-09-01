package com.geekaca.dao;

import com.geekaca.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int selectUser(User user);
    int insertUser(User user);
}
