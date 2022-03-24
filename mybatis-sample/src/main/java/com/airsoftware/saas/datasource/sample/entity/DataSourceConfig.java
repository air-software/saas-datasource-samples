package com.airsoftware.saas.datasource.sample.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataSourceConfig implements Serializable {
    
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
    
    /**
     * 驱动类名
     **/
    private String driverClassName;
    
}
