package com.xiaobai.javacode.desigMode.builderMode13;

/**
 * @author xiaobai
 * @description: 具体建造类2
 * @date 2019/11/19 12:01 PM
 */
public class ConcreteBuilder2 extends Builder {

    Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("ConcreteBuilder2类部件A");
    }

    @Override
    public void buildPartB() {
        product.add("ConcreteBuilder2类部件B");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
