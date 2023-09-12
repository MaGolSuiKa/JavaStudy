package com.geekaca.newsproject.service;

import com.geekaca.newsproject.domain.News;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface NewsService {
    public boolean save(News news);
    public boolean update(News news);
    public boolean delete(Long id);
    public News getById(Long id);

    public News getByIdWithComment(Long id);
    public List<News> getAll();
    public List<News> getByInput(String input);
}
