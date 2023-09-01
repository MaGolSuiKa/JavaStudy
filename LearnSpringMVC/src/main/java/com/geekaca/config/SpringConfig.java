package com.geekaca.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

//只负责 Spring 核心容器 配置
@Configuration
//只负责 核心容器管理的bean 注解的 扫描，controller不归SpringMVC管
@ComponentScan(value = "com.geekaca", excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Controller.class
))
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}
