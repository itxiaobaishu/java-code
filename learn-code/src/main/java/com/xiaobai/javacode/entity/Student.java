package com.xiaobai.javacode.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author xiaobai
 * @description: 测试实体类
 * @date 2020/1/14 11:53 上午
 */
@Data
@Builder
public class Student implements Serializable {

    private static final long serialVersionUID = 1697173278920274933L;

    private String id;

    private String name;

    private Integer age;

    private String sex;

    //排序的字段
    private Integer orderId;

    private LocalDateTime createTime;
}
