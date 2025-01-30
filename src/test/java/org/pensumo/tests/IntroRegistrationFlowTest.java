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


public class IntroRegistrationFlowTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
    }

    @Test(priority = 8)
    public void testIntroRegistrationFlowTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();

        Thread.sleep(10000);

        WebElement startSessionButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Iniciar sesión\"]")));
        startSessionButton.click();

        // WebElement userField = driver.findElement(By.id("uname"));
        WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"uname\"]")));
        userField.sendKeys("iary.corsiero@libero.it");

        //WebElement pwdField = driver.findElement(By.id("upassword"));
        WebElement pwdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"upassword\"]")));
        pwdField.sendKeys("Nttdata_2025");

        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"login_btn\"]")));
        loginButton.click();


        // After Login
        WebElement hola = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Hola,\"]")));
        ScreenshotUtils.takeScreenshot(driver, 16, "Introducción"); // Screenshot 2
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);

        Thread.sleep(1000);
        // After swipe
        ScreenshotUtils.takeScreenshot(driver, 17, "Introducción"); // Screenshot 2

    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}


