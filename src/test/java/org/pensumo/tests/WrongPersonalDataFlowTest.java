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
        LoginUtils.performLogin(driver,"iary.corsiero@libero.it", "Nttdata_2025");
        LoginUtils.handleIntroPage(driver, wait);
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();

        Thread.sleep(10000);

        WebElement startSessionBotton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Iniciar sesión\"]")));
        startSessionBotton.click();

        // WebElement userField = driver.findElement(By.id("uname"));
        WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"uname\"]")));
        userField.sendKeys("iary.corsiero@libero.it");

        //WebElement pwdField = driver.findElement(By.id("upassword"));
        WebElement pwdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"upassword\"]")));
        pwdField.sendKeys("Nttdata_2025");

        WebElement loginBotton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"login_btn\"]")));
        loginBotton.click();
        Thread.sleep(5000);

        // After Login
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement nextBotton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageButton")));
        nextBotton.click();

        */
        WebElement headParsonalData = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Datos personales y creación de cuenta\"]")));
        ScreenshotUtils.takeScreenshot(driver, "Datos personales"); // Screenshot 1

        //Filling fields for wrong test
        //Name
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. Pilar\"]"), "Name Field");
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. Pilar\"]"), "AA", "Name Field", true);
        driver.hideKeyboard();
        //surname
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. Perez García\"]"), "AA", "Surname Field", true);
        driver.hideKeyboard();
        // SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        ScreenshotUtils.takeScreenshot(driver, "Datos personales");
        //Dni
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. 56743917R\"]"), "329459", "Dni Field");
        //Date of Birth
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.TextView[@text=\"ej. 01/01/2006\"]"), "Birth Field");
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
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. 000 000 000\"]"), "0000000", "Phone Field");

        ScreenshotUtils.takeScreenshot(driver, "Datos personales");
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


