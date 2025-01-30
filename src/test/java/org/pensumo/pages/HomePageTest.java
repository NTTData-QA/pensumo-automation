package org.pensumo.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.DriverManagerUtils;
import org.pensumo.utils.LoginUtils;
import org.pensumo.utils.ScreenshotUtils;
import org.pensumo.utils.WaitManagerUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
    private AndroidDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setUp() {

        driver = DriverManagerUtils.initializeDriver();
        wait = WaitManagerUtils.initializeWait(driver, 60);
    }

    @Test(priority = 11)
    public void testHomePage() {

        LoginUtils.performLogin(driver,"raulgalerasancho@gmail.com", "Nttdata_2025");
        ScreenshotUtils.takeScreenshot(driver, "Home Page");
    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}
