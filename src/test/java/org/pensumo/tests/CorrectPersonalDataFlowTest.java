package org.pensumo.tests;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pensumo.utils.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class CorrectPersonalDataFlowTest {
    private AndroidDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setUp() {
        driver = DriverManagerUtils.initializeDriver();
        wait = WaitManagerUtils.initializeWait(driver, 60);
    }

    @Test(priority = 10)
    public void testPersonalDataFlowTest() throws InterruptedException{
        LoginUtils.performLogin(driver,"iary.corsiero@libero.it", "Nttdata_2025");
        LoginUtils.handleIntroPage(driver, wait);
        WebElement headParsonalData = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Datos personales y creación de cuenta\"]")));

        //Filling fields for right test
        //Name
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. Pilar\"]"), "FULANITO", "Name");

        //surname
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. Perez García\"]"), "MENGANITO", "Surname");

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");
        // SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);

        //Dni
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. 56743917R\"]"), "25464149K", "DNI");

        //Date of Birth
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.TextView[@text=\"ej. 01/01/2006\"]"), "Birth Date");

        Thread.sleep(1000);
        //Choose Year
        WebElement  choseYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/date_picker_header_year")));
        choseYear.click();

        //Select Year
        By yearLocator = By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='2007']");

        try {
            swipeUntilElementFound(driver, yearLocator, 20); // Massimo 10 swipe
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        WebElement  selectYear = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"2007\"]")));
        selectYear.click();
        //Button OK Calendar
        WebElement  buttonOK = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
        buttonOK.click();

        //MobilePhone
        ElementUtils.sendKeysOrScroll(driver, By.xpath("//android.widget.EditText[@text=\"ej. 000 000 000\"]"), "699505050", "Phone");

//        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
//        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
//        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.TextView[@text=\"Condiciones Generales\"]"), "Condiciones Generales");
        Thread.sleep(3000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        Thread.sleep(2000);
        //implementare cancel e cerrar
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.TextView[@text=\"Descargar Condiciones de uso\"]"), "Descargar Condiciones de uso");
        Thread.sleep(3000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        driver.navigate().back();

        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.Button[@text=\"Cerrar\"]"), "Cerrar");
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"), "RadioButton Condiciones Generales");

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        Thread.sleep(1000);
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.Button[@text=\"Continuar\"]"), "Continuar");
        Thread.sleep(2000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        // SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        // Thread.sleep(1000);
        ElementUtils.clickOrScroll(
            driver,
            AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Información Básica de Protección de Datos Personales\")"),
            "Información Básica de Protección de Datos Personales");
        Thread.sleep(1000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        ElementUtils.clickOrScroll(driver, By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"), "RadioButton Información Básica de Protección de Datos Personales");
        Thread.sleep(1000);
        ElementUtils.clickOrScroll(driver, By.xpath("//android.widget.Button[@text=\"Continuar\"]"), "Continuar");
        Thread.sleep(3000);
        // SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        // Loop to find and click all instances of "No" with checked=false
        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");
        int counter = 0;
        while (counter < 4) {
          try {
            List<WebElement> radioButtons =
                driver.findElements(
                    By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
            for (WebElement radioButton : radioButtons) {
              if (counter < 4) {
                radioButton.click();
                counter++;
                // ScreenshotUtils.takeScreenshot(driver, "Datos Personales");
              } else {
                break;
              }
            }
            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
          } catch (Exception e) {
            System.err.println("Error while clicking radio buttons: " + e.getMessage());
          }
        }
        // SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
//        while (true) {
//          try {
//        WebElement confirmo =
//            driver.findElement(
//                AppiumBy.androidUIAutomator(
//                    "new UiSelector().textContains(\"Confirmo\").fromParent(new UiSelector().className(\"android.view.ViewGroup\"))"));
//              confirmo.click();
//              break;
//          } catch (NoSuchElementException e) {
//            System.out.println(e);
//
//            SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
//          }
//        }
        ElementUtils.clickOrScroll(
            driver,
            AppiumBy.androidUIAutomator(
                "new UiSelector().textContains(\"Confirmo\").fromParent(new UiSelector().className(\"android.view.ViewGroup\"))"),
            "Confirmo");
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
    System.out.println("Sleep for 3 seconds");
        Thread.sleep(3000);
        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");
        Thread.sleep(2000);
    }

    public static void swipeUntilElementFound(WebDriver driver, By locator, int maxSwipes) {
        int swipes = 0;

        while (swipes < maxSwipes) {
            try {
                // Controlla se l'elemento è presente
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    System.out.println("Elemento trovato: " + locator.toString());
                    return; // Esci dal ciclo se l'elemento è trovato
                }
            } catch (NoSuchElementException e) {
                // Ignora l'eccezione se l'elemento non è trovato
            }

            // Esegui lo swipe
            SwipeUtils.swipeVertical(driver, 0.4, 0.6, 0.5, 300);
            swipes++;
        }

        throw new RuntimeException("Elemento non trovato dopo " + maxSwipes + " swipe: " + locator.toString());
    }



    @AfterClass
    public void tearDown() {
        DriverManagerUtils.quitDriver();
    }
}


