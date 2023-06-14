package com.geekaca.atm;

import java.util.ArrayList;

public class AccountList {
    private static AccountList instance= new AccountList();
    private static ArrayList<Account> accountList = new ArrayList<>();

    private AccountList(){}

    public static AccountList getInstance(){
        return instance;
    }
    public static ArrayList<Account> getList(){
        return accountList;
    }


}
