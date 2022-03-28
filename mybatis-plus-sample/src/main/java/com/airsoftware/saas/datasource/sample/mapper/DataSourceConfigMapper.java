package com.airsoftware.saas.datasource.sample.mapper;

import com.airsoftware.saas.datasource.sample.entity.DataSourceConfig;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@DS("common")
public interface DataSourceConfigMapper extends BaseMapper<DataSourceConfig> {

}
