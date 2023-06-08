package com.xiaobai.javacode.desigMode.compositeMode;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author xiaobai 2023/06/08 10:29
 */
public class BatchPenguin extends Penguin {

    private List<Penguin> penguins = new ArrayList<>();

    public BatchPenguin(String name) {
        super(name);
    }

    @Override
    public void beating() {
        System.out.println(this.name + "打豆豆");
        for (Penguin p : penguins) {
            p.beating();
        }
    }

    @Override
    public void add(Penguin p) {
        penguins.add(p);
    }

    @Override
    public void remove(Penguin p) {
        penguins.remove(p);
    }

    @Override
    public Penguin getChild(int i) {
        return penguins.get(i);
    }

    @Override
    public List<Penguin> getChilds() {
        return penguins;
    }
}

