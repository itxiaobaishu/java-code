package com.xiaobai.javacode.desigMode.observerMode14;

/**
 * @author xiaobai
 * @description: 具体的观察者
 * @date 2019/11/19 2:30 PM
 */
public class ConcreteObserver extends Observer {

    private String name;
    private String observerState;
    private ConcreteSubject concreteSubject;

    public ConcreteObserver(String name, ConcreteSubject concreteSubject) {
        this.name = name;
        this.concreteSubject = concreteSubject;
    }

    @Override
    public void update() {

        observerState = concreteSubject.getSubjectState();
        System.out.println("观察者" + name + "的新状态是" + observerState);

    }

    public ConcreteSubject getConcreteSubject() {
        return concreteSubject;
    }

    public void setConcreteSubject(ConcreteSubject concreteSubject) {
        this.concreteSubject = concreteSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObserverState() {
        return observerState;
    }

    public void setObserverState(String observerState) {
        this.observerState = observerState;
    }
}
