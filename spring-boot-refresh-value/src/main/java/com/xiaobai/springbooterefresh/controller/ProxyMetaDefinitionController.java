package com.xiaobai.springbooterefresh.controller;

import com.xiaobai.springbooterefresh.anno.RefreshValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className ProxyMetaDefinitionController
 * @description 验证@Value值是否修改
 **/
@Slf4j
@RestController
@RequestMapping(value = "/tem")
@Api(value = "临时开放接口")
@RefreshValue
public class ProxyMetaDefinitionController {

    @Value("${source.flag}")
    private boolean enable;

    @Value("${db.token}")
    private String token;

    @Value("${isopen.open}")
    private String open;

    @ApiOperation(value = "自定义测试")
    @PostMapping("/calc/test")
    public void calcHistoryUseEle() {

        System.out.println("---token---" + token);
        System.out.println("---enable---" + enable);
        System.out.println("---open---" + open);

    }
}