package com.geekaca.stc.mapper;

import com.geekaca.stc.domain.Stu;

/**
* @author magol
* @description 针对表【tb_stu(学生表)】的数据库操作Mapper
* @createDate 2023-09-24 01:16:39
* @Entity com.geekaca.stc.domain.Stu
*/
public interface StuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Stu record);

    int insertSelective(Stu record);

    Stu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Stu record);

    int updateByPrimaryKey(Stu record);


}
