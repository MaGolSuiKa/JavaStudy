package com.geekaca;

import com.geekaca.domain.Book;
import com.geekaca.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LearnSpringBootSsmApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private BookService bookService;

    @Test
    public void testGetById(){
        Book book = bookService.getById(2);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<Book> all = bookService.getAll();
        System.out.println(all);
    }

    @Test
    public void testGetByInput(){
        List<Book> list = bookService.getByInput("三");
        System.out.println(list);
    }
}
