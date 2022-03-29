package com.airsoftware.saas.datasource.sample.service;

import com.airsoftware.saas.datasource.annotation.SaaS;
import com.airsoftware.saas.datasource.context.SaaSDataSource;
import com.airsoftware.saas.datasource.sample.entity.User;
import com.airsoftware.saas.datasource.sample.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserService {
    
    @Resource
    private UserMapper userMapper;
    
    public List<User> header() {
        return userMapper.selectAll();
    }
    
    /**
     * 注意session在此注解生效前已设置好（即上层controller内）
     * 如果一次调用流程内有多个注解生效，以最后生效的为准。
     */
    @SaaS("tenantId")
    public List<User> session() {
        return userMapper.selectAll();
    }
    
    /**
     * 可多次切换，切换后会影响下次即将执行的且被标记了@SaaS注解的数据库操作
     */
    public List<User> contextSwitch() {
        SaaSDataSource.switchTo("2");
        log.info("tenant2 userlist={}", userMapper.selectAll());
        
        SaaSDataSource.switchTo("1");
        return userMapper.selectAll();
    }
    
    @Transactional
    public List<User> tx() {
        // 注意此处在事务内的切换不会生效，且可能会导致异常
        try {
            SaaSDataSource.switchTo("2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMapper.selectAll();
    }
    
}
