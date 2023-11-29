package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Curriculum;
import org.apache.ibatis.annotations.Mapper;

/**
* @author magol
* @description 针对表【curriculum(课程表（具体名目）)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.Curriculum
*/
@Mapper
public interface CurriculumMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Curriculum record);

    int insertSelective(Curriculum record);

    Curriculum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Curriculum record);

    int updateByPrimaryKey(Curriculum record);

}
