package com.xiaobai.javacode.jdk8.functionalInterface;

import com.xiaobai.javacode.entity.Person;
import com.xiaobai.javacode.entity.Something;

import java.util.function.Supplier;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2020/5/15 3:13 下午
 */
public class SupplierTest {

    public static void main(String[] args) {

        Supplier<Person> personSupplier0 = Person::new;
        personSupplier0.get(); // new Person
        Supplier<String> personSupplier1 = Something::test01; //这个test方法是静态的，且无入参
        personSupplier1.get(); // hi

        Supplier<String> personSupplier2 = new Something()::test02;
    }
}
