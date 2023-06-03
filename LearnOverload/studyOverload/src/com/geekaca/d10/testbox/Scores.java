package com.geekaca.d10.testbox;

import java.util.Arrays;
import java.util.Scanner;

public class Scores {
    public static void main(String[] args) {
        int[] scores = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            while (true) {
                System.out.println(i + 1 + "号评委请打分(0-100)：");
                scores[i] = scanner.nextInt();
                if (scores[i] >= 0 && scores[i] <= 100) {
                    break;
                } else {
                    System.out.println("输入错误");
                }
            }

        }
        System.out.println(Arrays.toString(scores));
        System.out.println("去掉一个最高分，去掉一个最低分，选手的最终得分是：" + scoreOutput(scores));
    }

    public static double scoreOutput(int[] arr) {
        int max = 0;
        int min = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
            temp += arr[i];
        }
        return (temp - max - min) / (arr.length - 2);
    }
}
