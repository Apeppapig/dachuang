package com.example.dachuang.controller;

import com.example.dachuang.common.api.CommonResult;
import com.example.dachuang.dto.UserLoginParam;
import com.example.dachuang.mbg.model.DcPermission;
import com.example.dachuang.mbg.model.DcUser;
import com.example.dachuang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "UserController", description = "用户管理")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<DcUser> register(@RequestBody DcUser userParam, BindingResult result) {
        DcUser user = userService.register(userParam);
        if (user == null) {
            CommonResult.failed();
        }
        return CommonResult.success(user);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UserLoginParam userLoginParam, BindingResult result) {
        String token = userService.login(userLoginParam.getTelNum(), userLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<DcPermission>> getPermissionList(@PathVariable Integer adminId) {
        List<DcPermission> permissionList = userService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telNum) {
        return userService.generateAuthCode(telNum);
    }



    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telNum,
                                       @RequestParam String authCode) {
        return userService.verifyAuthCode(telNum,authCode);
    }

    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telNum, @RequestParam String newPassword1, @RequestParam String newPassword2, @RequestParam String authCode){
        return userService.updatePassword(telNum, newPassword1, newPassword2, authCode);
    }
}
