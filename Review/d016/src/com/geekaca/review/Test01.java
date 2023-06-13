package com.geekaca.review;

import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {
        String names = "张无忌,张三丰,刘德华,周芷若";
        String[] arr = names.split(",");
        ArrayList<Account> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            Account account = new Account(arr[i]);
            arrayList.add(account);
        }
        boolean isFound = false;
        for (int i = 0; i < arrayList.size(); i++) {
            Account acc = arrayList.get(i);
            if (acc.getName().startsWith("张")) {
                System.out.println(acc);
                isFound = true;
            }
        }
        if(!isFound){
            System.out.println("未找到");
        }
    }
}
