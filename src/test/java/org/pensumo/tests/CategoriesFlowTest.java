package org.pensumo.tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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

public class CategoriesFlowTest {

        private AndroidDriver driver;
        private WebDriverWait wait;
        @BeforeClass
        public void setUp() {

            driver = DriverManagerUtils.initializeDriver();
            wait = WaitManagerUtils.initializeWait(driver, 60);
        }

        @Test(priority = 16)
        public void testCategories() throws InterruptedException{

            LoginUtils.performLogin(driver,"efatas@gmail.com", "Pensumo2025#");

            WebElement seeCommerce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Ver comercios\"]")));
            seeCommerce.click();
            WebElement categoriesPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"Categorías\"]")));
            categoriesPage.click();
            WebElement ArtAndCulture = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")));
            ScreenshotUtils.takeScreenshot(driver, 40, "Categorías");

            ArtAndCulture.click();
            WebElement ArtAndCultureTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"ARTE Y CULTURA\"]")));
            ScreenshotUtils.takeScreenshot(driver, 41, "Categorías");

            WebElement backIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageButton")));
            backIcon.click();
            WebElement findCommerce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")));
            findCommerce.click();
            WebElement findCommerceField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Buscar categorías o comercios\"]")));
            ScreenshotUtils.takeScreenshot(driver, 42, "Categorías");

            findCommerceField.sendKeys("bbc");
            WebElement notFoundField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"No hay coincidencias con tus criterios de búsqueda.\"]")));
            ScreenshotUtils.takeScreenshot(driver, 43, "Categorías");

            findCommerceField.clear();
            findCommerceField.sendKeys("embu");
            Thread.sleep(3000);
            ScreenshotUtils.takeScreenshot(driver, 44, "Categorías");

        }
    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
    }
