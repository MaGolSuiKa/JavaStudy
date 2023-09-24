package com.geekaca.stc.service;

import com.geekaca.stc.domain.Class;
import com.geekaca.stc.domain.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StuService {

    public List<Class> getClassMem();
    public double getTestAvg(Long classId, Long subId);
    public List<Test> getTestOfStu(Long stuId);
}
