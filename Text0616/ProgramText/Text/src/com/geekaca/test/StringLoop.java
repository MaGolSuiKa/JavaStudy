package com.geekaca.test;

public class StringLoop {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Hello";
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            str += i;
        }
        long end1 = System.currentTimeMillis();
        System.out.println("String 添加10万次花费" + (double) (end1 - start1) / 1000 + "秒");

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(i);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Stringbuilder 添加10万次花费" + (double) (end2 - start2) / 1000 + "秒");
    }
}
