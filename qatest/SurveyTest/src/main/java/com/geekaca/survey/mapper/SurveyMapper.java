package com.geekaca.survey.mapper;

import com.geekaca.survey.pojo.SurveyInfo;

import java.util.List;

public interface SurveyMapper {
    int insertSurvey(SurveyInfo surveyInfo);
    List<SurveyInfo> searchByIdSurvey();
}
