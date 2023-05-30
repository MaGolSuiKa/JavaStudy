package com.geekaca.d3.testwhile;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        /**
         * 学习Random
         * 10以下  100以下  从0开始
         *
         * 30~100 随机数
         */

        Random random = new Random();
        //生成一个随机数 ,范围 [代表包含起点  [0 ~ 10)   ) 代表不包含
        //0~9
//        for (int i = 0; i < 5; i++) {
//            int rand = random.nextInt(10);
//            System.out.println(rand);
//        }
        //要生成 30~100 随机数
        /**
         * 1, 减法   100-30 = 70
         * 2， 30 + random(70)
         */
        int rand30 = 30 + random.nextInt(70);
        System.out.println(rand30);
    }
}
