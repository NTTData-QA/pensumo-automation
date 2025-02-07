package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloseSessionFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 27)
        public void testCloseSession() {

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            WebElement closeSession = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Cerrar sesión\")"));
            ScreenshotUtils.takeScreenshot(driver, 88, "Cerrar Sesión");
            closeSession.click();

            WebElement closeSessionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Cerrar sesión\"]")));
            ScreenshotUtils.takeScreenshot(driver, 89, "Cerrar Sesión");
        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}
