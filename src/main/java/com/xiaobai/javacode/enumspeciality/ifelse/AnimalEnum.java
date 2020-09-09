package com.xiaobai.javacode.enumspeciality.ifelse;

/**
 * @author xiaobai
 * @description: 枚举类实现
 * @date 2020/9/9 9:42 上午
 */
public enum AnimalEnum implements Common {

    CAT {
        @Override
        public String eat() {
            return "吃鱼";
        }
    },
    DOG {
        @Override
        public String eat() {
            return "吃骨头";
        }
    }
}
