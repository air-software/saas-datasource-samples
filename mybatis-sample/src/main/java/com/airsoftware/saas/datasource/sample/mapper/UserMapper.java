package com.airsoftware.saas.datasource.sample.mapper;

import com.airsoftware.saas.datasource.annotation.SaaS;
import com.airsoftware.saas.datasource.sample.entity.User;

import java.util.List;

@SaaS("tenantId")
public interface UserMapper {
    
    List<User> selectAll();
    
}
