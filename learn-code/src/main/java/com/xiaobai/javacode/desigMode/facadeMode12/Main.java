package com.xiaobai.javacode.desigMode.facadeMode12;

/**
 * @author xiaobai
 * @description: 调用外观模式
 * @date 2019/11/19 11:00 AM
 */
public class Main {

    public static void main(String[] args) {

        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();
    }

}
