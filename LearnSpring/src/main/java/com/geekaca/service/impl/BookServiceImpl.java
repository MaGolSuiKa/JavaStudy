package com.geekaca.service.impl;

import com.geekaca.dao.BookDao;
import com.geekaca.service.BookService;

public class BookServiceImpl implements BookService {
    // 成员变量，引用类型  默认是null
    private BookDao bookDao;
    //Spring 默认调用无参构造器
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookServiceImpl() {
        System.out.println("BookServiceImpl()");
    }


    //Spring调用，把需要的DAO对象注入进来
    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
        System.out.println("setBookDao..");
    }
    @Override
    public int save() {
        System.out.println("bookServiceImpl save...");
        int i = bookDao.bookSave();
        return i;
    }

    public void myInit(){
        System.out.println("myInit");
    }

    public void myDestory(){
        System.out.println("myDestory");
    }
}
