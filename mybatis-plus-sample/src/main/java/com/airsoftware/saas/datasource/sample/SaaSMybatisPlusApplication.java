package com.airsoftware.saas.datasource.sample;

import com.airsoftware.saas.datasource.annotation.EnableSaaSDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author bit
 */
@SpringBootApplication
@EnableSaaSDataSource
@MapperScan({"com.airsoftware.**.mapper"})
public class SaaSMybatisPlusApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SaaSMybatisPlusApplication.class, args);
    }
}
