package com.geekaca.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class TestSearch {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("20180302", "叶孤城", 23, "护理一班"));
        studentArrayList.add(new Student("20180303", "东方不败", 23, "推拿二班"));
        studentArrayList.add(new Student("20180304", "西门吹雪", 26, "中药学四班"));
        studentArrayList.add(new Student("20180305", "梅超风", 26, "神经科2班"));
        arrayListSearch(studentArrayList);
    }

    public static void arrayListSearch(ArrayList<Student> arrayList) {
        Scanner scanner = new Scanner(System.in);
        boolean ifFind = false;
        while (true) {
            System.out.println("请输入查找内容：");
            String intput = scanner.next();

            for (int i = 0; i < arrayList.size(); i++) {
                Student student = arrayList.get(i);
                if ((student.getStuNum().contains(intput))) {
                    System.out.println(arrayList.get(i));
                    ifFind = true;
                }
                if ((student.getName().contains(intput))) {
                    System.out.println(arrayList.get(i));
                    ifFind = true;
                }
            }
            if (!ifFind) {
                System.out.println("没有找到");
            }
        }
    }

}
