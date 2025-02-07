package org.pensumo.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    private static WebDriverWait wait;



    public static void enterText(WebDriver driver, By locator, String text, String fieldName, WebDriverWait wait) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (element.isDisplayed()) {
                element.sendKeys(text);
            } else {
                throw new RuntimeException("Element not displayed: " + fieldName);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter text in " + fieldName + ": " + e.getMessage(), e);
        }
    }


    public static void clickElement(AndroidDriver driver, By locator, String elementName, WebDriverWait wait) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println(elementName + " clicked successfully.");
        } catch (Exception e) {
            throw new RuntimeException("Failed to click " + elementName + ": " + e.getMessage());
        }
    }
    public static void clickOrScroll(AndroidDriver driver, By locator, String elementName) throws InterruptedException {
    while (true) {
      try {
        WebElement element = driver.findElement(locator);
        element.click();
        System.out.println(elementName + " clicked successfully.");
        break;
      } catch (Exception e) {
        // scroll down
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        Thread.sleep(100);
      }
    }
    }

    public static void sendKeysOrScroll(AndroidDriver driver, By locator, String text, String elementName) throws InterruptedException {
    while (true) {
      try {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
        System.out.println(elementName + " written successfully.");
        break;
      } catch (Exception e) {
        // scroll down
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        Thread.sleep(100);
      }
    }
    }

    public static void sendKeysOrScroll(AndroidDriver driver, By locator, String text, String elementName, boolean clean) throws InterruptedException {
        while (true) {
            try {
                WebElement element = driver.findElement(locator);
                element.sendKeys(text);
                System.out.println(elementName + " written successfully.");
                if (clean) {
                    element.clear();
                    System.out.println(elementName + " cleaned successfully.");
                }
                break;
            } catch (Exception e) {
                // scroll down
                SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
                Thread.sleep(100);
            }
        }
    }
}
