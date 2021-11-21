package com.example.dachuang.service;

import com.example.dachuang.common.api.CommonResult;
import com.example.dachuang.mbg.model.DcPermission;
import com.example.dachuang.mbg.model.DcUser;

import java.util.List;

/**
 * 用户Service
 */
public interface UserService {
    /**
     * 根据手机号获取用户
     */
    DcUser getUserByTelNum(String telNum);

    /**
     * 注册功能
     */
    DcUser register(DcUser userParam);

    /**
     * 登录功能
     * @param telNum 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String telNum, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<DcPermission> getPermissionList(Integer userId);

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telNum);

    /**
     * 判断验证码和手机是否匹配
     */
    CommonResult verifyAuthCode(String telNum, String authCode);

    /**
     * 修改密码
     */
    CommonResult updatePassword(String telNum, String newPassword1, String newPassword2, String authCode);
}
