package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcRolePermissionRelation;
import com.example.dachuang.mbg.model.DcRolePermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcRolePermissionRelationMapper {
    long countByExample(DcRolePermissionRelationExample example);

    int deleteByExample(DcRolePermissionRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcRolePermissionRelation record);

    int insertSelective(DcRolePermissionRelation record);

    List<DcRolePermissionRelation> selectByExample(DcRolePermissionRelationExample example);

    DcRolePermissionRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcRolePermissionRelation record, @Param("example") DcRolePermissionRelationExample example);

    int updateByExample(@Param("record") DcRolePermissionRelation record, @Param("example") DcRolePermissionRelationExample example);

    int updateByPrimaryKeySelective(DcRolePermissionRelation record);

    int updateByPrimaryKey(DcRolePermissionRelation record);
}