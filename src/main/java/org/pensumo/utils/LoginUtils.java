/*
package org.pensumo.utils;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginUtils {

    public static void performLogin(AndroidDriver driver, String username, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // Click sul pulsante "Saltar"
        WebElement jumpButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Saltar']")));
        jumpButton.click();

        // Attendi 10 secondi per eventuali animazioni o transizioni
        Thread.sleep(10000);

        // Clicca sul pulsante "Iniciar sesión"
        WebElement startSessionButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.view.View[@content-desc=\"Iniciar sesión\"]")));
        startSessionButton.click();

        // Inserisci username
        WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.EditText[@resource-id=\"uname\"]")));
        userField.sendKeys(username);

        // Inserisci password
        WebElement pwdField = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.EditText[@resource-id=\"upassword\"]")));
        pwdField.sendKeys(password);

        // Clicca sul pulsante di login
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.Button[@resource-id=\"login_btn\"]")));
        loginButton.click();

        // Attendi 3 secondi per completare il login
        Thread.sleep(3000);
    }
}

 */
package org.pensumo.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginUtils {

    // Costant 4 selector
    private static final By JUMP_BUTTON = By.xpath("//android.widget.TextView[@text='Saltar']");
    private static final By START_SESSION_BUTTON = By.xpath("//android.view.View[@content-desc=\"Iniciar sesión\"]");
    private static final By USERNAME_FIELD = By.xpath("//android.widget.EditText[@resource-id=\"uname\"]");
    private static final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[@resource-id=\"upassword\"]");
    private static final By LOGIN_BUTTON = By.xpath("//android.widget.Button[@resource-id=\"login_btn\"]");
    // private static final By NEXT_BUTTON = By.xpath("//android.widget.ImageButton");
    // Use new UiSelector().className("android.widget.ImageButton") to find element
    private static final By NEXT_BUTTON = AppiumBy.className("android.widget.ImageButton");

    /**
     * Login app.
     *
     * @param driver   Driver.
     * @param username Username.
     * @param password Password.
     */
    public static void performLogin(AndroidDriver driver, String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        try {
            // Click sul pulsante "Saltar"
            waitForElementAndClick(driver, wait, JUMP_BUTTON);

            // Clicca sul pulsante "Iniciar sesión"
            waitForElementAndClick(driver, wait, START_SESSION_BUTTON);

            // Inserisci username
            WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(USERNAME_FIELD));
            userField.sendKeys(username);

            // Inserisci password
            WebElement pwdField = wait.until(ExpectedConditions.presenceOfElementLocated(PASSWORD_FIELD));
            pwdField.sendKeys(password);

            // Clicca sul pulsante di login
            waitForElementAndClick(driver, wait, LOGIN_BUTTON);
            Thread.sleep(5000);

        } catch (Exception e) {
            throw new RuntimeException("Errore durante il login: " + e.getMessage(), e);
        }
    }

    /**
     * Intro with swipe e click on "Next".
     *
     * @param driver Driver.
     * @param wait   WebDriverWait.
     */
    public static void handleIntroPage(AndroidDriver driver, WebDriverWait wait) {
        try {
            // Skip back button with the same identifier as NEXT_BUTTON
            SwipeUtils.swipeVertical(driver, 0.8, 0.7, 0.5, 500);
            ElementUtils.clickOrScroll(driver, NEXT_BUTTON, "Next Button");

            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la navigazione della pagina introduttiva: " + e.getMessage(), e);
        }
    }

    /**
     * Wait Element visibile and click.
     *
     * @param driver  Driver.
     * @param wait    WebDriverWait.
     * @param locator Element.
     */
    private static void waitForElementAndClick(AndroidDriver driver, WebDriverWait wait, By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }
}
