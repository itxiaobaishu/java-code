package com.xiaobai.javacode.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xiaobai
 * @description: 测试类
 * @date 2020/2/11 2:28 下午
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

        ListService listService = context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令：" + listService.showListCmd());

    }
}
