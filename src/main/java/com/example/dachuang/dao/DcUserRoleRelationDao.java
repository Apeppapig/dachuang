package com.example.dachuang.dao;

import com.example.dachuang.mbg.model.DcPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DcUserRoleRelationDao {
    /**
     * 获取用户所有权限
     */
    List<DcPermission> getPermissionList(@Param("userId") Integer userId);
}
