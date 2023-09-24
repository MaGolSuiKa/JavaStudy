package com.geekaca.stc.mapper;

import com.geekaca.stc.domain.Subjects;

/**
* @author magol
* @description 针对表【tb_subjects(科目)】的数据库操作Mapper
* @createDate 2023-09-24 01:16:39
* @Entity com.geekaca.stc.domain.Subjects
*/
public interface SubjectsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Subjects record);

    int insertSelective(Subjects record);

    Subjects selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Subjects record);

    int updateByPrimaryKey(Subjects record);

}
