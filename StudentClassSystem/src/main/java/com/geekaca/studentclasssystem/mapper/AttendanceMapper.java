package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Attendance;

/**
* @author magol
* @description 针对表【attendance(出勤表)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.Attendance
*/
public interface AttendanceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);

}
