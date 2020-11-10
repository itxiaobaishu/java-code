package com.xiaobai.javacode.desigMode.observerMode14;

/**
 * @author xiaobai
 * @description: 抽象观察者类，为所有的观察者定义一个接口，在得到主题更新时更新自己
 * @date 2019/11/19 2:14 PM
 */
public abstract class Observer {

    public abstract void update();
}
