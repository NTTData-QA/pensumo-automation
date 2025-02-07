package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.DriverManagerUtils;
import org.pensumo.utils.LoginUtils;
import org.pensumo.utils.ScreenshotUtils;
import org.pensumo.utils.WaitManagerUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProtectionFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 28)
        public void testDataProtection() throws InterruptedException {

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");

            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            WebElement dataProtection = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Protección de Datos\"]")));
            dataProtection.click();

            WebElement downloadDocument = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.chrome:id/positive_button")));
            downloadDocument.click();
            WebElement continueOpenPdf = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.android.chrome:id/positive_button")));
            continueOpenPdf.click();
            WebElement chooseReader = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.FrameLayout[@resource-id=\"android.miui:id/masklayout\"])[1]")));
            chooseReader.click();
            Thread.sleep(3000);
            ScreenshotUtils.takeScreenshot(driver, 64, "Protección de datos");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));




/*
            WebElement dataProtectionDocument = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.google.android.apps.docs:id/projector_coordinator\"]")));
            ScreenshotUtils.takeScreenshot(driver, 64, "Protección de datos");
            WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]")));
            backButton.click();

 */

        }

    }
