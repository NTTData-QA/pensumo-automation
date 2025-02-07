package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

public class UnsubscribeFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 26)
        public void testUnsubscribe() {

            LoginUtils.performLogin(driver,"acrespov@nttdata.com", "Pensumo21!");
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            WebElement unsubscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Darse de baja\"]")));
            unsubscribe.click();
            WebElement yesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Sí, darme de baja\"]")));
            ScreenshotUtils.takeScreenshot(driver, 84, "Darse de baja");

            yesButton.click();
            WebElement unsubscribeTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Darse de baja\"]")));
            ScreenshotUtils.takeScreenshot(driver, 85, "Darse de baja");


            WebElement codeField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText")));
            codeField.click();
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
            driver.pressKey(new KeyEvent(AndroidKey.ENTER));
            driver.hideKeyboard();
            ScreenshotUtils.takeScreenshot(driver, 86, "Darse de baja");

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Continuar\"]")));
            continueButton.click();
            WebElement wrongCodeLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Código de confirmación incorrecto\"]")));
            ScreenshotUtils.takeScreenshot(driver, 87, "Darse de baja");

            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Cerrar\"]")));
            //android.widget.ImageButton      X
        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
