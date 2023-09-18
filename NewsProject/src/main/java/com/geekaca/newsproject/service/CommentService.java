package com.geekaca.newsproject.service;


import com.geekaca.newsproject.domain.NewsComment;
import com.geekaca.newsproject.utils.PageBean;
import com.geekaca.newsproject.utils.PageResult;

public interface CommentService {

    //添加评论
    Boolean addComment(NewsComment blogComment);


    //后台管理系统中评论分页功能
    PageResult getCommentsPage(PageBean pageBean);

    int getTotalComments();


    //批量审核
    Boolean checkDone(Integer[] ids);


    //批量删除
    Boolean deleteBatch(Integer[] ids);


    //添加回复
    Boolean reply(Long commentId, String replyBody);


    //根据文章id和分页参数获取文章的评论列表
    PageResult getCommentPageByBlogIdAndPageNum(Long newsId, int page);
}
