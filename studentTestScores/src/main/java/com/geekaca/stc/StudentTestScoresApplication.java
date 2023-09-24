package com.geekaca.stc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.geekaca.stc.mapper")
public class StudentTestScoresApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentTestScoresApplication.class, args);
    }

}
