package com.xiaobai.javacode.bloom;

import java.util.BitSet;

/**
 * @author xiaobai
 * @description: 自定义一个布隆过滤器
 * @date 2021/7/13 11:17 上午
 */
public class MyBloomFilter {

    /**
     * 默认的位数组大小
     */
    private static final int DEFAULT_SIZE = 2 << 24;

    /**
     * 通过数组创建6个不同的哈希函数
     */
    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    /**
     * 位数组，数组中的元素只能是0或1
     */
    private BitSet bitSets = new BitSet(DEFAULT_SIZE);

    /**
     * 存放hash函数的数组
     */
    private SimpleHash[] simpleHashes = new SimpleHash[SEEDS.length];

    /**
     * 初始化多个包含hash函数的类的数组，每个类中的hash函数都不一样
     */
    public MyBloomFilter() {

        for (int i = 0, l = SEEDS.length; i < l; i++) {
            /**
             * 初始化多个不同的hash函数
             */
            simpleHashes[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     *
     * @param object
     */
    public void add(Object object) {
        for (SimpleHash simpleHash : simpleHashes) {
            bitSets.set(simpleHash.hash(object), true);
        }
    }

    /**
     * 判断元素是否位于位数组中
     *
     * @param object
     * @return
     */
    public boolean contains(Object object) {
        boolean ret = true;
        for (SimpleHash simpleHash : simpleHashes) {
            ret = ret && bitSets.get(simpleHash.hash(object));
        }
        return ret;
    }

    /**
     * 提供hash算法的静态内部类
     */
    private static class SimpleHash {

        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(Object object) {
            int value;
            return (object == null) ? 0 : Math.abs(seed * (cap - 1) & ((value = object.hashCode()) ^ (value >>> 16)));
        }
    }

    public static void main(String[] args) {
        Integer object1 = 123464;
        Integer object2 = 1234645;

        MyBloomFilter bloomFilter = new MyBloomFilter();
        bloomFilter.add(object1);
        bloomFilter.add(object2);
        System.out.println(bloomFilter.contains(object1));
        System.out.println(bloomFilter.contains(object2));
    }
}
