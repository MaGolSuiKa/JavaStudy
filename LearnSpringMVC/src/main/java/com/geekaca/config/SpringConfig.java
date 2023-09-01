package com.geekaca.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//只负责 Spring 核心容器 配置
@Configuration
//只负责 核心容器管理的bean 注解的 扫描，controller不归SpringMVC管
@ComponentScan({"com.geekaca.service"})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}
