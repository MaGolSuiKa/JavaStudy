package com.geekaca.d06.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) {
        Map<String,String> studentsMapList = new HashMap<>();
        ArrayList<String> studentArrList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            studentsMapList.put("SID"+i,"Tom"+i);
            studentArrList.add("Tom"+i);
        }

        long startMap = System.currentTimeMillis();
        System.out.println("Tom11314是否存在：" + studentsMapList.containsValue("Tom11314"));
        long endMap = System.currentTimeMillis();
        long lastTimeMap = endMap - startMap;
        System.out.println("消耗了"+lastTimeMap+"ms");

        long startArr = System.currentTimeMillis();
        for (String name : studentArrList) {
            if("Tom11314".equals(name)){
                System.out.println("Tom11314找到了");
            }
        }
        long endArr = System.currentTimeMillis();
        long lastTimeArr = endArr - startArr;
        System.out.println("消耗了"+lastTimeArr+"ms");
    }
}
