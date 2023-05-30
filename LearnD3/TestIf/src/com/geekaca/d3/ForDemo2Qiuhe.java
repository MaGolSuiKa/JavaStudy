package com.geekaca.d3;

public class ForDemo2Qiuhe {
    public static void main(String[] args) {
        /**
         * 1-5求和
         */
        //保存求和的结果
        int sum = 0;
        for (int i = 0; i <= 5; i++) {
            //定义在这里的变量，作用域（能够被使用的范围） 只在大括号内部
//            int sum = 0; //不能定义此处
//            sum = sum + i;
            sum += i;
            System.out.println(i + " 当前sum：" + sum);
        }
        System.out.println("1-5求和结果：" + sum);
    }
}
