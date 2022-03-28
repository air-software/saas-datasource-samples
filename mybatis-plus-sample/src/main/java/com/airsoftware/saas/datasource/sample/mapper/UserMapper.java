package com.airsoftware.saas.datasource.sample.mapper;

import com.airsoftware.saas.datasource.sample.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    
    List<User> selectAll();
    
}
