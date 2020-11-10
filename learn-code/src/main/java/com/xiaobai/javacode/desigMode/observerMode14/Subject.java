package com.xiaobai.javacode.desigMode.observerMode14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobai
 * @description: 抽象通知者
 * @date 2019/11/19 2:17 PM
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    /**
     * 增加观察者
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知
     */
    public void message() {
        observers.forEach(observer -> observer.update());
    }


}
