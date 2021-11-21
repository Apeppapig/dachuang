package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcChargeOrder;
import com.example.dachuang.mbg.model.DcChargeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcChargeOrderMapper {
    long countByExample(DcChargeOrderExample example);

    int deleteByExample(DcChargeOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcChargeOrder record);

    int insertSelective(DcChargeOrder record);

    List<DcChargeOrder> selectByExample(DcChargeOrderExample example);

    DcChargeOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcChargeOrder record, @Param("example") DcChargeOrderExample example);

    int updateByExample(@Param("record") DcChargeOrder record, @Param("example") DcChargeOrderExample example);

    int updateByPrimaryKeySelective(DcChargeOrder record);

    int updateByPrimaryKey(DcChargeOrder record);
}