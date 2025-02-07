
package org.pensumo.tests;



import io.appium.java_client.android.AndroidDriver;
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


public class ForgetPasswordFlowTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
    }

    @Test(priority = 6)
    public void testForgetPasswordFlowTest() throws InterruptedException{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();

        WebElement startSessionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Iniciar sesión\"]")));
        startSessionButton.click();
        WebElement forgetPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Olvidé mi contraseña\"]")));
        forgetPassword.click();

        Thread.sleep(1000);
        ScreenshotUtils.takeScreenshot(driver, 11, "Olvidé mi contraseña"); // Screenshot 1

        WebElement nameField = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"uname\"]"));
        nameField.sendKeys("corsiero.iary@libero.it");
        WebElement sendButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"pwd_email_send\"]"));
        sendButton.click();

        Thread.sleep(1000);
        ScreenshotUtils.takeScreenshot(driver, 12, "Olvidé mi contraseña"); // Screenshot 2

    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}


// prova refactoring
/*
package org.pensumo.tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.WaitManagerUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.pensumo.utils.DriverManagerUtils;
import org.pensumo.utils.ElementUtils;
import org.pensumo.utils.ScreenshotUtils;
import java.time.Duration;

public class ForgetPasswordFlowTest {
    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
        wait = WaitManagerUtils.initializeWait(driver, 30);
    }

    @Test(priority = 6)
    public void testForgetPasswordFlowTest() {
        try {
            // Salta il tutorial
            ElementUtils.clickElement(driver, By.xpath("//android.widget.TextView[@text='Saltar']"), "Jump Button", wait);

            // Naviga alla schermata di recupero password
            ElementUtils.clickElement(driver, By.xpath("//android.view.View[@content-desc='Iniciar sesión']"), "Start Session Button", wait);
            ElementUtils.clickElement(driver, By.xpath("//android.view.View[@content-desc='Olvidé mi contraseña']"), "Forget Password Button",wait);

            // Screenshot
            ScreenshotUtils.takeScreenshot(driver, 11, "Olvidé mi contraseña");

            // Inserisce l'email e invia
            ElementUtils.enterText(driver, By.xpath("//android.widget.EditText[@resource-id='uname']"),
                    "corsiero.iary@libero.it", "email", wait);

            ElementUtils.clickElement(driver, By.xpath("//android.widget.Button[@resource-id='pwd_email_send']"), "Send Button",wait);

            // Screenshot finale
            ScreenshotUtils.takeScreenshot(driver, 12, "Olvidé mi contraseña");
        } catch (Exception e) {
            throw new RuntimeException("Test Forget Password Flow Failed", e);
        }
    }

    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}

 */

