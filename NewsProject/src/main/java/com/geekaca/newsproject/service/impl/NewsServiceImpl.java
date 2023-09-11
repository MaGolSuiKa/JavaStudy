package com.geekaca.newsproject.service.impl;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.mapper.NewsMapper;
import com.geekaca.newsproject.service.NewsService;
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
}
