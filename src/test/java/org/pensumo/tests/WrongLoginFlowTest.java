package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.DriverManagerUtils;
import org.pensumo.utils.ScreenshotUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class WrongLoginFlowTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
    }

    @Test(priority = 5)
    public void testWrongLoginFlowTest() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();

        Thread.sleep(10000);

         WebElement startSessionButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Iniciar sesión\"]")));

        startSessionButton.click();
        // After Start Session
        ScreenshotUtils.takeScreenshot(driver, 9, "Log in");
        WebElement userField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='uname']"));
        //WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='uname']")));
        userField.click();
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.hideKeyboard();

        WebElement pwdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"upassword\"]")));
        pwdField.click();
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.A));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.hideKeyboard();

        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"login_btn\"]")));
        loginButton.click();

        // After WrongName&Pwd
        ScreenshotUtils.takeScreenshot(driver, 10, "Log in");

    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}