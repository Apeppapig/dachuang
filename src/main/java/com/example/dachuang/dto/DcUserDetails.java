package com.example.dachuang.dto;

import com.example.dachuang.mbg.model.DcPermission;
import com.example.dachuang.mbg.model.DcUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DcUserDetails implements UserDetails {
    private DcUser user;
    private List<DcPermission> permissionList;

    public DcUserDetails(DcUser user, List<DcPermission> permissionList){
        this.user = user;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission != null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getTelNum();
    }

    //账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //账号是否被锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //身份没有过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }
}
