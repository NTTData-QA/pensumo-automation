package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
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

public class MyContractsFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 22)
        public void testMyContracts() throws InterruptedException{

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            WebElement myContract = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Mis Contratos\"]")));
            ScreenshotUtils.takeScreenshot(driver, 65, "Mis contratos");

            myContract.click();
            WebElement downloadContract = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageButton")));
            ScreenshotUtils.takeScreenshot(driver, 66, "Mis contratos");

            downloadContract.click();
            WebElement androidSaveButtom = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
            ScreenshotUtils.takeScreenshot(driver, 67, "Mis contratos");

            androidSaveButtom.click();
            //WebElement correctDownload = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Archivo descargado correctamente\"]")));
            // este wait me cierra la App
            WebElement altaPensumoTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"ALTAS EN PENSUMO\"]")));
            ScreenshotUtils.takeScreenshot(driver, 68, "Mis contratos");

        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
