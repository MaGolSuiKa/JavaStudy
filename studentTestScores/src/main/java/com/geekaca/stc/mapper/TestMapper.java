package com.geekaca.stc.mapper;

import com.geekaca.stc.domain.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author magol
* @description 针对表【tb_test(成绩表)】的数据库操作Mapper
* @createDate 2023-09-24 01:16:39
* @Entity com.geekaca.stc.domain.Test
*/
public interface TestMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    Double getScoresAVG(@Param("classId")Long classId, @Param("subId")Long subId);

    List<Test> getScoresOfStu(@Param("stuId")Long stuId);
}
