package com.geekaca.config;

import org.springframework.context.annotation.*;

/**
 *
 * Spring 核心配置类，作用  等同于 applicationContext.xml
 * 声明当前类为Spring配置类
 */
@Configuration
/**
 * 告诉spring ioc容器，到指定的目录下，去搜索 注解，把对象管理起来
 */
@ComponentScan({"com.geekaca"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
//@EnableAspectJAutoProxy
public class MySpringConfig {

}
