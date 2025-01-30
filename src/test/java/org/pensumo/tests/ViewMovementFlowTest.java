package org.pensumo.tests;

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

public class ViewMovementFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 12)
        public void testViewMovement() {

            LoginUtils.performLogin(driver,"raulgalerasancho@gmail.com", "Nttdata_2025");
            //TODO
            WebElement accumulatedWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Accumulated widjet. Añadir Xpath")));
            accumulatedWidget.click();

            WebElement accumulatedTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Accumulated title. Añadir Xpath")));

            ScreenshotUtils.takeScreenshot(driver, "Ver Movimiento");

            WebElement firstMovementWidjet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("First Movement widjet. Añadir Xpath")));
            firstMovementWidjet.click();

            WebElement firstMovementTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("First Movement tile. Añadir Xpath")));

            ScreenshotUtils.takeScreenshot(driver, "Ver Movimiento");

        }

        @AfterClass
        public void tearDown() {
            DriverManagerUtils.quitDriver();
        }
    }

