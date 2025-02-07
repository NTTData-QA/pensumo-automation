package org.pensumo.tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonFlowTest {
        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 15)
        public void testAmazon () throws InterruptedException {

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");

            WebElement featuredWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            featuredWidget.click();
            //WebElement featuredPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Destacados Pagina. Añadir Xpath")));
            //featuredPage.click();

            WebElement amazonTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"AMAZON\"]")));

            //Thread.sleep(3000);
            ScreenshotUtils.takeScreenshot(driver, 38, "Amazon");
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            //WebElement promotionsPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Promociones . Añadir Xpath")));
            //promotionsPage.click();
            Thread.sleep(3000);

            ScreenshotUtils.takeScreenshot(driver, 39, "Amazon");
        }
        @AfterClass
        public void tearDown() {
            DriverManagerUtils.quitDriver();
        }
    }


