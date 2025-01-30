package org.pensumo.tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CommerceDetailFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;

    private static final By BACK_COMMERCE_BUTTON = By.xpath("//android.widget.ImageButton");
    private static final By BACK_CATEGORIES_BUTTON = By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageButton");

    @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 17)
        public void testCommerceDetail() throws InterruptedException{

            LoginUtils.performLogin(driver,"raulgalerasancho@gmail.com", "Nttdata_2025");
            WebElement seeCommerce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Ver comercios\"]")));
            seeCommerce.click();
            WebElement categoriesPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Categorías\"]")));
            categoriesPage.click();
            SwipeUtils.swipeVerticalUntil(driver, By.xpath("//android.widget.TextView[@text=\"Ocio y entretenimiento\"]"), 0.8,0.2, 0.5, 1000, 10);

            WebElement leisureAndEntertainment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Ocio y entretenimiento\"]")));
            leisureAndEntertainment.click();
            WebElement leisureAndEntertainmentTile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"OCIO Y ENTRETENIMIENTO\"]")));
            WebElement commerceButtonLibreriaAlbareda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Librería Albareda\"]")));
            commerceButtonLibreriaAlbareda.click();
            WebElement libraryAlbaredaTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Librería Albareda\"]")));
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");

            WebElement informationTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Información\"]")));
            informationTitle.click();
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");

            WebElement conditionTitleLibreriaAlbareda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Condiciones\"]")));
            conditionTitleLibreriaAlbareda.click();                                                                                      //android.widget.Button[@text="Condiciones"]
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");

            waitForElementAndClick(driver, wait, BACK_COMMERCE_BUTTON);
            waitForElementAndClick(driver, wait, BACK_CATEGORIES_BUTTON);

            WebElement other = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Otros\"]")));
            other.click();
            WebElement eliteCustomeGift = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"ELITE CUSTOME GIFT SL\"]")));
            eliteCustomeGift.click();
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");
            WebElement conditionTitleEliteCustomeGift = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Condiciones\"]")));
            conditionTitleEliteCustomeGift.click();
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");

            waitForElementAndClick(driver, wait, BACK_COMMERCE_BUTTON);
            waitForElementAndClick(driver, wait, BACK_CATEGORIES_BUTTON);

            leisureAndEntertainment.click();
            WebElement commerceButtonCasademontZaragoza = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Casademont Zaragoza\"]")));
            commerceButtonCasademontZaragoza.click();
            WebElement casademontZaragozaTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Casademont Zaragoza\"]")));
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");
            WebElement conditionTitleCasademontZaragoza = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Condiciones\"]")));
            conditionTitleCasademontZaragoza.click();
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");

            waitForElementAndClick(driver, wait, BACK_COMMERCE_BUTTON);
            waitForElementAndClick(driver, wait, BACK_CATEGORIES_BUTTON);

            SwipeUtils.swipeVerticalUntil(driver, By.xpath("//android.widget.TextView[@text=\"Infantil\"]"), 0.2,0.8, 0.5, 1000, 10);
            WebElement childish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Infantil\"]")));
            childish.click();
            WebElement commerceToysRUs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup")));
            commerceToysRUs.click();
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");
            WebElement conditionTitleToysRUs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Condiciones\"]")));
            conditionTitleToysRUs.click();
            ScreenshotUtils.takeScreenshot(driver, "Detalle Comercio");

        }
    private static void waitForElementAndClick(AndroidDriver driver, WebDriverWait wait, By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
