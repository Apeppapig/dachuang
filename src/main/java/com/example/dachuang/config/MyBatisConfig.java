package com.example.dachuang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({"com.example.dachuang.mbg.mapper","com.example.dachuang.dao"})
public class MyBatisConfig {
}
