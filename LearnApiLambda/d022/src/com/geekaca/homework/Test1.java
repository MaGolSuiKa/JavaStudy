package com.geekaca.homework;

import java.time.Duration;
import java.time.LocalDateTime;

public class Test1 {
    public static void main(String[] args) {
        /**
         * 1，计算1997-10-01 到 今天有多少天多少秒
         */
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime timeOfTarget = LocalDateTime.of(1997, 10, 1, 0, 0, 0);
        Duration duration = Duration.between(timeOfTarget, nowTime);
        long seconds = duration.toSeconds();
        long days = duration.toDays();

        System.out.println("1997-10-01 到 今天有 " + days + " 天," + seconds + " 秒");
    }
}
