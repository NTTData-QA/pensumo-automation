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
}
