package com.geekaca.d3.ifhomework;

public class Jishuhe {
    public static void main(String[] args) {
        /**
         * 求奇数和
         */
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if(i % 2 == 1){
//                sout 是IDEA的快捷键
                //打印并换行
                System.out.println("奇数："+ i);
                sum += i;
//                sum = sum + i;
                //不换行
//                System.out.print(i +" ,");
            }
        }
        System.out.println("奇数和：" + sum);
    }
}
