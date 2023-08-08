package com.geekaca.survey;

import com.geekaca.survey.mapper.MainMapper;
import com.geekaca.survey.mapper.SurveyMapper;
import com.geekaca.survey.pojo.MainInfo;
import com.geekaca.survey.pojo.SurveyInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class Test01 {
    @org.junit.Test
    public void testSelect(){

    }

    @org.junit.Test
    public void setSurvey() throws IOException {
        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象  开启自动事务提交，否则数据不会更新
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MainMapper mainMapper = sqlSession.getMapper(MainMapper.class);
        SurveyMapper surveyMapper = sqlSession.getMapper(SurveyMapper.class);
        List<SurveyInfo> surveyInfoList = surveyMapper.searchByIdSurvey();
        //创建对象
        MainInfo mainInfo = new MainInfo();
        SurveyInfo surveyInfo = new SurveyInfo();
        //创建问卷
        mainInfo.setTitleMain("问卷1");
        mainInfo.setDateMain(LocalDate.now());
        int mainUpdated = mainMapper.insertMain(mainInfo);
        Assert.assertTrue(mainUpdated > 0);
        //结合问卷与问题
        surveyInfo.setIdMain(mainInfo.getId());
        surveyInfo.setQ1(1);//获取问题表的问题id
        surveyInfo.setQ2(2);
        surveyInfo.setQ3(3);
        surveyInfo.setQ4(4);
        surveyInfo.setQ5(5);
        int surveyUpdated = surveyMapper.insertSurvey(surveyInfo);
        Assert.assertTrue(surveyUpdated > 0);
        //显示表格

        Assert.assertNotNull(surveyInfoList);
        //Assert.assertTrue(surveyInfoList.size() > 0);
        surveyInfoList.forEach(surInfo -> System.out.println(surInfo));
    }
}
