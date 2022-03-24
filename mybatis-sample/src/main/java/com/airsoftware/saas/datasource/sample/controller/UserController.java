package com.airsoftware.saas.datasource.sample.controller;

import com.airsoftware.saas.datasource.annotation.SaaS;
import com.airsoftware.saas.datasource.sample.entity.User;
import com.airsoftware.saas.datasource.sample.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SaaS("tenantId")
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private UserService userService;
    
    @GetMapping("/header")
    public List<User> header() {
        return userService.header();
    }
    
    @GetMapping("/session")
    public List<User> session(HttpServletRequest request) {
        request.getSession().setAttribute("tenantId", "2");
        return userService.session();
    }
    
    @GetMapping("/switch")
    public List<User> contextSwitch() {
        return userService.contextSwitch();
    }
    
    @GetMapping("/tx")
    public List<User> tx() {
        return userService.tx();
    }
    
}
