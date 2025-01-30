package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForYouFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 14)
        public void testForYou() {

            LoginUtils.performLogin(driver,"raulgalerasancho@gmail.com", "Nttdata_2025");

            //WebElement seeCommerce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Ver Comercios widget. Añadir Xpath")));
            //seeCommerce.click();
            WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[2]")));
            cartButton.click();
            WebElement forYouPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Para ti\"]")));
            forYouPage.click();
            WebElement commerceSubPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Comercios\"]")));
            ScreenshotUtils.takeScreenshot(driver, "Para ti");
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            ScreenshotUtils.takeScreenshot(driver, "Para ti");
        }
        @AfterClass
        public void tearDown() {
            DriverManagerUtils.quitDriver();
        }
    }



