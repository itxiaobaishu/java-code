package com.xiaobai.javacode.desigMode.builderMode13;

/**
 * @author xiaobai
 * @description: 调用建造者模式
 * @date 2019/11/19 12:08 PM
 */
public class Main {

    public static void main(String[] args) {

        Director director = new Director();

        ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();
        director.construct(concreteBuilder1);
        Product product1 = concreteBuilder1.getResult();
        product1.show();

        ConcreteBuilder2 concreteBuilder2 = new ConcreteBuilder2();
        director.construct(concreteBuilder2);
        Product product2 = concreteBuilder2.getResult();
        product2.show();
    }
}
