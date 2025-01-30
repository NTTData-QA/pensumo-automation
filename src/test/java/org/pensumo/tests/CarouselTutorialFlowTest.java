package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.DriverManagerUtils;
import org.pensumo.utils.ScreenshotUtils;
import org.pensumo.utils.SwipeUtils;
import org.pensumo.utils.WaitManagerUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CarouselTutorialFlowTest {
    private AndroidDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setUp() {

        driver = DriverManagerUtils.initializeDriver();
        wait = WaitManagerUtils.initializeWait(driver, 60);

    }

    @Test(priority = 2)
    public void testCarouselTutorial() throws InterruptedException{

        WebElement ahorra = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Ahorra para el futuro\"]")));
        ScreenshotUtils.takeScreenshot(driver,"Carrusel Informativo");

        SwipeUtils.swipeHorizontal(driver, 0.8, 0.2, 0.5, 1000);
        WebElement sinCambiar = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Sin cambiar tus hábitos\"]")));
        ScreenshotUtils.takeScreenshot(driver,"Carrusel Informativo");

        SwipeUtils.swipeHorizontal(driver, 0.8, 0.2, 0.5, 1000);

        WebElement empezarButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Empezar\"]")));
        ScreenshotUtils.takeScreenshot(driver,"Carrusel Informativo");
    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}


