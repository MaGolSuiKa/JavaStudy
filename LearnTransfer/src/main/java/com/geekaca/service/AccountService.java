package com.geekaca.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AccountService {
    public void transfer(String out, String in, Double money);
    public void transPoint();
}
