package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcClassroomCommentRelation;
import com.example.dachuang.mbg.model.DcClassroomCommentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcClassroomCommentRelationMapper {
    long countByExample(DcClassroomCommentRelationExample example);

    int deleteByExample(DcClassroomCommentRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DcClassroomCommentRelation record);

    int insertSelective(DcClassroomCommentRelation record);

    List<DcClassroomCommentRelation> selectByExample(DcClassroomCommentRelationExample example);

    DcClassroomCommentRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DcClassroomCommentRelation record, @Param("example") DcClassroomCommentRelationExample example);

    int updateByExample(@Param("record") DcClassroomCommentRelation record, @Param("example") DcClassroomCommentRelationExample example);

    int updateByPrimaryKeySelective(DcClassroomCommentRelation record);

    int updateByPrimaryKey(DcClassroomCommentRelation record);
}