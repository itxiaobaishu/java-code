package com.xiaobai.javacode;

import com.xiaobai.javacode.config.PropertyConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JavaCodeApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private PropertyConfig propertyConfig;

    @Test
    public void propertyConfigTest() {
        propertyConfig.outputResoure();
    }

}
