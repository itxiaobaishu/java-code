package com.xiaobai.javacode.desigMode.facadeMode12;

/**
 * @author xiaobai
 * @description: 外观类
 * @date 2019/11/19 10:48 AM
 */
public class Facade {

    private SubSystemOne subSystemOne;
    private SubSystemTwo subSystemTwo;
    private SubSystemThree subSystemThree;
    private SubSystemFour subSystemFour;

    public Facade() {
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
        subSystemThree = new SubSystemThree();
        subSystemFour = new SubSystemFour();
    }

    /**
     * 封装子系统的方法
     */
    public void methodA() {
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
        subSystemThree.methodThree();
    }

    /**
     * 封装子系统的方法
     */
    public void methodB() {
        subSystemThree.methodThree();
        subSystemFour.methodFour();
    }
}
