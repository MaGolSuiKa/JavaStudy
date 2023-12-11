package com.geekaca.studentclasssystem;

import com.geekaca.studentclasssystem.domain.Student;
import com.geekaca.studentclasssystem.mapper.StudentMapper;
import com.geekaca.studentclasssystem.service.AttService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentClassSystemApplicationTests {
    @Autowired
    private AttService attService;
    @Autowired
    private StudentMapper studentMapper;
    @Test
    void testGetClassListByStu() {
        // 测试获取学生列表
        List<Student> classListByStu = studentMapper.getClassListByStu(1l);
        Assertions.assertNotNull(classListByStu);
    }

    @Test
    void contextLoads() {
    }




}
