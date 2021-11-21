package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcRole;
import com.example.dachuang.mbg.model.DcRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcRoleMapper {
    long countByExample(DcRoleExample example);

    int deleteByExample(DcRoleExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(DcRole record);

    int insertSelective(DcRole record);

    List<DcRole> selectByExample(DcRoleExample example);

    DcRole selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") DcRole record, @Param("example") DcRoleExample example);

    int updateByExample(@Param("record") DcRole record, @Param("example") DcRoleExample example);

    int updateByPrimaryKeySelective(DcRole record);

    int updateByPrimaryKey(DcRole record);
}