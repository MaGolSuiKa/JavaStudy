package com.geekaca.work.homework;


public class Teacher {
    public String name;
    public int age;
    public char sex;

    public Teacher(String teacherName, int teacherAge, char teacherSex) {
        name = teacherName;
        age = teacherAge;
        sex = teacherSex;
    }

    public ExamPapers makeTest(String stuName) {
        System.out.println(name + "老师给" + stuName + "同学发了试卷");
        ExamPapers examPapers = new ExamPapers(stuName);
        examPapers.correctAnswer = 3;

        return examPapers;
    }

    public void checkTest(ExamPapers examPaper) {
        System.out.print("老师批阅了试卷");
        if (examPaper.studentAnswer == examPaper.correctAnswer) {
            System.out.println(examPaper.studentName + "作答正确");
        } else {
            System.out.println(examPaper.studentName + "作答错误");
        }
    }
}
