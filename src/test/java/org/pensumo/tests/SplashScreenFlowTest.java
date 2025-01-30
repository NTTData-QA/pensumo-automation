package org.pensumo.tests;

import io.appium.java_client.AppiumBy;
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

public class SplashScreenFlowTest {
  private AndroidDriver driver;

  @BeforeClass
  public void setUp() {
    driver = DriverManagerUtils.initializeDriver();
  }

  @Test(priority = 1)
  public void testSplashScreen() throws InterruptedException {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    WebElement jumpButton =
        driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
    jumpButton.click();
    WebElement splash =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath(
                    "//android.widget.TextView[@text=\"Un extra para tu futuro con tus compras de hoy\"]")));

    ScreenshotUtils.takeScreenshot(driver, "Splash Screen");
    WebElement loading =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath(
                    " //android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")));
    // WebElement loading =
    // wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("android:id/content")));
    ScreenshotUtils.takeScreenshot(driver, "Splash Screen");
    // need to improve
    //
  }

  @AfterClass
  public void tearDown() {
    DriverManagerUtils.quitDriver();
  }
}
