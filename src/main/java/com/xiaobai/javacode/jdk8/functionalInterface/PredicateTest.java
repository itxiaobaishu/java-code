package com.xiaobai.javacode.jdk8.functionalInterface;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author danyu
 * @description: 断言测试类
 * @date 2020/5/15 2:37 下午
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;

        boolean foo0 = predicate.test("foo"); // true
        boolean foo1 = predicate.negate().test("foo"); // negate否定相当于!true

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }
}
