package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcClassroom;
import com.example.dachuang.mbg.model.DcClassroomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcClassroomMapper {
    long countByExample(DcClassroomExample example);

    int deleteByExample(DcClassroomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcClassroom record);

    int insertSelective(DcClassroom record);

    List<DcClassroom> selectByExample(DcClassroomExample example);

    DcClassroom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcClassroom record, @Param("example") DcClassroomExample example);

    int updateByExample(@Param("record") DcClassroom record, @Param("example") DcClassroomExample example);

    int updateByPrimaryKeySelective(DcClassroom record);

    int updateByPrimaryKey(DcClassroom record);
}