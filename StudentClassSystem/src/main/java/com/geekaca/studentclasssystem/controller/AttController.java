package com.geekaca.studentclasssystem.controller;

import com.geekaca.studentclasssystem.service.AttService;
import com.geekaca.studentclasssystem.utils.PageResult;
import com.geekaca.studentclasssystem.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author magol
 */
@RestController
@RequestMapping("/att")
@Slf4j
public class AttController {
    @Autowired
    private AttService attService;

    /**
     * 查询某个学生的某段时间的 出勤和作业情况
     * @param studentId
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping("/getAttList")
    public PageResult getAttList(Long studentId, String startDate, String endDate) {
        return attService.getAttList(studentId,startDate,endDate);
    }

    @RequestMapping("/getClassListByStu")
    public PageResult getClassListByStu(Long studentId){
        return attService.getClassListByStu(studentId);
    }

    @RequestMapping("/getStuListByClasses")
    public PageResult getStuListByClasses(Integer classesId){
        return attService.getStuListByClasses(classesId);
    }

    @RequestMapping("/getStuListByPhase")
    public PageResult getStuListByPhase(Integer phaseId){
        return attService.getStuListByPhase(phaseId);
    }
}
