package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcGroup;
import com.example.dachuang.mbg.model.DcGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcGroupMapper {
    long countByExample(DcGroupExample example);

    int deleteByExample(DcGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcGroup record);

    int insertSelective(DcGroup record);

    List<DcGroup> selectByExample(DcGroupExample example);

    DcGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcGroup record, @Param("example") DcGroupExample example);

    int updateByExample(@Param("record") DcGroup record, @Param("example") DcGroupExample example);

    int updateByPrimaryKeySelective(DcGroup record);

    int updateByPrimaryKey(DcGroup record);
}