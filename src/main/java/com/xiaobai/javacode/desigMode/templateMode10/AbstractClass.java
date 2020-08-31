package com.xiaobai.javacode.desigMode.templateMode10;

/**
 * @author xiaobai
 * @description: 模板方法模式
 * 其实就是一个抽象模板，定义并实现一些模板方法，定义了顶级逻辑骨架，
 * 而逻辑的组成步骤在相应的抽象操作中，推迟到子类中实现
 * @date 2019/11/18 2:46 PM
 */
public abstract class AbstractClass {

    /**
     * 定义一些抽象行为在子类中实现
     */
    public abstract void primitiveOperation1();
    public abstract void primitiveOperation2();

    /**
     * 模板方法，给出逻辑骨架，而逻辑的组成是一些抽象的操作，他们都推迟到子类中实现
     */
    public void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
    }

}
