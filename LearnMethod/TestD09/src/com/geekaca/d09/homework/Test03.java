package com.geekaca.d09.homework;

public class Test03 {
    public static void main(String[] args) {
        double[] stock = {10.4, -3, -6.2, 1.2, -6.1, -19, -3.8, 0.9, -4.5, 5.5};
        findNegative(stock);
    }

    public static void findNegative(double[] arr) {
        int plusCount = 0;
        int minusCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 0) {
                minusCount++;
            } else {
                plusCount++;
            }
        }
        System.out.println("赚钱的股票一共有：" + plusCount + "只");
        System.out.println("赔钱的股票一共有：" + minusCount + "只");
    }
}
