package com.xiaobai.javacode.enumspeciality.ifelse;

/**
 * @author xiaobai
 * @description: 枚举消除if/else
 * @date 2020/9/9 9:46 上午
 */
public class Test {

    public static void main(String[] args) {
        String type = "CAT";
        String eat = AnimalEnum.valueOf(type).eat();
        System.out.println(eat);
    }
}
