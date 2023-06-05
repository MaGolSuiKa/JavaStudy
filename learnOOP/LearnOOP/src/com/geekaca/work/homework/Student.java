package com.geekaca.work.homework;

import java.util.Random;

public class Student {
    public String name;
    public String className;

    public Student(String stuName, String stuClass) {
        name = stuName;
        className = stuClass;
    }

    public void doTest(ExamPapers examPapers) {
        System.out.println(name + "同学作答完毕。");
        Random random = new Random();
        examPapers.studentAnswer = random.nextInt(4);
    }
}
