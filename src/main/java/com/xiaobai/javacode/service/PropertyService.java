package com.xiaobai.javacode.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author xiaobai
 * @description: bean属性注入的测试类
 * @date 2020/2/10 2:54 下午
 */
@Service
@Slf4j
public class PropertyService {

    @Value("其他类的属性")
    public String property;


}
