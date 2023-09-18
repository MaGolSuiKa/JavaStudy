package com.geekaca.newsproject.service.impl;

import com.geekaca.newsproject.domain.NewsCategory;
import com.geekaca.newsproject.mapper.NewsCategoryMapper;
import com.geekaca.newsproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private NewsCategoryMapper categoryMapper;

    @Override
    public List<NewsCategory> getAllCategories() {
        return categoryMapper.searchAll();
    }
}
