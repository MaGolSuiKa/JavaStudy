package com.geekaca.test02;

public class Test02 {
    public static void main(String[] args) {
        Teachers teachers = new Teachers();
        teachers.setNames("张");
        teachers.setAges(45);
        teachers.setSectorName("教导处");

        Students students = new Students();
        students.setNames("赵");
        students.setAges(16);
        students.setClassName("一班");

        System.out.println(teachers);
        teachers.makeHomework();
        teachers.check();
        System.out.println(students);
        students.feedback();
        students.check();

        System.out.println("-------------------");
        //静态方法和属性，是公共的
        Students.hello();
        Teachers.hello();
        students.hello();
        teachers.hello();
    }
}
