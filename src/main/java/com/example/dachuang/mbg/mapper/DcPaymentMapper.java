package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcPayment;
import com.example.dachuang.mbg.model.DcPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcPaymentMapper {
    long countByExample(DcPaymentExample example);

    int deleteByExample(DcPaymentExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(DcPayment record);

    int insertSelective(DcPayment record);

    List<DcPayment> selectByExample(DcPaymentExample example);

    DcPayment selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") DcPayment record, @Param("example") DcPaymentExample example);

    int updateByExample(@Param("record") DcPayment record, @Param("example") DcPaymentExample example);

    int updateByPrimaryKeySelective(DcPayment record);

    int updateByPrimaryKey(DcPayment record);
}