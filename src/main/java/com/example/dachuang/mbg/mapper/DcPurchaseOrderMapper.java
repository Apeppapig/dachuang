package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcPurchaseOrder;
import com.example.dachuang.mbg.model.DcPurchaseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcPurchaseOrderMapper {
    long countByExample(DcPurchaseOrderExample example);

    int deleteByExample(DcPurchaseOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcPurchaseOrder record);

    int insertSelective(DcPurchaseOrder record);

    List<DcPurchaseOrder> selectByExample(DcPurchaseOrderExample example);

    DcPurchaseOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcPurchaseOrder record, @Param("example") DcPurchaseOrderExample example);

    int updateByExample(@Param("record") DcPurchaseOrder record, @Param("example") DcPurchaseOrderExample example);

    int updateByPrimaryKeySelective(DcPurchaseOrder record);

    int updateByPrimaryKey(DcPurchaseOrder record);
}