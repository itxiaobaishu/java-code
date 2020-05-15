package com.xiaobai.javacode.jdk8.functionalInterface;

import com.xiaobai.javacode.entity.MyConsumer;
import com.xiaobai.javacode.entity.Person;

import java.util.function.Consumer;

/**
 * @author danyu
 * @description: TODO
 * @date 2020/5/15 3:14 下午
 */
public class ConsumerTest {

    public static void main(String[] args) {
        // 参照物，方便知道下面的Lamdba表达式写法
        Consumer<Person> greeter01 = new Consumer<Person>() {
            @Override
            public void accept(Person p) {
                System.out.println("Hello, " + p.firstName);
            }
        };
        Consumer<Person> greeter02 = (p) -> System.out.println("Hello, " + p.firstName);
        greeter02.accept(new Person("Luke", "Skywalker")); //Hello, Luke
        Consumer<Person> greeter03 = new MyConsumer()::accept; // 也可以通过定义类和方法的方式去调用，这样才是实际开发的姿势
        greeter03.accept(new Person("Luke", "Skywalker")); //Hello, Luke
    }
}
