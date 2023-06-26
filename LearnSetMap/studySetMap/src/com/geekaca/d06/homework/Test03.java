package com.geekaca.d06.homework;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        String[] name = new String[30];
        Random random = new Random();
        Map<String, List<String>> studentSelect = new HashMap<>();

        Map<String, Integer> allSelect = new HashMap<>();

        for (int i = 0; i < 30; i++) {
            name[i] = ("Student" + i);
            int slt = random.nextInt(10);//只计算了选一种或两种的情况
            List<String> des = new ArrayList<>();
            switch (slt) {
                case 0:
                    des.add("A");
                    break;
                case 1:
                    des.add("B");
                    break;
                case 2:
                    des.add("C");
                    break;
                case 3:
                    des.add("D");
                    break;
                case 4:
                    des.add("A");
                    des.add("B");
                    break;
                case 5:
                    des.add("A");
                    des.add("C");
                    break;
                case 6:
                    des.add("A");
                    des.add("D");
                    break;
                case 7:
                    des.add("B");
                    des.add("C");
                    break;
                case 8:
                    des.add("B");
                    des.add("D");
                    break;
                case 9:
                    des.add("C");
                    des.add("D");
                    break;
                default:
                    break;
            }
            studentSelect.put(name[i], des);
        }
        //一个键对应多个值完成
        studentSelect.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        /**
         * 如何统计？
         * 单选时，值做键，键做值
         */
        for (int i = 0; i < studentSelect.size(); i++) {

            for (String selectKey : studentSelect.get("Student" + i)) {
                if (allSelect.containsKey(selectKey)) {
                    allSelect.put(selectKey, allSelect.get(selectKey) + 1);
                } else {
                    allSelect.put(selectKey, 1);
                }
            }
        }
        System.out.println("投票结果：" + allSelect);

    }

}
