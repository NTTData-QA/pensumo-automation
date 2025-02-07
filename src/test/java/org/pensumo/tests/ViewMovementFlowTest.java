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

public class ViewMovementFlowTest {

  private AndroidDriver driver;
  private WebDriverWait wait;

  @BeforeClass
  public void setUp() {

    driver = DriverManagerUtils.initializeDriver();
    wait = WaitManagerUtils.initializeWait(driver, 60);
  }

  @Test(priority = 12)
  public void testViewMovement() {

    LoginUtils.performLogin(driver, "efatas@gmail.com", "Pensumo2025#");

    WebElement accumulatedWidget =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text=\"ACUMULADO\"]")));
    accumulatedWidget.click();

    // WebElement accumulatedTitle =
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Accumulated title. Añadir
    // Xpath")));

    ScreenshotUtils.takeScreenshot(driver, 32, "Ver Movimiento");

    WebElement firstMovementWidjet =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text=\"Ver movimientos\"]")));
    firstMovementWidjet.click();

    WebElement firstMovementTitle =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                    "//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")));

    ScreenshotUtils.takeScreenshot(driver, 33, "Ver Movimiento");
    firstMovementTitle.click();
    WebElement firstMovementImage =
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath(
                    "//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")));

    ScreenshotUtils.takeScreenshot(driver, 34, "Ver Movimiento");
  }

  @AfterClass
  public void tearDown() {
    DriverManagerUtils.quitDriver();
  }
}
