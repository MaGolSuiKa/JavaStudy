package com.geekaca.newsproject.controller;

import com.geekaca.newsproject.domain.News;
import com.geekaca.newsproject.service.NewsService;
import com.geekaca.newsproject.utils.Code;
import com.geekaca.newsproject.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService ns;

    @PostMapping
    public Result save(@RequestBody News news) {
        boolean flag = ns.save(news);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody News news){
        boolean flag = ns.update(news);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        boolean flag = ns.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        News news = ns.getById(id);
        Integer code = news != null ? Code.GET_OK : Code.GET_ERR;
        String msg = news != null ? "" : "数据查询失败，请重试！";
        return new Result(code,news,msg);
    }

    @GetMapping("/find/{id}")
    public Result getByIdWithComment(@PathVariable Long id){
        News news = ns.getByIdWithComment(id);
        Integer code = news != null ? Code.GET_OK : Code.GET_ERR;
        String msg = news != null ? "" : "数据查询失败，请重试！";
        return new Result(code,news,msg);
    }

    //@GetMapping("/all")
    @RequestMapping("/all")
    public Result getAll(){
        List<News> newsList = ns.getAll();
        Integer code = newsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = newsList != null ? "" : "数据查询失败，请重试！";
        return new Result(code,newsList,msg);
    }

    @GetMapping("/search/{input}")
    public Result getByInput(@PathVariable String input){
        List<News> newsList = ns.getByInput(input);
        Integer code = newsList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = newsList != null ? "" : "数据查询失败，请重试！";
        return new Result(code,newsList,msg);
    }
}
