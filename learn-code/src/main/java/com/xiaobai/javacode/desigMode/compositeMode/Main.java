package com.xiaobai.javacode.desigMode.compositeMode;

/**
 * description
 *
 * @author xiaobai 2023/06/08 10:32
 */
public class Main {

    public static void main(String[] args) {
        BatchPenguin grandFatherPenguin = new BatchPenguin("grandFatherPenguin");
        BatchPenguin fatherPenguin = new BatchPenguin("fatherPenguin");
        BatchPenguin motherPenguin = new BatchPenguin("motherPenguin");
        BatchPenguin childPenguin1 = new BatchPenguin("childPenguin1");
        BatchPenguin childPenguin2 = new BatchPenguin("childPenguin2");
        BatchPenguin childPenguin3 = new BatchPenguin("childPenguin3");
        BatchPenguin childPenguin4 = new BatchPenguin("childPenguin4");
        fatherPenguin.add(childPenguin1);
        fatherPenguin.add(childPenguin2);
        motherPenguin.add(childPenguin3);
        motherPenguin.add(childPenguin4);
        grandFatherPenguin.add(fatherPenguin);
        grandFatherPenguin.add(motherPenguin);

        Leaf leaf1 = new Leaf("leaf1");
        Leaf leaf2 = new Leaf("leaf2");
        Leaf leaf3 = new Leaf("leaf3");
        Leaf leaf4 = new Leaf("leaf4");
        childPenguin1.add(leaf1);
        childPenguin2.add(leaf2);
        childPenguin3.add(leaf3);
        childPenguin4.add(leaf4);
        grandFatherPenguin.beating();
    }

}
