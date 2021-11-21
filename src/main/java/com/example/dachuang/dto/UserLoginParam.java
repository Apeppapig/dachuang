package com.example.dachuang.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserLoginParam {
    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误！")
    @Size(max = 11, min = 11)
    private String telNum;
    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
