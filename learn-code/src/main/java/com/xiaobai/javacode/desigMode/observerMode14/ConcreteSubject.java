package com.xiaobai.javacode.desigMode.observerMode14;

/**
 * @author xiaobai
 * @description: 具体通知者
 * @date 2019/11/19 2:27 PM
 */
public class ConcreteSubject extends Subject {

    /**
     * 具体观察者状态
     */
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
