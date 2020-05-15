package com.xiaobai.javacode.entity;

import org.springframework.util.StringUtils;

/**
 * @author danyu
 * @description: TODO
 * @date 2020/5/15 3:19 下午
 */
public class Something {


    public static String test01() {
        return "";
    }

    public String test02() {
        return "";
    }

    public String startsWith(String s) {
        if (!StringUtils.isEmpty(s)) {
            s = s.substring(0, 1);
        }
        return s;
    }
}
