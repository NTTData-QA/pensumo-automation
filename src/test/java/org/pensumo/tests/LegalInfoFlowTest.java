package org.pensumo.tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.DriverManagerUtils;
import org.pensumo.utils.ScreenshotUtils;
import org.pensumo.utils.SwipeUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;


public class LegalInfoFlowTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
    }

    @Test(priority = 4)
    public void testLegalInfoFlowTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();


        WebElement legalInfo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Aviso legal\"]")));
        legalInfo.click();
        Thread.sleep(3000);

        //WebElement aceptarButton = driver.findElement(By.xpath("//android.widget.Button[@text=\"ACEPTAR\"]"));
        WebElement aceptarButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@text=\"ACEPTAR\"]")));
        aceptarButton.click();
        Thread.sleep(3000);

        // After cookies
        ScreenshotUtils.takeScreenshot(driver, "Condiciones de uso"); // Screenshot 1

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);  // Swipe verticale dal basso verso l'alto

        //After swipe
        ScreenshotUtils.takeScreenshot(driver, "Condiciones de uso"); // Screenshot 2
        // If we want to see all Term&Cond we need more screenshot ( almost 29)


    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}

