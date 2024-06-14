package com.xiaobai.springbooterefresh.anno;

import java.lang.annotation.*;

/**
 * @annotationName RefreshValue
 * @description 自定义注解，用来需要修饰需要支持动态刷新的场景
 **/
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RefreshValue {}
