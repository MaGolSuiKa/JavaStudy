package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author magol
* @description 针对表【student(学生表)】的数据库操作Mapper
* @createDate 2023-12-11 03:16:12
* @Entity com.geekaca.studentclasssystem.domain.Student
*/
@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> getClassListByStu(@Param("stuId")Long studentId);

    int findStuCount();
}
