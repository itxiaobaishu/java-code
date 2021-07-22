package com.xiaobai.springbootevent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2021/7/22 11:23 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class BaseTest {

    @Resource
    protected WebApplicationContext webApplicationContext;
    @Resource
    protected MockMvc mockMvc;

    @Before
    public void setup() {
        // 实例化方式一
//        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
        // 实例化方式二
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
