package com.xiaobai.javacode.jdk8.functionalInterface;

import com.xiaobai.javacode.entity.Something;

import java.util.function.Function;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2020/5/15 2:40 下午
 */
public class FunctionTest {

    public static void main(String[] args) {

        Function<String, Integer> toInteger = Integer::valueOf; //转Integer
        Function<String, String> backToString = toInteger.andThen(String::valueOf); //转String
        Function<String, String> afterToStartsWith = backToString.andThen(new Something()::startsWith); //截取第一位
        String apply = afterToStartsWith.apply("123");// "123"
        System.out.println(apply);
    }
}
