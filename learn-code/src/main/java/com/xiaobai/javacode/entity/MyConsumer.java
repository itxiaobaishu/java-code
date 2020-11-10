package com.xiaobai.javacode.entity;

import java.util.function.Consumer;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2020/5/15 3:23 下午
 */
public class MyConsumer implements Consumer<Person> {

    @Override
    public void accept(Person person) {
        System.out.println("Hello, " + person.firstName);
    }
}
