package com.example.dachuang.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.example.dachuang.common.api.CommonResult;
import com.example.dachuang.common.utils.JwtTokenUtil;
import com.example.dachuang.dao.DcUserRoleRelationDao;
import com.example.dachuang.mbg.mapper.DcUserMapper;
import com.example.dachuang.mbg.model.DcPermission;
import com.example.dachuang.mbg.model.DcUser;
import com.example.dachuang.mbg.model.DcUserExample;
import com.example.dachuang.service.RedisService;
import com.example.dachuang.service.UserService;
import org.mybatis.generator.internal.util.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.List;
import java.util.Random;

@Service
public class UserServicemImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServicemImpl.class);

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private DcUserMapper userMapper;
    @Autowired
    private DcUserRoleRelationDao userRoleRelationDao;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    @Transactional
    public DcUser getUserByTelNum(String telNum) {
        /**
         * 这里最好做电话号码校验
         */
        DcUserExample userExample = new DcUserExample();
        userExample.createCriteria().andTelNumEqualTo(telNum);
        List<DcUser> userList = userMapper.selectByExample(userExample);
        if(userList != null && userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    @Transactional
    public DcUser register(DcUser userParam) {
        DcUser user = new DcUser();
        BeanUtils.copyProperties(userParam, user);

        DcUserExample userExample = new DcUserExample();
        userExample.createCriteria().andTelNumEqualTo(user.getTelNum());
        List<DcUser> userList = userMapper.selectByExample(userExample);
        if(userList.size() > 0){
            return null;
        }

        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.insert(user);
        return user;
    }

    @Override
    @Transactional
    public String login(String telNum, String password) {
        LOGGER.info("telNum:{}", telNum);
        LOGGER.info("password:{}", password);
        String token = null;
        try{
            UserDetails userDetails = userDetailsService.loadUserByUsername(telNum);
            if(!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确！");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e){
            LOGGER.warn("登录异常：{}", e.getMessage());
        }
        return token;
    }

    @Override
    @Transactional
    public List<DcPermission> getPermissionList(Integer userId) {
        return userRoleRelationDao.getPermissionList(userId);
    }

    @Override
    public CommonResult generateAuthCode(String telNum) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 6; i++){
            sb.append(random.nextInt(10));
        }

        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telNum, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telNum, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "验证吗获取成功！");
    }

    @Override
    public CommonResult verifyAuthCode(String telNum, String authCode) {
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证吗");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telNum);
        boolean result = authCode.equals(realAuthCode);
        if(result){
            return CommonResult.success(null, "验证码校验成功！");
        }else{
            return CommonResult.failed("验证吗不正确！");
        }
    }

    @Override
    @Transactional
    public CommonResult updatePassword(String telNum, String newPassword1, String newPassword2, String authCode) {
        if(authCode != redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telNum)){
            return CommonResult.failed("验证码不正确！");
        }
        if(!newPassword1.equals(newPassword2)){
            return CommonResult.failed("密码不一致！");
        }
        DcUserExample userExample = new DcUserExample();
        userExample.createCriteria().andTelNumEqualTo(telNum);
        List<DcUser> userList = userMapper.selectByExample(userExample);
        if(userList != null && userList.size() > 0){
            DcUser user = userList.get(0);
            user.setPassword(passwordEncoder.encode(newPassword1));
            userExample.clear();
            userExample.createCriteria().andTelNumEqualTo(telNum);
            userMapper.updateByExample(user, userExample);
            return CommonResult.success("修改成功");
        }else {
            return CommonResult.failed("用户不存在！");
        }
    }


}
