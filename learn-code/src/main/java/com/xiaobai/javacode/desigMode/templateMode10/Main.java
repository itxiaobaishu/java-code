package com.xiaobai.javacode.desigMode.templateMode10;

/**
 * @author xiaobai
 * @description: 调用模板模式
 * @date 2019/11/18 3:01 PM
 */
public class Main {

    public static void main(String[] args) {

        AbstractClass abstractClass;

        abstractClass = new ConcreteClassA();
        abstractClass.templateMethod();

        abstractClass = new ConcreteClassB();
        abstractClass.templateMethod();
    }


}
