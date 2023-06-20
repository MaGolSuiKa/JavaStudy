package com.geekaca.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
    public static void main(String[] args) {
        /**
         * 2，设计一个函数，参数是两个字符串 开始时间和结束时间
         * String startTime , String endTime
         * 计算 返回 相差多少秒
         */
        String startTime = "15:12:13";
        String endTime = "16:10:11";
        countSecond(startTime, endTime);

    }

    public static void countSecond(String start, String end) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date startTime;
        Date endTime;
        long second = 0;

        try {
            startTime = dateFormat.parse(start);
            endTime = dateFormat.parse(end);
            long timeS = startTime.getTime();
            long timeE = endTime.getTime();
            second = (timeE - timeS) / (1000);
            System.out.println(start + "与" + end + "相差" + second + "秒");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
