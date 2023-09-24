package com.geekaca.stc.mapper;

import com.geekaca.stc.domain.Class;

import java.util.List;
import java.util.Map;

/**
* @author magol
* @description 针对表【tb_class(班级表)】的数据库操作Mapper
* @createDate 2023-09-24 02:56:29
* @Entity com.geekaca.stc.domain.Class
*/
public interface ClassMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> selectClassMembers();
}
