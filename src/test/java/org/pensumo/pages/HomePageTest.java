package org.pensumo.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");
        WebElement accumulatedWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"ACUMULADO\"]")));
        ScreenshotUtils.takeScreenshot(driver, 31, "Home Page");
    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}
