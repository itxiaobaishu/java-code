package com.xiaobai.javacode.desigMode.builderMode13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobai
 * @description: 需要建造的产品
 * @date 2019/11/19 11:50 AM
 */
public class Product {

    /**
     * 成品需要的部分
     */
    List<String> parts = new ArrayList<>();

    /**
     * 添加产品部件
     *
     * @param part
     */
    public void add(String part) {
        parts.add(part);
    }

    /**
     * 展示产品的所有部件
     */
    public void show() {
        parts.forEach(part -> System.out.println(part));
    }
}
