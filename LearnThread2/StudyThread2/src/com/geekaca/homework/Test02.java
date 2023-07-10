package com.geekaca.homework;

//2，使用定时器，定时,间隔1秒输出 当前时间 格式： 2023-07-07 12:09:08

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test02 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalDateTime nowTime = LocalDateTime.now();
                String time = dtf.format(nowTime);
                System.out.println(time);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }


}
