package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcTag;
import com.example.dachuang.mbg.model.DcTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcTagMapper {
    long countByExample(DcTagExample example);

    int deleteByExample(DcTagExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(DcTag record);

    int insertSelective(DcTag record);

    List<DcTag> selectByExample(DcTagExample example);

    DcTag selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") DcTag record, @Param("example") DcTagExample example);

    int updateByExample(@Param("record") DcTag record, @Param("example") DcTagExample example);

    int updateByPrimaryKeySelective(DcTag record);

    int updateByPrimaryKey(DcTag record);
}