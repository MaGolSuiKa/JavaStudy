package com.geekaca.d008.homework;

import java.util.Arrays;
import java.util.Random;

public class TestRandomName {
    public static void main(String[] args) {
        String[] names = {"Ana", "Bob", "Coco", "Dave", "Ema"};
        System.out.println(Arrays.toString(names));
        System.out.println("=======打乱=======");
        Random random = new Random();
        for (int i = 0; i < names.length; i++) {
            int index = random.nextInt(names.length);

            String tmp = names[i];
            names[i] = names[index];
            names[index] = tmp;
        }
        System.out.println(Arrays.toString(names));
    }
}