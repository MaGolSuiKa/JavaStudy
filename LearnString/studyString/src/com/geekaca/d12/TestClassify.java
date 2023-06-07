package com.geekaca.d12;

import java.util.Scanner;

public class TestClassify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String input = scanner.next();
        classify(input);
    }

    public static void classify(String str) {
        int alpNum = 0;
        int numNum = 0;
        for (int i = 0; i < str.length(); i++) {
            char charNow = str.charAt(i);
            if ((charNow >= 'a' && charNow <= 'z') || (charNow >= 'A' && charNow <= 'Z')) {
                alpNum++;
            }
            if (charNow >= '0' && charNow <= '9') {
                numNum++;
            }
        }
        System.out.println(str + "中字母：" + alpNum + "个，数字：" + numNum + "个。");
    }
}
//请编写程序，由键盘录入一个字符串，统计字符串中英文字母和数字分别有多少个。比如：Hello12345World中字母：10个，数字：5个。