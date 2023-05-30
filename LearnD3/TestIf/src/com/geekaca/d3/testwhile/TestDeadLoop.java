package com.geekaca.d3.testwhile;

import java.util.Scanner;

public class TestDeadLoop {
    public static void main(String[] args) {
        /**
         * 密码 输入，直到正确为止
         */
        int pass = 5200;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入密码：");
            int input = scanner.nextInt();

            if (input == pass) {
                System.out.println("输入密码正确");
                //终止循环
                break;
            } else {
                System.out.println("密码错误");
            }
        }
    }
}
