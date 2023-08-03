package com.geekaca.review;

import com.geekaca.review.mapper.EmployeeMapper;
import com.geekaca.review.pojo.Employee;
import com.geekaca.review.pojo.EmployeeDept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testSelect() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = mapper.selectAll();
        Assert.assertNotNull(employeeList);
        Assert.assertTrue(employeeList.size() > 0);
    }

    @org.junit.Test
    public void testUpdate() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象  开启自动事务提交，否则数据不会更新
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = new Employee();
        emp.setId(5);
        emp.setEname("流沙河");
        int updated = mapper.updateNameById(emp);
        Assert.assertTrue(updated > 0);
    }

    @org.junit.Test
    public void testInsert() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象  开启自动事务提交，否则数据不会更新
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp = new Employee();
        emp.setEname("弥勒佛");
        emp.setDeptId(1);
        emp.setEdate(LocalDate.now());
        emp.setHeight(177.0);
        emp.setSalary(40000);
        int updated = mapper.insert(emp);
        Assert.assertTrue(updated > 0);
        System.out.println(emp.getId());
        Assert.assertTrue(emp.getId() != null);
    }

    @org.junit.Test
    public void testSelectFromAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<EmployeeDept> employeeList = mapper.selectFromAll();
        Assert.assertNotNull(employeeList);
        Assert.assertTrue(employeeList.size() > 0);
        employeeList.forEach(employeeDept ->
            System.out.println(employeeDept)
        );
    }
}
