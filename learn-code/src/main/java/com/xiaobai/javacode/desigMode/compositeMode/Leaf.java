package com.xiaobai.javacode.desigMode.compositeMode;

/**
 * 子节点
 *
 * @author xiaobai 2023/06/08 10:38
 */
public class Leaf extends Penguin {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void beating() {
        System.out.println(name + "打豆豆");
    }
}
