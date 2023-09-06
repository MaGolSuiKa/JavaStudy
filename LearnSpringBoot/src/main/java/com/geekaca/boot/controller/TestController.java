package com.geekaca.boot.controller;


import com.geekaca.boot.domain.TestTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${testtarget.name}")
    private String name;
    @Value("${testtarget.subject[1]}")
    private String subject_1;

    @Autowired
    private Environment environment;
    @Autowired
    private TestTarget tt;

    @GetMapping("/{input}")
    public String getInput(@PathVariable Integer input) {
        System.out.println("input : " + input);
        System.out.println(name);
        System.out.println(subject_1);
        System.out.println(tt);
        System.out.println("-------");
        System.out.println(environment.getProperty("testtarget.id"));
        System.out.println(environment.getProperty("testtarget.subject[0]"));
        System.out.println(environment.getProperty("testtarget.subject[1]"));
        System.out.println(environment.getProperty("testtarget.subject[2]"));
        return "hello , spring boot!";
    }

    @GetMapping("hello")
    public String hello() {
        System.out.println("hello");
        return "hello ";
    }
}
