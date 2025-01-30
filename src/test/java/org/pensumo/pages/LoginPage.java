package org.pensumo.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.DriverManagerUtils;
import org.pensumo.utils.ScreenshotUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
    }

    @Test(priority = 3)
    public void testLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();

        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Image[@text=\"Pensumo Logo\"]")));

        ScreenshotUtils.takeScreenshot(driver, "Log in_Register Page");
    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
}
}