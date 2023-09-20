package com.geekaca.newsproject.service.impl;

import com.geekaca.newsproject.domain.TagNewsCount;
import com.geekaca.newsproject.mapper.NewsTagMapper;
import com.geekaca.newsproject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagNewsServiceImpl implements TagService {
    @Autowired
    private NewsTagMapper tagMapper;

    @Override
    public List<TagNewsCount> getAll() {
        return tagMapper.selectTagNewsCounts();
    }
}
