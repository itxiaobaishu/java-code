package com.xiaobai.javacode.desigMode.builderMode13;

/**
 * @author xiaobai
 * @description: 具体建造类1
 * @date 2019/11/19 12:01 PM
 */
public class ConcreteBuilder1 extends Builder {

    Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("ConcreteBuilder1类部件A");
    }

    @Override
    public void buildPartB() {
        product.add("ConcreteBuilder1类部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
