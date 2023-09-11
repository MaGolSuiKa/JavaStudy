package com.geekaca.newsproject;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.domain.NewsComment;
import com.geekaca.newsproject.mapper.NewsMapper;
import com.geekaca.newsproject.service.NewsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class NewsProjectApplicationTests {


    @Autowired
    private NewsMapper newsMapper;

    @Test
    void testSelectAll() {
        News news = newsMapper.selectByPrimaryKey(5L);
        Assertions.assertNotNull(news);
        System.out.println(news);
    }

    @Test
    void testSelectAllNews() {
        List<News> newsList = newsMapper.selectAll();
        Assertions.assertNotNull(newsList);
        Assertions.assertTrue(newsList.size()>0);
        newsList.forEach((news)->{
            System.out.println(news);
        });
    }

    @Test
    public void testGetById(){
        News news = newsMapper.selectByIdWithComment(6L);
        Assertions.assertNotNull(news);
        System.out.println(news);
        List<NewsComment> commentList = news.getCommentList();
        Assertions.assertNotNull(commentList);
        Assertions.assertTrue(commentList.size() > 0);
        System.out.println(commentList);
    }

    @Test
    public void testSelectByInput(){
        List<News> newsList = newsMapper.selectByInput("Hello");
        Assertions.assertNotNull(newsList);
        Assertions.assertTrue(newsList.size()>0);
        newsList.forEach((news)->{
            System.out.println(news);
        });
    }
}
