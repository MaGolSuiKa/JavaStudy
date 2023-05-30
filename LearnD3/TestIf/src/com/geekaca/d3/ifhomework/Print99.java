package com.geekaca.d3.ifhomework;

public class Print99 {
    public static void main(String[] args) {
        /**
         * 1* 1 = 1
         * 1* 1 = 1 2* 2=4
         * 1×9=9	2×9=18	3×9=27	4×9=36	5×9=45	6×9=54	7×9=63	8×9=72	9*9=81
         *
         * 不变 的9
         * 循环9 次
         * i 控制的是行
         * j 控制每一行的内部打印 每行 多个列
         */
        for (int i = 1; i <= 9; i++) {
            //i =1  只有一列  ，下面循环只会执行一次  输出 1*1=1
            // i = 2 时候
            for (int j = 1; j <= i; j++) {
                //j = 1   1 * 2 = 1   1*2=2
                //j = 2   2 * 2 = 4

                System.out.print(j + "*"+ i +"="+ (j * i) + " ");
            }
            //每打印完一行后，换行
            System.out.println("");
        }
        //电影院 有9排座位，
        //第一排 坐一个人
        //第二排坐2个人
//        第三排 坐3个人

    }
}
