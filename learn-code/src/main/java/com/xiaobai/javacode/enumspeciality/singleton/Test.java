package com.xiaobai.javacode.enumspeciality.singleton;

import java.util.Objects;

/**
 * @author xiaobai
 * @description: 枚举单例测试
 * @date 2020/9/9 9:52 上午
 */
public class Test {

    public static void main(String[] args) {

        EnumSingleton instance1 = EnumSingleton.INSTANCE.getInstance();
        EnumSingleton instance2 = EnumSingleton.INSTANCE.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(Objects.equals(instance1, instance2));
    }
}
