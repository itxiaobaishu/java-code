package com.xiaobai.javacode.jdk8.functionalInterface;

import com.xiaobai.javacode.entity.Person;

import java.util.Comparator;

/**
 * @author danyu
 * @description: TODO
 * @date 2020/5/15 3:16 下午
 */
public class ComparatorTest {

    public static void main(String[] args) {
        Comparator<Person> comparator01 = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Comparator<Person> comparator02 = Comparator.comparing(p -> p.firstName); //等同于上面的方式
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        int compare01 = comparator01.compare(p1, p2);// > 0
        int compare02 = comparator02.reversed().compare(p1, p2); // < 0
        System.out.println(compare01);
        System.out.println(compare02);
    }
}
