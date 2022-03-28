package com.airsoftware.saas.datasource.sample.mapper;

import com.airsoftware.saas.datasource.sample.entity.User;

import java.util.List;

public interface UserMapper {
    
    List<User> selectAll();
    
}
