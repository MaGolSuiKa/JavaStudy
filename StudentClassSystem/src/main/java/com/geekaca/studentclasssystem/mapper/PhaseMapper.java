package com.geekaca.studentclasssystem.mapper;

import com.geekaca.studentclasssystem.domain.Phase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author magol
* @description 针对表【phase(课程阶段)】的数据库操作Mapper
* @createDate 2023-11-23 15:55:03
* @Entity com.geekaca.studentclasssystem.domain.Phase
*/
@Mapper
public interface PhaseMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Phase record);

    int insertSelective(Phase record);

    Phase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Phase record);

    int updateByPrimaryKey(Phase record);

    List<Phase> getStuListByPhase(@Param("phaseId")Integer phaseId);
    int findPhaCount();
}
