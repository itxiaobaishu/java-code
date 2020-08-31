package com.xiaobai.javacode.desigMode.builderMode13;

/**
 * @author xiaobai
 * @description: 抽象建造类，确定产品有两部分组成及得到产品建造后结果的方法
 * @date 2019/11/19 11:57 AM
 */
public abstract class Builder {

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getResult();


}
