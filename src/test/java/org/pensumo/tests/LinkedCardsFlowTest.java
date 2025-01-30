package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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

public class LinkedCardsFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 23)
        public void testLinkedCards() throws InterruptedException{

            LoginUtils.performLogin(driver,"raulgalerasancho@gmail.com", "Nttdata_2025");
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            profileButton.click();

            WebElement myLinkedCards = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Tarjetas vinculadas\"]")));
            myLinkedCards.click();
            WebElement linkedCardsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"TARJETAS VINCULADAS\"]")));
            ScreenshotUtils.takeScreenshot(driver, "Tarjetas vinculadas");

            WebElement addCardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text=\"Agregar nueva tarjeta\"]")));
            addCardButton.click();
            WebElement webView = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.webkit.WebView")));
            Thread.sleep(2000);
            ScreenshotUtils.takeScreenshot(driver, "Tarjetas vinculadas");


            //ScreenshotUtils.takeScreenshot(driver, "Tarjetas vinculadas");
            //ScreenshotUtils.takeScreenshot(driver, "Tarjetas vinculadas");
            //ScreenshotUtils.takeScreenshot(driver, "Tarjetas vinculadas");
            //ScreenshotUtils.takeScreenshot(driver, "Tarjetas vinculadas");

            WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton")));
            backButton.click();
            WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")));
            deleteButton.click();
            ScreenshotUtils.takeScreenshot(driver, "Tarjetas vinculadas");

        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
