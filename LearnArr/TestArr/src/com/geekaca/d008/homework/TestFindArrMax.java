package com.geekaca.d008.homework;

import java.util.Arrays;
import java.util.Random;

public class TestFindArrMax {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        int maxNow = 0;
        int indexNow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (maxNow < arr[i]) {
                maxNow = arr[i];
                indexNow = i;
            }
        }
        System.out.println("数组最大值为：" + maxNow);
        System.out.println("最大值所在索引为：arr["+indexNow+"]");
    }
}
