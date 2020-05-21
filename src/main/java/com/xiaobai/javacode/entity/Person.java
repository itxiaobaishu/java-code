package com.xiaobai.javacode.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2020/5/15 3:16 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    public String firstName;
    private String lastName;
}
