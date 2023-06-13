package com.geekaca.test01;

public class Test01 {
    public static void main(String[] args) {
        Employee employeeA = new Employee();
        employeeA.setName("Ana");
        employeeA.setAge(28);
        employeeA.setDept("yanfa");

        Employee.company = "IT";

        Employee employeeB = new Employee();
        employeeB.setName("Bob");
        employeeB.setAge(23);
        System.out.println("name:" + employeeB.getName());
        System.out.println("雇员B的公司：" + employeeB.company);

        employeeB.company = "极客咖";

        System.out.println("公司："+Employee.company);
        System.out.println("雇员A的公司："+employeeA.company);
        System.out.println("============");

        int maxAge = Employee.compareByAge(employeeA, employeeB);
        System.out.println(maxAge);
    }
}
