package com.airsoftware.saas.datasource.sample.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    
    private Long id;
    
    /**
     * 姓名
     */
    private String name;
    
}
