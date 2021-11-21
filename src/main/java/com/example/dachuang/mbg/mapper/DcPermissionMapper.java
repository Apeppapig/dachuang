package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcPermission;
import com.example.dachuang.mbg.model.DcPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcPermissionMapper {
    long countByExample(DcPermissionExample example);

    int deleteByExample(DcPermissionExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(DcPermission record);

    int insertSelective(DcPermission record);

    List<DcPermission> selectByExample(DcPermissionExample example);

    DcPermission selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") DcPermission record, @Param("example") DcPermissionExample example);

    int updateByExample(@Param("record") DcPermission record, @Param("example") DcPermissionExample example);

    int updateByPrimaryKeySelective(DcPermission record);

    int updateByPrimaryKey(DcPermission record);
}