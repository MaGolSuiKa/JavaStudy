package com.geekaca.service;

import com.geekaca.domain.User;

public interface UserService {
    public int login(User user);
    public int register(User user);
}
