package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcUserRoleRelation;
import com.example.dachuang.mbg.model.DcUserRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcUserRoleRelationMapper {
    long countByExample(DcUserRoleRelationExample example);

    int deleteByExample(DcUserRoleRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcUserRoleRelation record);

    int insertSelective(DcUserRoleRelation record);

    List<DcUserRoleRelation> selectByExample(DcUserRoleRelationExample example);

    DcUserRoleRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcUserRoleRelation record, @Param("example") DcUserRoleRelationExample example);

    int updateByExample(@Param("record") DcUserRoleRelation record, @Param("example") DcUserRoleRelationExample example);

    int updateByPrimaryKeySelective(DcUserRoleRelation record);

    int updateByPrimaryKey(DcUserRoleRelation record);
}