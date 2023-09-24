package com.geekaca.stc.controller;

import com.geekaca.stc.domain.Class;
import com.geekaca.stc.domain.Test;
import com.geekaca.stc.service.StuService;
import com.geekaca.stc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StuController {
//1，统计各个班级的学生人数
//2，计算某一个班级的 英语平均成绩
//3，查询某个学生的各个科目考试成绩

    @Autowired
    private StuService stuService;

    @GetMapping("/members")
    public Result getMembers() {
        List<Class> classMem = stuService.getClassMem();
        Result result = new Result(200,classMem,"统计各个班级的学生人数");
        return result;
    }

    @GetMapping("/avg")
    public Result getAvg(){
        double testScoresAvg = stuService.getTestAvg(1l, 3l);
        Result result = new Result(200,testScoresAvg,"计算某一个班级的 英语平均成绩");
        return result;
    }

    @GetMapping("/subScore")
    public Result getScore(){
        List<Test> testOfStu = stuService.getTestOfStu(2000102l);
        Result result = new Result(200,testOfStu,"计算某一个班级的 英语平均成绩");
        return result;
    }
}
