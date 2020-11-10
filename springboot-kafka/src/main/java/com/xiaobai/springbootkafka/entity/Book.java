package com.xiaobai.springbootkafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaobai
 * @description: 消息实体类
 * @date 2020/11/10 2:38 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private String name;

}
