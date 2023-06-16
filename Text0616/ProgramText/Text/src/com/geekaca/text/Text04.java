package com.geekaca.text;

import java.util.Random;

public class Text04 {
    public static void main(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(22) + 79;
        System.out.println("随机数是：" + rand);
    }
}
