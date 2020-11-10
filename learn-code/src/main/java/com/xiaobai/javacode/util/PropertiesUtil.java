package com.xiaobai.javacode.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author xiaobai
 * @description: properties文件读取工具类
 * @date 2020/3/19 10:20 上午
 */
@Slf4j
public class PropertiesUtil {

    protected static ResourceBundle erpResponse;

    protected static final String PROPERTIES_FILE = "propertytest";

    static {
        try {
            erpResponse = PropertyResourceBundle.getBundle(PROPERTIES_FILE);
        } catch (Exception e) {
            log.error(PROPERTIES_FILE + "配置文件加载失败。", e);
        }
    }

    public static int getIntegerCode(String key) {
        try {
            if (erpResponse.getString(key) != null) {
                return Integer.parseInt(erpResponse.getString(key));
            }
        } catch (Exception e) {
            log.error("RESPONSE CODE FROM STRING TO INT THEN ERROR.", e);
        }
        return 0;
    }


    public static String getStringCode(String key) {
        return erpResponse.getString(key) != null ? erpResponse.getString(key) : "";
    }

    public static int getIntegerCode(String key, int value) {
        try {
            if (erpResponse.getString(key) != null) {
                return Integer.parseInt(erpResponse.getString(key));
            }
        } catch (Exception e) {
            log.error("RESPONSE CODE FROM STRING TO INT THEN ERROR.", e);
        }
        return value;
    }

    public static String get(String key) {
        return erpResponse.getString(key);
    }

    public static String getChinese(String key) {
        String string = null;
        try {
            string = new String(erpResponse.getString(key).getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static String get(String key, String value) {
        return erpResponse.getString(key) == null ? value : erpResponse.getString(key);
    }

    public static void main(String[] args) {
        //属性值直接写成中文，打印出来的结果：ä¸­æå¼
        System.out.println(getStringCode("test.property.value"));
        //解决方案一，使用转码的方式，打印结果：中文值
        System.out.println(getChinese("test.property.value"));
        //解决方案二，properties文件中的属性值写成unicode（\u4e2d\u6587\u503c），打印结果：中文值
        System.out.println(getStringCode("test.property.value.unicode"));

    }

}
