package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Classes;

/**
* @author magol
* @description 针对表【classes(班级表)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.Classes
*/
public interface ClassesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);

}
