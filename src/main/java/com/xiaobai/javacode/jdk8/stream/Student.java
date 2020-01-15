package com.xiaobai.javacode.jdk8.stream;

import lombok.Builder;
import lombok.Data;

/**
 * @author xiaobai
 * @description: 测试实体类
 * @date 2020/1/14 11:53 上午
 */
@Data
@Builder
public class Student {

    private String id;

    private String name;

    private Integer age;

    private String sex;
}
