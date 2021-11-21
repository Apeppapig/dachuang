package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcPurchase;
import com.example.dachuang.mbg.model.DcPurchaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcPurchaseMapper {
    long countByExample(DcPurchaseExample example);

    int deleteByExample(DcPurchaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DcPurchase record);

    int insertSelective(DcPurchase record);

    List<DcPurchase> selectByExample(DcPurchaseExample example);

    DcPurchase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DcPurchase record, @Param("example") DcPurchaseExample example);

    int updateByExample(@Param("record") DcPurchase record, @Param("example") DcPurchaseExample example);

    int updateByPrimaryKeySelective(DcPurchase record);

    int updateByPrimaryKey(DcPurchase record);
}