package com.geekaca.d08;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestExThrow {

    public static void main(String[] args) {
        try {
            testException();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    //parse的异常，暂不处理，抛出去，谁调用，谁处理
    public static void testException() throws ParseException {
        String date = "2023年01-12 10:23:21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.parse(date);
    }
}
