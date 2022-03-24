package com.airsoftware.saas.datasource.sample.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("user")
public class User implements Serializable {
    
    @TableId
    private Long id;
    
    /**
     * 姓名
     */
    private String name;
    
}
