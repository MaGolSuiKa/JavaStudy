package com.geekaca.d3;

public class ForDemo3 {
    public static void main(String[] args) {
        /**
         * 打印1-10 的奇数
         *
         * %2  余数1
         */
        for (int i = 1; i <= 30; i++) {
            //余数
            int rs = i % 2;
            if (rs == 1){
                System.out.println(i + "是奇数");
            }
        }
    }
}
