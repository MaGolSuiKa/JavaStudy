package com.geekaca.service.impl;

import com.geekaca.dao.BookDao;
import com.geekaca.service.BrandService;

public class BrandServiceImpl implements BrandService {
    private BookDao bookDao;

    public BrandServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * 构造器方式注入
     */
    @Override
    public int save() {

        return bookDao.bookSave();
    }
}
