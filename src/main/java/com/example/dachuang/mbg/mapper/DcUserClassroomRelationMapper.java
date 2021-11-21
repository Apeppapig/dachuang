package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcUserClassroomRelation;
import com.example.dachuang.mbg.model.DcUserClassroomRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcUserClassroomRelationMapper {
    long countByExample(DcUserClassroomRelationExample example);

    int deleteByExample(DcUserClassroomRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcUserClassroomRelation record);

    int insertSelective(DcUserClassroomRelation record);

    List<DcUserClassroomRelation> selectByExample(DcUserClassroomRelationExample example);

    DcUserClassroomRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcUserClassroomRelation record, @Param("example") DcUserClassroomRelationExample example);

    int updateByExample(@Param("record") DcUserClassroomRelation record, @Param("example") DcUserClassroomRelationExample example);

    int updateByPrimaryKeySelective(DcUserClassroomRelation record);

    int updateByPrimaryKey(DcUserClassroomRelation record);
}