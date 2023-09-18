package com.geekaca.newsproject.service.impl;


import com.geekaca.newsproject.domain.NewsComment;
import com.geekaca.newsproject.service.CommentService;
import com.geekaca.newsproject.utils.PageBean;
import com.geekaca.newsproject.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private com.geekaca.newsproject.mapper.NewsCommentMapper newsCommentMapper;

    @Override
    public Boolean addComment(NewsComment NewsComment) {
        return newsCommentMapper.insertSelective(NewsComment) > 0;
    }

    @Override
    public PageResult getCommentsPage(PageBean pageBean) {
        List<NewsComment> comments = newsCommentMapper.findNewsCommentList(pageBean);
//        int total = newsCommentMapper.getTotalNewsComments(pageBean);
        PageResult pageResult = new PageResult(comments, 0, pageBean.getPageSize(), pageBean.getPageNo());
        return pageResult;
    }

    @Override
    public int getTotalComments() {
//        return newsCommentMapper.getTotalNewsComments(null);
        return 0;
    }

    @Override
    public Boolean checkDone(Integer[] ids) {
        return newsCommentMapper.checkUpdateDone(ids);

    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
//        return newsCommentMapper.deleteBatch(ids) > 0;
        return false;
    }

    @Override
    public Boolean reply(Long commentId, String replyBody) {
        NewsComment NewsComment = newsCommentMapper.selectByPrimaryKey(commentId);
        if (NewsComment != null && NewsComment.getCommentStatus().intValue() == 1) {
            NewsComment.setReplyBody(replyBody);
            NewsComment.setReplyCreateTime(new Date());
            return newsCommentMapper.updateByPrimaryKeySelective(NewsComment) > 0;
        }
        return false;
    }

    @Override
    public PageResult getCommentPageByBlogIdAndPageNum(Long NewsId, int page) {
        if (page < 1) {
            return null;
        }
        Map params = new HashMap();
        params.put("page", page);
        params.put("limit", 5);
        params.put("newsId", NewsId);
        params.put("commentStatus", 1);//过滤审核通过的数据
//        PageInfo pageUtil = new PageInfo(params);
//        List<NewsComment> comments = newsCommentMapper.findNewsCommentList(pageUtil);
//        if (!CollectionUtils.isEmpty(comments)) {
//            int total = newsCommentMapper.getTotalNewsComments(pageUtil);
//            PageResult pageResult = new PageResult(comments, total, pageUtil.getLimit(), pageUtil.getPage());
//            return pageResult;
//        }
        return null;
    }
}
