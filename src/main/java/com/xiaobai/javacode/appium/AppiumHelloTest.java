package com.xiaobai.javacode.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * @author xiaobai
 * @description: TODO
 * @date 2019/11/23 1:12 AM
 */
public class AppiumHelloTest {

    private AppiumDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android"); //指定测试平台
        cap.setCapability("deviceName", "0605edb8db97ee23"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "4.4");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");

        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity","com.android.calculator2.Calculator");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @Test
    public void plus(){

        //获取1
        driver.findElementById("com.android.calculator2:id/digit1").click();
        //获取+
        driver.findElementById("com.android.calculator2:id/plus").click();
        //获取2
        driver.findElementById("com.android.calculator2:id/digit2").click();
        //获取=
        driver.findElementById("com.android.calculator2:id/equal").click();


    }

    @AfterClass
    public void tearDown() throws Exception {

        driver.quit();

    }
}
