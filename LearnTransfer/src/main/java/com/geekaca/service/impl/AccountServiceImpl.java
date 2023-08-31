package com.geekaca.service.impl;

import com.geekaca.dao.AccountMapper;
import com.geekaca.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void transfer(String acNameOut, String acNameIn, Double money) {
        //
        accountMapper.outMoney(acNameOut, money);
        //int i = 1 / 0;  //中间发生异常，
        accountMapper.inMoney(acNameIn, money);
    }

    @Override
    public void transPoint() {

    }

}
