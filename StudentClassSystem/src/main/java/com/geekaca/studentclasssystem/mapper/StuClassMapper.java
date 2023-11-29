package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.StuClass;
import org.apache.ibatis.annotations.Mapper;

/**
* @author magol
* @description 针对表【stu_class(学生对应班级表)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.StuClass
*/
@Mapper
public interface StuClassMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StuClass record);

    int insertSelective(StuClass record);

    StuClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StuClass record);

    int updateByPrimaryKey(StuClass record);

}
