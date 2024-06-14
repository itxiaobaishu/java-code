package com.xiaobai.springbooterefresh.controller;

import com.xiaobai.springbooterefresh.service.AnoValueRefreshPostProcessor;
import com.xiaobai.springbooterefresh.service.RefreshEnvironment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className TestUpdateController
 * @description 修改配置接口
 **/
@Slf4j
@RestController
@RequestMapping(value = "/test")
@Api(value = "测试接口")
public class TestUpdateController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ConfigurableEnvironment environment;

    @ApiOperation(value = "自定义修改配置")
    @PostMapping("/update")
    public void calcHistoryUseEle(@RequestParam String name, @RequestParam String value) {
        System.out.println("参数名 name = " + name);
        System.out.println("参数 value = " + value);

        // 配置转换
        RefreshEnvironment.updateValue(name, value);

        applicationContext.publishEvent(new AnoValueRefreshPostProcessor.ConfigUpdateEvent(this, name));

    }
}