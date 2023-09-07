package com.geekaca.service.impl;

import com.geekaca.controller.Code;
import com.geekaca.dao.BookDao;
import com.geekaca.domain.Book;
import com.geekaca.exception.BusinessException;
import com.geekaca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    public boolean delete(Integer id) {
        return bookDao.delete(id) > 0;
    }

    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<Book> getByInput(String input) {
        return bookDao.getByInput(input);
    }
}
