package com.geekaca.work.homework;

public class TestMain {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("张", 40, '女');

        Student student1 = new Student("赵", "A班");
        Student student2 = new Student("钱", "A班");
        Student student3 = new Student("孙", "A班");

        ExamPapers examPaper1 = teacher.makeTest(student1.name);
        ExamPapers examPaper2 = teacher.makeTest(student2.name);
        ExamPapers examPaper3 = teacher.makeTest(student3.name);

        student1.doTest(examPaper1);
        student2.doTest(examPaper2);
        student3.doTest(examPaper3);

        teacher.checkTest(examPaper1);
        teacher.checkTest(examPaper2);
        teacher.checkTest(examPaper3);
    }
}
