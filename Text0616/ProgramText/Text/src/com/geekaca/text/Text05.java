package com.geekaca.text;

public class Text05 {
    public static void main(String[] args) {
//        double height = 200.3;
//        int myHeight = height;
        //height 的类型为double 无法直接转换为int
        // 可以进行手动强制类型转换
        double height = 200.3;
        int myHeight = (int)height;
    }
}
