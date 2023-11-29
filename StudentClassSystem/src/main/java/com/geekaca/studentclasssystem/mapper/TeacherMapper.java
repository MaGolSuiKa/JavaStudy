package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
* @author magol
* @description 针对表【teacher(教师表)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.Teacher
*/
@Mapper
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
