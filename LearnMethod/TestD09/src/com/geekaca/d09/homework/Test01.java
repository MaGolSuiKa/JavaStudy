package com.geekaca.d09.homework;

import java.util.Arrays;
import java.util.Random;

public class Test01 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        String[] a = new String[3];
        makeArray(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("所有元素和为：" + arrSum(arr));
    }

    public static void makeArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    public static int arrSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
