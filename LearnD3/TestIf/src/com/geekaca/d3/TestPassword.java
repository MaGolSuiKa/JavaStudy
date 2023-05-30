package com.geekaca.d3;

import java.util.Scanner;

public class TestPassword {
    public static void main(String[] args) {
        /**
         * 测试输入密码比较
         */
        int myPasswd = 111111;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码：");
        //password
        int inputPwd = scanner.nextInt();
        if(inputPwd == myPasswd){
            System.out.println("密码正确");
        }else{
            System.out.println("密码错误");
        }
    }
}
