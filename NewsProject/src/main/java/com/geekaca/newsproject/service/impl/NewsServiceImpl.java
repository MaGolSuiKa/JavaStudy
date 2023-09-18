package com.geekaca.newsproject.service.impl;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.mapper.NewsMapper;
import com.geekaca.newsproject.mapper.NewsTagMapper;
import com.geekaca.newsproject.mapper.NewsTagRelationMapper;
import com.geekaca.newsproject.service.NewsService;
import com.geekaca.newsproject.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper nm;
    @Autowired
    private NewsTagMapper ntm;
    @Autowired
    private NewsTagRelationMapper ntrm;

    @Override
    public List<News> getAllNews() {
        return nm.selectAll();
    }

    @Override
    public News getById(Long newsID) {
        News news = nm.selectNewsAndCommentsById(newsID);
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

    @Override
    public boolean saveNews(News news) {
        return false;
    }

    @Override
    public int updateNewsViews(Long newsId) {
        int i = nm.increateViews(newsId);
        return i;
    }
}
