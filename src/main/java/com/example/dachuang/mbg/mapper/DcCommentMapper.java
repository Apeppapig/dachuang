package com.example.dachuang.mbg.mapper;

import com.example.dachuang.mbg.model.DcComment;
import com.example.dachuang.mbg.model.DcCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcCommentMapper {
    long countByExample(DcCommentExample example);

    int deleteByExample(DcCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DcComment record);

    int insertSelective(DcComment record);

    List<DcComment> selectByExample(DcCommentExample example);

    DcComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DcComment record, @Param("example") DcCommentExample example);

    int updateByExample(@Param("record") DcComment record, @Param("example") DcCommentExample example);

    int updateByPrimaryKeySelective(DcComment record);

    int updateByPrimaryKey(DcComment record);
}