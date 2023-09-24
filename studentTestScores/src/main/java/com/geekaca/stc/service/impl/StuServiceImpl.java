package com.geekaca.stc.service.impl;

import com.geekaca.stc.domain.Class;
import com.geekaca.stc.domain.Test;
import com.geekaca.stc.mapper.ClassMapper;
import com.geekaca.stc.mapper.TestMapper;
import com.geekaca.stc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private TestMapper tm;

    @Override
    public List<Class> getClassMem() {
        List<Class> classes = classMapper.selectClassMembers();
        return classes;
    }

    @Override
    public double getTestAvg(Long classId, Long subId) {
        Double scoresAVG = tm.getScoresAVG(classId, subId);
        return scoresAVG;
    }

    @Override
    public List<Test> getTestOfStu(Long stuId) {
        List<Test> scoresOfStu = tm.getScoresOfStu(stuId);
        return scoresOfStu;
    }


}
