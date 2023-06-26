package com.geekaca.d06.homework;

import java.util.Map;
import java.util.TreeMap;

public class Test02 {
    public static void main(String[] args) {
        String strs = "aababcabcdabcde";
        Map<Character, Integer> maps = new TreeMap<>();

        for (char c : strs.toCharArray()) {
            if (maps.containsKey(c)) {
                Integer valueCount = maps.get(c);
                valueCount++;
                maps.put(c, valueCount);
            }else {
                maps.put(c,1);
            }
        }

       maps.forEach((key,value)->{
           System.out.println(key+":"+value);
       });
    }
}
