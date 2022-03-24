package com.airsoftware.saas.datasource.sample.mapper;

import com.airsoftware.saas.datasource.sample.entity.DataSourceConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

public interface DataSourceConfigMapper {
    
    @Select("select *, schema_name as schemaName, driver_class_name as driverClassName from data_source_config where id = #{id}")
    DataSourceConfig selectById(@Param("id") Serializable id);

}
