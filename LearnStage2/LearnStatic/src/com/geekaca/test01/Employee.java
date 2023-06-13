package com.geekaca.test01;

public class Employee {
    private String name;
    private int age;
    private String dept;
    public static String company;


    public void showInfos() {
        System.out.println("Name:" + this.name);
        System.out.println("Age:" + this.age);
        System.out.println("Dept:" + this.dept);
        System.out.println("Company:" + company);
    }

    public static int compareByAge(Employee e1, Employee e2) {
        int age1 = e1.getAge();
        int age2 = e2.getAge();
        return (age1 > age2 ? age1 : age2);
    }

    public String getName() {
        showInfos();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public static String getCompany() {
        return company;
    }

    public static void setCompany(String company) {
        Employee.company = company;
    }


}
