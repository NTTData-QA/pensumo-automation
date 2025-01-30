package org.pensumo.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManagerUtils {
    private static AndroidDriver driver;

    public static AndroidDriver initializeDriver() {
        if (driver == null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            //caps.setCapability("appium:deviceName", "Redmi 9T");
            caps.setCapability("appium:deviceName", "R5CXA2M6NLL");
            caps.setCapability("appium:automationName", "uiautomator2");
            caps.setCapability("appium:appPackage", "es.ibercaja.pensumoapp");
            caps.setCapability("appium:appActivity", "crc6471002644c6ec1325.MainActivity");
            caps.setCapability("appium:noReset", "false");
            try {
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium server URL", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
