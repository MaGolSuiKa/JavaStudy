package com.geekaca.newsproject.config;

import com.geekaca.newsproject.utils.NewsConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private AdminLoginInterceptor adminLoginInterceptor;

    //注册拦截器    浏览器->拦截器-> 接口
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //设置拦截规则
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/admin/**")
                //排除，放行哪些路径
                .excludePathPatterns("/admin/dologin")//管理员登陆页面
                .excludePathPatterns("/admin/dist/**")//静态页面
                .excludePathPatterns("/admin/plugins/**");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // http://localhost/upload/20230912_15591810.png
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + NewsConstants.UPLOAD_PATH);
    }
}
