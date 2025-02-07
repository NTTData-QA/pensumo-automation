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

public class ConsentsFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 20)
        public void testConsents() throws InterruptedException{

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            WebElement consent = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Consentimientos\"]")));
            consent.click();
            WebElement infoDataProtection = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Información Básica de Protección de Datos Personales\"]")));

            //WebElement consentTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"CONSENTIMIENTOS\"]")));
            Thread.sleep(3000);
            ScreenshotUtils.takeScreenshot(driver, 58, "Consentimientos");

            //SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            //SwipeUtils.swipeVerticalUntil(driver, By.xpath("//android.widget.CompoundButton"),0.8,0.2,0.5,100,20);
            WebElement radioDeclaration = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.CompoundButton")));
            radioDeclaration.click();
            WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Aceptar\"]")));
            ScreenshotUtils.takeScreenshot(driver, 59, "Consentimientos");

            acceptButton.click();
            WebElement linkPdf = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Información Básica de Protección de Datos Personales\"]")));
            linkPdf.click();
            WebElement acceptButton2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Aceptar\"]")));
            ScreenshotUtils.takeScreenshot(driver, 60, "Consentimientos");

            acceptButton2.click();
            radioDeclaration.click();
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            WebElement radioButtonCommercialComunicationsNo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"No\"]")));
            radioButtonCommercialComunicationsNo1.click();
            ScreenshotUtils.takeScreenshot(driver, 61, "Consentimientos");
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            WebElement radioButtonCommercialComunicationsNo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"No\"]")));
            radioButtonCommercialComunicationsNo2.click();
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            WebElement radioButtonCommercialComunicationsNo3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"No\"]")));
            radioButtonCommercialComunicationsNo3.click();
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            WebElement radioButtonCommercialComunicationsNo4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"No\"]")));
            radioButtonCommercialComunicationsNo4.click();
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
            WebElement radioButtonCommercialComunicationsNo5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"No\"]")));
            radioButtonCommercialComunicationsNo5.click();
            WebElement radioButtonConfirmSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.CompoundButton")));
            radioButtonConfirmSelection.click();
            ScreenshotUtils.takeScreenshot(driver, 62, "Consentimientos");

            WebElement saveChangeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text=\"Guardar Cambios\"]")));
            saveChangeButton.click();
            Thread.sleep(1000);
            ScreenshotUtils.takeScreenshot(driver, 63, "Consentimientos");

        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
