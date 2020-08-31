package com.xiaobai.javacode.desigMode.builderMode13;

/**
 * @author xiaobai
 * @description: 指挥类
 * @date 2019/11/19 12:05 PM
 */
public class Director {

    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
