package com.airsoftware.saas.datasource.sample.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("data_source_config")
public class DataSourceConfig implements Serializable {
    
    @TableId
    private Long id;
    
    /**
     * 数据源地址
     **/
    private String host;
    
    /**
     * 数据库名称
     */
    private String schemaName;
    
    /**
     * 数据源用户名
     **/
    private String username;
    
    /**
     * 数据源密码
     **/
    private String password;
    
}
