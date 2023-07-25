package com.geekaca.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        testAdd("沙和尚","17500909",6000,190.25);
//        for (int i = 0; i < 100; i++) {
//            testAdd("猴分身"+i,"16900110",0,169);
//        }
//        testAddInput();
        //testSearch();
        testFuzzySearch();
        //testSelect();
    }

    public static void testAdd(String name,String date,double sal,double hei) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dbemp?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement stmt = connection.createStatement();
             ) {
            String sql = "insert into dongtu_emp(emp_name,joindate,salary,height)" +
                    " values('" + name + "', '" + date+ "'," + sal +","+hei+ ")";
            int updated = stmt.executeUpdate(sql);
            System.out.println("插入了记录数: " + updated);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void testAddInput() throws ClassNotFoundException {
        Scanner scanner= new Scanner(System.in);
        System.out.println("请输入姓名：");
        String nameInput = scanner.next();
        System.out.println("请输入工资");
        double salInput = scanner.nextDouble();
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dbemp?useSSL=false&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement stmt = connection.createStatement();
        ) {
            String sql = "insert into dongtu_emp(emp_name,salary)" +
                    " values('" + nameInput + "',  "+ salInput + ")";
            int updated = stmt.executeUpdate(sql);
            System.out.println("插入了记录数: " + updated);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void testSelect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbemp?useSSL=false&characterEncoding=utf8";
            String username = "root";
            String password = "123456";
            //建立连接
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from dongtu_emp";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("emp_name");
                String date = resultSet.getString("joindate");
                double salary = resultSet.getDouble("salary");
                double height = resultSet.getDouble("height");
                System.out.println("id:" + id + " name:" + name + " 加入时间：" + date + " 工资："
                        + salary + " 身高：" + height);
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void testSearch(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbemp?useSSL=false&characterEncoding=utf8";
            String username = "root";
            String password = "123456";
            //建立连接
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from dongtu_emp , dongtu_dept where dongtu_emp.dept_id = dongtu_dept.dept_id;";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("emp_name");
                String date = resultSet.getString("joindate");
                double salary = resultSet.getDouble("salary");
                double height = resultSet.getDouble("height");
                String dname= resultSet.getString("dept_name");
                System.out.println("id:" + id + " name:" + name + " 加入时间：" + date + " 工资："
                        + salary + " 身高：" + height+" 部门："+dname);
                //没有部门的没有显示
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void testFuzzySearch(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("请输入要搜索的内容：");
        String nameInput = scanner.next();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dbemp?useSSL=false&characterEncoding=utf8";
            String username = "root";
            String password = "123456";
            //建立连接
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from dongtu_emp , dongtu_dept where dongtu_emp.dept_id = dongtu_dept.dept_id and emp_name like '%"+nameInput+"%'";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("emp_name");
                String date = resultSet.getString("joindate");
                double salary = resultSet.getDouble("salary");
                double height = resultSet.getDouble("height");
                String dname= resultSet.getString("dept_name");
                System.out.println("id:" + id + " name:" + name + " 加入时间：" + date + " 工资："
                        + salary + " 身高：" + height+" 部门："+dname);
                //没有部门的没有显示
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}