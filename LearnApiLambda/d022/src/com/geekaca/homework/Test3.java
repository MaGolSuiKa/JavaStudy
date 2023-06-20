package com.geekaca.homework;

import java.time.LocalDate;

public class Test3 {
    public static void main(String[] args) {
        /**
         * 3，计算2023年有多少个星期二
         */
        LocalDate start = LocalDate.of(2023, 01, 01);

        int count = 0;
        for (int i = 0; i < 365; i++) {
            LocalDate tempDate = start.plusDays(i);
            if (tempDate.getDayOfWeek().getValue() == 2) {
                count++;
            }
        }
        System.out.println("2023年有" + count + "个星期二");
    }
}
