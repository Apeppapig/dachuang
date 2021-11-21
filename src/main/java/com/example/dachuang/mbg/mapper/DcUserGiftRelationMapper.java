package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcUserGiftRelation;
import com.example.dachuang.mbg.model.DcUserGiftRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcUserGiftRelationMapper {
    long countByExample(DcUserGiftRelationExample example);

    int deleteByExample(DcUserGiftRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcUserGiftRelation record);

    int insertSelective(DcUserGiftRelation record);

    List<DcUserGiftRelation> selectByExample(DcUserGiftRelationExample example);

    DcUserGiftRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcUserGiftRelation record, @Param("example") DcUserGiftRelationExample example);

    int updateByExample(@Param("record") DcUserGiftRelation record, @Param("example") DcUserGiftRelationExample example);

    int updateByPrimaryKeySelective(DcUserGiftRelation record);

    int updateByPrimaryKey(DcUserGiftRelation record);
}