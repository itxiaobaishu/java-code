package com.xiaobai.javacode.enumspeciality.singleton;

/**
 * @author xiaobai
 * @description: 枚举单例
 * @date 2020/9/9 9:50 上午
 */
public enum EnumSingleton {

    INSTANCE;

    public EnumSingleton getInstance() {
        return INSTANCE;
    }
}
