package com.geekaca.newsproject.service;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.utils.PageResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NewsService {
    List<News> getAllNews();

    News getById(Long newsID);


    PageResult getPageNews(Integer pageNO, Integer pageSize);


    boolean saveNews(News news);
    //把文章的访问量+1
    int updateNewsViews(Long newsId);
}
