package com.geekaca.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    //注入 来自.properties文件的属性
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 手动创建 一个连接池的对象
     * 交给Spring容器管理
     *
     * 后续，如果Spring发现哪里需要用，依赖连接池对象，就会直接使用这个对象(单例的)
     * @return
     */
    @Bean
    public DataSource dataSource(){
        //创建数据源  连接池  Druid
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
