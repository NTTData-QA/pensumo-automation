package org.pensumo.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class RegistrationFlowTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
    }

    @Test(priority = 7)
    public void testRegistrationFlowTest()throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();

        Thread.sleep(3000);

        WebElement registrationButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Registrarse\"]")));
        registrationButton.click();

        // Usuario
        WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"email\"]")));
        // Screenshot clean page
        ScreenshotUtils.takeScreenshot(driver, "Register");
        userField.sendKeys("fulanito@menganito.com");
        // Screenshot after usuario
        ScreenshotUtils.takeScreenshot(driver, "Register");

       // Password
        WebElement pwdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"password\"]")));
        pwdField.click(); //
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
        driver.hideKeyboard();
        // Confirm Password
        WebElement confirmPwdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"confirm_password\"]")));
        confirmPwdField.click(); //
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
        driver.hideKeyboard();

        Thread.sleep(3000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);  // Swipe verticale dal basso verso l'alto


        WebElement confirmButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"form_submit\"]")));
        confirmButton.click();
        Thread.sleep(2000);

        // Screenshot after Wrong Pwd
        ScreenshotUtils.takeScreenshot(driver, "Register");

    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}
