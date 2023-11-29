package com.geekaca.studentclasssystem.service;


import com.geekaca.studentclasssystem.utils.PageResult;


public interface AttService {
    PageResult getAttList(Long studentId, String startDate, String endDate);

    PageResult getClassListByStu(Long studentId);

    PageResult getStuListByClasses(Integer classesId);

    PageResult getStuListByPhase(Integer phaseId);
}
