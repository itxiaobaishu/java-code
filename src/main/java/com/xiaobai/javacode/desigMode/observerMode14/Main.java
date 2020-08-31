package com.xiaobai.javacode.desigMode.observerMode14;

/**
 * @author xiaobai
 * @description: 调用观察者模式
 * @date 2019/11/19 2:43 PM
 */
public class Main {

    public static void main(String[] args) {

        ConcreteSubject concreteSubject = new ConcreteSubject();

        concreteSubject.attach(new ConcreteObserver("A", concreteSubject));
        concreteSubject.attach(new ConcreteObserver("B", concreteSubject));
        concreteSubject.attach(new ConcreteObserver("C", concreteSubject));

        concreteSubject.setSubjectState("XYZ");

        concreteSubject.message();
    }

}
