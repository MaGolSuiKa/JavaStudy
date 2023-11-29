package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author magol
* @description 针对表【classes(班级表)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.Classes
*/
@Mapper
public interface ClassesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

    List<Classes> getStuListByClasses(@Param("classId")Integer classesId);
    int findClaCount();
}
