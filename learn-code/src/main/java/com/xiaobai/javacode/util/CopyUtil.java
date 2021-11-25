package com.xiaobai.javacode.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobai
 * @Description: 拷贝工具类
 * @date 2021/11/254:21 下午
 */
public class CopyUtil {


    /**
     * 拷贝list
     *
     * @param source
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)) {
            if (!CollectionUtils.isEmpty(source)) {
                for (Object o : source) {
                    T obj = copy(o, clazz);
                    target.add(obj);
                }
            }
        }
        return target;
    }

    /**
     * 拷贝实体
     *
     * @param source
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (null == source) {
            return null;
        }
        T target = null;
        try {
            target = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * 拷贝实体
     *
     * @param source
     * @param clazz
     * @param ignoreProperties
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> clazz, String... ignoreProperties) {
        if (null == source) {
            return null;
        }
        T target = null;
        try {
            target = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }

    /**
     * 拷贝list
     *
     * @param source
     * @param clazz
     * @param ignoreProperties
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List source, Class<T> clazz, String... ignoreProperties) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)) {
            if (!CollectionUtils.isEmpty(source)) {
                for (Object o : source) {
                    T obj = copy(o, clazz, ignoreProperties);
                    target.add(obj);
                }
            }
        }
        return target;
    }
}
