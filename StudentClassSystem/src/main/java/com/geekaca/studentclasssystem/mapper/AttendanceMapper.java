package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Attendance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author magol
* @description 针对表【attendance(出勤表)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.Attendance
*/
@Mapper
public interface AttendanceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);

    List<Attendance> getAttById(@Param("stuId")Long id, @Param("startDate")String startDate, @Param("endDate")String endDate);
    int findAttCount();
}
