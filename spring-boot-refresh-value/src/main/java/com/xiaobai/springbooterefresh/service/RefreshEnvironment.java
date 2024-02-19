package com.xiaobai.springbooterefresh.service;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @className RefreshEnvironment
 * @description  定义一个工具类实现配置转换
 **/
@Component
public class RefreshEnvironment  implements EnvironmentAware {

    private static ConfigurableEnvironment environment;

    public static void updateValue(String key, Object newValue){
        //自定的义配置文件名称
        MutablePropertySources propertySources1 = environment.getPropertySources();
        propertySources1.stream().forEach(x -> {
            if (x instanceof MapPropertySource){
                MapPropertySource propertySource = (MapPropertySource) x;
                if (propertySource.containsProperty(key)){
                    String proname = propertySource.getName();
                    Map<String, Object> source = propertySource.getSource();
                    Map<String, Object> map = new HashMap<>(source.size());
                    map.putAll(source);
                    map.put(key, newValue);
                    environment.getPropertySources().replace(proname, new MapPropertySource(proname, map));
                }
            }
        });

    }

    @Override
    public void setEnvironment(Environment environment) {
        RefreshEnvironment.environment = (ConfigurableEnvironment) environment;
    }
}
