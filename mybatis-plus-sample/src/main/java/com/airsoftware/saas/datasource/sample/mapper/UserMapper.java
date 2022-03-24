package com.airsoftware.saas.datasource.sample.mapper;

import com.airsoftware.saas.datasource.annotation.SaaS;
import com.airsoftware.saas.datasource.sample.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

@SaaS("tenantId")
public interface UserMapper extends BaseMapper<User> {
    
    List<User> selectAll();
    
}
