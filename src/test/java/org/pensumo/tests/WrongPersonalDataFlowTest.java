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

import java.time.Duration;


public class WrongPersonalDataFlowTest {
    private AndroidDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
        wait = WaitManagerUtils.initializeWait(driver, 60);
    }

    @Test(priority = 9)
    public void testPersonalDataFlowTest() throws InterruptedException{
        LoginUtils.performLogin(driver,"iary.corsiero@libero.it", "Pensumo21!");
        LoginUtils.handleIntroPage(driver, wait);

        WebElement headParsonalData = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Datos personales y creación de cuenta\"]")));
        ScreenshotUtils.takeScreenshot(driver, 18, "Datos personales"); // Screenshot 1

        //Filling fields for wrong test
        //Name
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"ej. Pilar\"]")));
        nameField.sendKeys("AAA");
        nameField.clear();
        driver.hideKeyboard();
        //surname
        WebElement surnameField = driver.findElement(By.xpath("//android.widget.EditText[@text=\"ej. Perez García\"]"));
        surnameField.click();
        surnameField.sendKeys("AAA");
        surnameField.clear();
        driver.hideKeyboard();
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        ScreenshotUtils.takeScreenshot(driver, 19, "Datos personales");
        //Dni
        WebElement dniField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"ej. 56743917R\"]")));
        dniField.click();
        dniField.sendKeys("329459");
        //Date of Birth
        WebElement birthField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"ej. 01/01/2006\"]")));
        birthField.click(); // Assicurati che il campo sia attivo
        //Choose Year
        WebElement  choseYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/date_picker_header_year")));
        choseYear.click();// clicca sull'anno
        //Select Year
        WebElement  selectYear = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"2026\"]")));
        selectYear.click();
        //Button OK Calendar
        WebElement  buttonOK = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
        buttonOK.click();
        //MobilePhone
        WebElement phoneField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"ej. 000 000 000\"]")));
        phoneField.sendKeys("0000000");

        ScreenshotUtils.takeScreenshot(driver, 20, "Datos personales");
        /*
        //Date of Birth
        By dateFieldLocator = By.xpath("//android.widget.EditText[@text='14/01/2026']");
        WebElement dateField = driver.findElement(dateFieldLocator);
        //dateField.clear();
        dateField.sendKeys("29/09/1975");
        WebElement outsideElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout"));
        outsideElement.click();
        Este no funciona
        */

    }


    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}


