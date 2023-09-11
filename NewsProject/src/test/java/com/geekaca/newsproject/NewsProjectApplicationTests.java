package com.geekaca.newsproject;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.mapper.NewsMapper;
import com.geekaca.newsproject.service.NewsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsProjectApplicationTests {

    @Autowired
    private NewsService ns;

    @Test
    public void testGetById(){
        News news = ns.getById(6l);
        System.out.println(news);
    }
    @Autowired
    private NewsMapper newsMapper;

    @Test
    void testSelectAll() {
        News news = newsMapper.selectByPrimaryKey(5L);
        Assertions.assertNotNull(news);
        System.out.println(news);
    }
}
