package com.geekaca.d05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class TestList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList();

        long startArr1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add("Tom" + i);
        }
        long endArr1 = System.currentTimeMillis();
        long lastTimeArr1 = endArr1 - startArr1;
        System.out.println("ArrayList创建消耗时间：" + lastTimeArr1 + "ms");

        long startLink1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add("Tom" + i);
        }
        long endLink1 = System.currentTimeMillis();
        long lastTimeLink1 = endLink1 - startLink1;
        System.out.println("Linklist创建消耗时间：" + lastTimeLink1 + "ms");

        Random random = new Random();
        long startArr2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(10000 - i);
            arrayList.remove(index);
        }
        long endArr2 = System.currentTimeMillis();
        long lastTimeArr2 = endArr2 - startArr2;
        System.out.println("ArrayList删除消耗时间：" + lastTimeArr2 + "ms");

        long startLink2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(10000 - i);
            linkedList.remove(index);
        }
        long endLink2 = System.currentTimeMillis();
        long lastTimeLink2 = endLink2 - startLink2;
        System.out.println("LinkList删除消耗时间：" + lastTimeLink2 + "ms");


        long startArr3 = System.currentTimeMillis();
        for (String item : arrayList) {
            for (int i = 0; i < 50; i++) {
                if (("Tom" + 5555 + i).equals(item)) {
                    System.out.println(item);
                }
            }
        }
        long endArr3 = System.currentTimeMillis();
        long lastTimeArr3 = endArr3 - startArr3;
        System.out.println("Arrlist查找消耗时间：" + lastTimeArr3 + "ms");

        long startLink3 = System.currentTimeMillis();
        for (String item : linkedList) {
            for (int i = 0; i < 50; i++) {
                if (("Tom" + 5555 + i).equals(item)) {
                    System.out.println(item);
                }
            }
        }
        long endLink3 = System.currentTimeMillis();
        long lastTimeLink3 = endLink3 - startLink3;
        System.out.println("Linklist查找消耗时间：" + lastTimeLink3 + "ms");
    }
}
