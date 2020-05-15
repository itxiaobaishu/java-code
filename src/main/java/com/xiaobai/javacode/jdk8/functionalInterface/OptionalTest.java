package com.xiaobai.javacode.jdk8.functionalInterface;

import com.xiaobai.javacode.entity.Person;

import java.util.Optional;

/**
 * @author danyu
 * @description: Optional不是一个函数式接口
 * @date 2020/5/15 3:22 下午
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent(); // true
        optional.get(); // "bam"
        optional.orElse("fallback"); // "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"
        Optional<Person> optionalPerson = Optional.of(new Person("lily","wang"));
        optionalPerson.ifPresent(s -> System.out.println(s.firstName));
    }
}
