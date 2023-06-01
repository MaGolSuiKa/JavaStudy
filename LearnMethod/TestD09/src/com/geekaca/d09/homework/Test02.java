package com.geekaca.d09.homework;

public class Test02 {
    public static void main(String[] args) {
        int[] scores = {72, 89, 65, 87, 91, 82, 71, 93, 76, 68};

        System.out.println("平均成绩为：" + arrAverage(scores));
    }

    public static double arrAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }
}
