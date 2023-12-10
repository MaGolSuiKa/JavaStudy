package com.geekaca.studentclasssystem.service.impl;

import com.geekaca.studentclasssystem.domain.Attendance;
import com.geekaca.studentclasssystem.domain.Classes;
import com.geekaca.studentclasssystem.domain.Phase;
import com.geekaca.studentclasssystem.domain.Student;
import com.geekaca.studentclasssystem.mapper.AttendanceMapper;
import com.geekaca.studentclasssystem.mapper.ClassesMapper;
import com.geekaca.studentclasssystem.mapper.PhaseMapper;
import com.geekaca.studentclasssystem.mapper.StudentMapper;
import com.geekaca.studentclasssystem.service.AttService;
import com.geekaca.studentclasssystem.utils.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AttServiceImpl implements AttService {
    @Autowired
    private AttendanceMapper attMapper;
    @Autowired
    private StudentMapper stuMapper;
    @Autowired
    private ClassesMapper claMapper;
    @Autowired
    private PhaseMapper phaseMapper;

    @Override
    public PageResult getAttList(Long studentId, String startDate, String endDate) {
        List<Attendance> attById = attMapper.getAttById(studentId, startDate, endDate);
        int attCount = attMapper.findAttCount();
        PageResult pageResult = new PageResult(attById, attCount, attCount, 1);
        return pageResult;
    }

    @Override
    public PageResult getClassListByStu(Long studentId) {
        List<Student> classListByStu = stuMapper.getClassListByStu(studentId);
        int stuCount = stuMapper.findStuCount();
        PageResult pageResult = new PageResult(classListByStu, stuCount, stuCount, 1);
        return pageResult;
    }

    @Override
    public PageResult getStuListByClasses(Integer classesId) {
        List<Classes> stuListByClasses = claMapper.getStuListByClasses(classesId);
        int claCount = claMapper.findClaCount();
        PageResult pageResult = new PageResult(stuListByClasses, claCount, claCount, 1);
        return pageResult;
    }

    @Override
    public PageResult getStuListByPhase(Integer phaseId) {
        List<Classes> stuListByPhase = claMapper.getStuListByPhase(phaseId);
        int phaCount = claMapper.findClaCount();
        PageResult pageResult = new PageResult(stuListByPhase, phaCount, phaCount, 1);
        return pageResult;
    }


}
