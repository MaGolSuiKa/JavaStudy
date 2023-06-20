package com.geekaca.homework;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test4 {
    public static void main(String[] args) {
        /**
         * 4，从现在开始，每隔23天输出一下日期，输出5次
         */
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 5; i++) {
            int nextDay = 23 * (1 + i);
            LocalDateTime nextDate = date.plusDays(nextDay);
            System.out.println(nextDay+"天后：" + dtf.format(nextDate));
        }
    }
}
