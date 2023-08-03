package com.geekaca.review.pojo;

public class EmployeeDept extends Employee{
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "EmployeeDept{" +
                "deptName='" + deptName + '\'' +
                ", ename='" + this.getEname() +'\'' +
                ", edate='" + this.getEdate() +'\'' +
                ", salary=" + this.getSalary() +
                ", height=" + this.getHeight() +
                ", deptId=" + this.getDeptId() +
                '}';
    }
}
