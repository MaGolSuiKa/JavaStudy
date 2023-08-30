package com.geekaca.service;

import com.geekaca.config.MySpringConfig;
import com.geekaca.domain.Goods;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        //获取一个注解方式声明的IOC容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MySpringConfig.class);

        //title, price
        Goods goods1 = new Goods("蔬菜",10.5);

        GoodsService goodsService = (GoodsService) ctx.getBean("goodsService");
        goodsService.save(goods1);
        //goodsService.search();
    }
}
