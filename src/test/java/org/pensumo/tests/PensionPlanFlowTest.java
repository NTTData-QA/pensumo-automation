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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PensionPlanFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 24)
        public void testPensionPlan() throws InterruptedException {

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            WebElement pensionPlan = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Plan de pensiones\"]")));
            pensionPlan.click();
            WebElement movementButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Movimientos\"]")));
            ScreenshotUtils.takeScreenshot(driver, 76, "Plan de pensiones");

            movementButton.click();
            WebElement filterButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Filtrar por fecha\"]")));
            ScreenshotUtils.takeScreenshot(driver, 77, "Plan de pensiones");

            filterButton.click();
            WebElement applyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Aplicar\"]")));
            ScreenshotUtils.takeScreenshot(driver, 78, "Plan de pensiones");

            WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton")));
            backButton.click();
            WebElement documentsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Documentos Legales\"]")));
            documentsButton.click();
            WebElement contractTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Contrato\"]")));
            ScreenshotUtils.takeScreenshot(driver, 79, "Plan de pensiones");

            contractTitle.click();
            WebElement yourPlanContract = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"El contrato de tu plan de pensiones\"]")));
            ScreenshotUtils.takeScreenshot(driver, 80, "Plan de pensiones");

            WebElement infoTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Info reglamentaria\"]")));
            infoTitle.click();
            WebElement downloadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")));
            downloadButton.click();
            Thread.sleep(3000);
            ScreenshotUtils.takeScreenshot(driver, 81, "Plan de pensiones");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.pressKey(new KeyEvent(AndroidKey.BACK));

        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
