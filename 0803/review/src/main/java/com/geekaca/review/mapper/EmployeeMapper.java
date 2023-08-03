package com.geekaca.review.mapper;

import com.geekaca.review.pojo.Employee;
import com.geekaca.review.pojo.EmployeeDept;

import java.util.List;

public interface EmployeeMapper {
    //查询所有
    List<Employee> selectAll();

    //修改类的用int 作为返回值
    int updateNameById(Employee emp);

    int insert(Employee employee);
    //多表查询
    List<EmployeeDept> selectFromAll();
}
