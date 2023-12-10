package com.geekaca.studentclasssystem;

import com.geekaca.studentclasssystem.mapper.StudentMapper;
import com.geekaca.studentclasssystem.service.AttService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentClassSystemApplicationTests {
    @Autowired
    private AttService attService;
    @Autowired
    private StudentMapper studentMapper;
    @Test
    void testGetClassListByStu() {
        // 测试获取学生列表
        studentMapper.getClassListByStu(1l);
    }

    @Test
    void contextLoads() {
    }




}
