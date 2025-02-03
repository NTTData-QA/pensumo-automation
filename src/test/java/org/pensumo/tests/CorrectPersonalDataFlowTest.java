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

        //Filling fields for wrong test
        //Name
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"ej. Pilar\"]")));
        nameField.sendKeys("FULANITO");

        //surname
        WebElement surnameField = driver.findElement(By.xpath("//android.widget.EditText[@text=\"ej. Perez García\"]"));
        surnameField.sendKeys("MENGANITO");

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);

        //Dni
        WebElement dniField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"ej. 56743917R\"]")));
        dniField.sendKeys("25464149K");

        //Date of Birth
        WebElement birthField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"ej. 01/01/2006\"]")));
        birthField.click();

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
        WebElement phoneField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"ej. 000 000 000\"]")));
        phoneField.sendKeys("699505050");
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");
        WebElement generalConditions = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Condiciones Generales\"]"));
        generalConditions.click();
        Thread.sleep(3000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        //implementare cancel e cerrar
        WebElement downloadConditions = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Descargar Condiciones de uso\"]"));
        downloadConditions.click();
        Thread.sleep(3000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        driver.navigate().back();
        WebElement cerrarDCWindow = driver.findElement(By.xpath("//android.widget.Button[@text=\"Cerrar\"]"));
        cerrarDCWindow.click();
        WebElement radioButtonConditions = driver.findElement(By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
        radioButtonConditions.click();

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        Thread.sleep(1000);
        WebElement continuarButton = driver.findElement(By.xpath("//android.widget.Button[@text=\"Continuar\"]"));
        continuarButton.click();
        Thread.sleep(1000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement basicInfoButton = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Información Básica de Protección de Datos Personales\"]"));
        basicInfoButton.click();
        Thread.sleep(1000);

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        WebElement basicInfoRadioButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"));
        basicInfoRadioButton.click();
        Thread.sleep(1000);
        WebElement basicInfoContinuarButton = driver.findElement(By.xpath("//android.widget.Button[@text=\"Continuar\"]"));
        basicInfoContinuarButton.click();
        Thread.sleep(3000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsNo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']")));
        radioButtonCommercialComunicationsNo1.click();

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        /*SwipeUtils.swipeVertical(driver, 0.8, 0.3, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsNo2 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsNo2.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.3, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsSi3 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsSi3.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.3, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsSi4 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsSi4.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.3, 0.5, 1000);
        WebElement radioButtonAcceptCommercialComunications = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup"));
        radioButtonAcceptCommercialComunications.click();

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");

        WebElement radioButtonCommercialComunicationsNo5 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsNo5.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        radioButtonAcceptCommercialComunications.click();

        ScreenshotUtils.takeScreenshot(driver, "Datos Personales");*/
        Thread.sleep(20000);
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


