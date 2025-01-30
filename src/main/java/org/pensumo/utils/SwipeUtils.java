package org.pensumo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;

public class SwipeUtils {


    public static void swipeHorizontal(WebDriver driver, double startPercentage, double endPercentage, double anchorPercentage, int duration) {
        Dimension size = driver.manage().window().getSize();

        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startPoint, anchor));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endPoint, anchor));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AndroidDriver) driver).perform(List.of(swipe));
    }


    public static void swipeVertical(WebDriver driver, double startPercentage, double endPercentage, double anchorPercentage, int duration) {
        Dimension size = driver.manage().window().getSize();

        int anchor = (int) (size.width * anchorPercentage); // Ancoraggio sull'asse orizzontale
        int startPoint = (int) (size.height * startPercentage); // Punto di partenza sulla Y
        int endPoint = (int) (size.height * endPercentage); // Punto di arrivo sulla Y

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), anchor, startPoint));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), anchor, endPoint));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AndroidDriver) driver).perform(List.of(swipe));
    }
    public static void swipeVerticalUntil(WebDriver driver, By locator, double startPercentage, double endPercentage, double anchorPercentage, int duration, int maxSwipes) {
        int attempts = 0;
        while (attempts < maxSwipes) {
            try {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                // Element not found, perform swipe
                swipeVertical(driver, startPercentage, endPercentage, anchorPercentage, duration);
                attempts++;
            }
        }
        throw new RuntimeException("Element not found after " + maxSwipes + " try swipe.");
    }

}
