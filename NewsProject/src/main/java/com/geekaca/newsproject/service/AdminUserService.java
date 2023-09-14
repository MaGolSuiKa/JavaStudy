package com.geekaca.newsproject.service;

import com.geekaca.newsproject.domain.AdminUser;

public interface AdminUserService {

    AdminUser login(String username, String password);
}
