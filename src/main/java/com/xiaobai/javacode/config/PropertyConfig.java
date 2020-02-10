package com.xiaobai.javacode.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * @author xiaobai
 * @description: 使用@Value属性注入的方式
 * @date 2020/2/10 2:51 下午
 */

@Configuration
@PropertySource("classpath:test.properties")//7.注入配置文件
public class PropertyConfig {

    /**
     * 1.注入普通字符串
     */
    @Value("hello wprld")
    private String normal;

    /**
     * 2.注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 3.注入表达式结果
     */
    @Value("#{T(java.lang.Math).random()*100.0}")
    private double randomNumber;

    /**
     * 4.注入其他Bean属性
     */
    @Value("#{propertyService.property}")
    private String fromBean;

    /**
     * 5.注入文件资源
     */
    @Value("classpath:test.txt")
    private Resource testFile;

    /**
     * 6.注入网址资源
     */
    @Value("http://www.baidu.com")
    private Resource testUrl;

    /**
     * 7.注入配置文件
     */
    @Value("${test.property}")
    private String testProperty;

    /**
     * 7/注入配置文件
     */
    @Autowired
    private Environment environment;

    /**
     * 7.注入配置文件
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResoure() {
        try {
            //1.
            System.out.println(normal);
            //2.
            System.out.println(osName);
            //3.
            System.out.println(randomNumber);
            //4.
            System.out.println(fromBean);
            //5.
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            //6.
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            //7.注入配置文件方式一
            System.out.println(testProperty);
            //7.注入配置文件方式二
            System.out.println(environment.getProperty("test.property"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
