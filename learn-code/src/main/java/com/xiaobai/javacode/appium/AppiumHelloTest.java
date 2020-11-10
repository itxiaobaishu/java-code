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
        cap.setCapability("deviceName", "127.0.0.1:5555"); //指定测试机的ID,通过adb命令`adb devices`获取
        cap.setCapability("platformVersion", "6.0.1");

        //将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", "com.tencent.mm");
        cap.setCapability("appActivity", ".ui.LauncherUI");

        //A new session could not be created的解决方法
        cap.setCapability("appWaitActivity",".ui.LauncherUI");
        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);
        cap.setCapability("noReset", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    @Test
    public void plus(){

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取1
        driver.findElementById("com.tencent.mm:id/cnh").click();
        //获取+
        driver.findElementById("com.tencent.mm:id/cox").click();
        //获取2
        driver.findElementById("com.tencent.mm:id/cn1").click();
        //获取=
//        driver.findElementById("com.android.calculator2:id/equal").click();


    }

    @AfterClass
    public void tearDown() throws Exception {

//        driver.quit();

    }
}
