package com.geekaca;

import com.geekaca.dao.BookDao;
import com.geekaca.service.BookService;
import com.geekaca.service.BrandService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        testConstructor();
        testProperties();
        test();
    }

    public static void testConstructor(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BrandService brandService = (BrandService) ctx.getBean("brandService2");
        brandService.save();
    }

    public static void testProperties(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookD = (BookDao) ctx.getBean("bookD");
        bookD.show();
    }

    public static void test(){
        //3.获取IoC容器
        //Spring IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //向容器要对象，以后也基本不会自己new了
        //Teacher myTeacher = (Teacher) ctx.getBean("myTeacher");
        //myTeacher.sayHello();
        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
        //多次获取  默认返回同一个  单例模式
        BookService bookService2 = (BookService) ctx.getBean("bookService");
        System.out.println(bookService);
        System.out.println(bookService2);

        System.out.println(bookService == bookService2);

        //单例模式下（默认） 初始化方法只调用一遍
    }
}
