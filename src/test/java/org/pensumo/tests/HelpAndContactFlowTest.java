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

public class HelpAndContactFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 25)
        public void testHelpAndContact () throws InterruptedException {

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            WebElement helpAndContact = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Ayuda y contacto\"]")));
            helpAndContact.click();
            WebElement helpAndContactTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"AYUDA Y CONTACTO\"]")));
            Thread.sleep(2000);
            ScreenshotUtils.takeScreenshot(driver, 82, "Ayuda y contacto");
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            ScreenshotUtils.takeScreenshot(driver, 83, "Ayuda y contacto");

        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
