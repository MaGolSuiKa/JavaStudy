package com.geekaca.newsproject.service.impl;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.mapper.NewsMapper;
import com.geekaca.newsproject.service.NewsService;
import com.geekaca.newsproject.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper nm;

    @Override
    public boolean save(News news) {
        int insert = nm.insert(news);
        boolean isInsert = insert > 0;
        return isInsert;
    }

    @Override
    public boolean update(News news) {
        int i = nm.updateByPrimaryKey(news);
        boolean isUpdate = i > 0;
        return isUpdate;
    }

    @Override
    public boolean delete(Long id) {
        int i = nm.deleteByPrimaryKey(id);
        boolean isDel = i > 0;
        return isDel;
    }

    @Override
    public News getById(Long id) {
        News news = nm.selectByPrimaryKey(id);
        return news;
    }

    @Override
    public News getByIdWithComment(Long id) {
        News news = nm.selectByIdWithComment(id);
        return news;
    }

    @Override
    public List<News> getAll() {
        List<News> newsList = nm.selectAll();
        return newsList;
    }

    @Override
    public List<News> getByInput(String input) {
        List<News> news = nm.selectByInput(input);
        return news;
    }

    @Override
    public PageResult getPageNews(Integer pageNO, Integer pageSize) {
        int start = (pageNO - 1) * pageSize;
        List<News> newsList = nm.selectByPage(start, pageSize);
        int count = nm.selectNewsCount();
        PageResult pageResult = new PageResult(newsList, count, pageSize, pageNO);
        return pageResult;
    }
}
