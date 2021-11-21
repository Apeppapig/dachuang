package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcUserGroupRelation;
import com.example.dachuang.mbg.model.DcUserGroupRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcUserGroupRelationMapper {
    long countByExample(DcUserGroupRelationExample example);

    int deleteByExample(DcUserGroupRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcUserGroupRelation record);

    int insertSelective(DcUserGroupRelation record);

    List<DcUserGroupRelation> selectByExample(DcUserGroupRelationExample example);

    DcUserGroupRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcUserGroupRelation record, @Param("example") DcUserGroupRelationExample example);

    int updateByExample(@Param("record") DcUserGroupRelation record, @Param("example") DcUserGroupRelationExample example);

    int updateByPrimaryKeySelective(DcUserGroupRelation record);

    int updateByPrimaryKey(DcUserGroupRelation record);
}