package com.geekaca.newsproject.mapper;

import com.geekaca.newsproject.domain.NewsComment;
import com.geekaca.newsproject.utils.PageBean;

import java.util.List;

/**
* @author magol
* @description 针对表【tb_news_comment】的数据库操作Mapper
* @createDate 2023-09-08 15:46:23
* @Entity com.geekaca.newsproject.domain.NewsComment
*/
public interface NewsCommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    NewsComment selectByPrimaryKey(Long id);

    List<NewsComment> selectByNewsId(Long id);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);

    List<NewsComment> findNewsCommentList(PageBean pageBean);

    Boolean checkUpdateDone(Integer[] ids);

}
