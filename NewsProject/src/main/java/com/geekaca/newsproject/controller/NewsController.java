package com.geekaca.newsproject.controller;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.service.NewsService;
import com.geekaca.newsproject.utils.ResultCode;
import com.geekaca.newsproject.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService ns;

    @RequestMapping("/all")
    public String getAll(HttpServletRequest req){
        List<News> allNews = ns.getAll();
        req.setAttribute("all", allNews);
        return "newsList";
    }

    @GetMapping("/toPage")
    public String toPage(HttpServletRequest req){
        req.setAttribute("name", "Tom");
        //要用@Controller 跳转到名字为hello的页面
        return "hello";
    }

    @GetMapping("/newsDetail/{newsID}")
    public String toDetail(HttpServletRequest request, @PathVariable("newsID") Long newsID){
        News news = ns.getById(newsID);
        request.setAttribute("newsInfo", news);
        return "newsDetail";
    }
}
