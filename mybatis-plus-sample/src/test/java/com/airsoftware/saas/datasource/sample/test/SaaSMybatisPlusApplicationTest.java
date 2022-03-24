package com.airsoftware.saas.datasource.sample.test;

import com.airsoftware.saas.datasource.sample.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class SaaSMybatisPlusApplicationTest {

    @Resource
    private MockMvc mockMvc;
    
    @Resource
    private UserService userService;
    
    @Resource
    private HttpSession session;
    
    @Test
    public void header() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/header")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .header("tenantId", "1")
        )
            .andDo(print()).andExpect(status().isOk())
            .andReturn().getResponse()
            .getContentAsString();
    }

    @Test
    public void session() {
        session.setAttribute("tenantId", "2");
        System.out.println(userService.session());
    }
    

    @Test
    public void contextSwitch() {
        System.out.println(userService.contextSwitch());
    }

    @Test
    public void tx() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/tx")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .header("tenantId", "1")
        )
            .andDo(print()).andExpect(status().isOk())
            .andReturn().getResponse()
            .getContentAsString();
    }
}
