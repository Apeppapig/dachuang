package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcGift;
import com.example.dachuang.mbg.model.DcGiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcGiftMapper {
    long countByExample(DcGiftExample example);

    int deleteByExample(DcGiftExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(DcGift record);

    int insertSelective(DcGift record);

    List<DcGift> selectByExample(DcGiftExample example);

    DcGift selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") DcGift record, @Param("example") DcGiftExample example);

    int updateByExample(@Param("record") DcGift record, @Param("example") DcGiftExample example);

    int updateByPrimaryKeySelective(DcGift record);

    int updateByPrimaryKey(DcGift record);
}