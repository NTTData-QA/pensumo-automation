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
        LoginUtils.performLogin(driver,"iary.corsiero@libero.it", "Pensumo21!");
        LoginUtils.handleIntroPage(driver, wait);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        /*
        WebElement jumpButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Saltar']"));
        jumpButton.click();

        Thread.sleep(10000);

        WebElement startSessionBotton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Iniciar sesión\"]")));
        startSessionBotton.click();

        // WebElement userField = driver.findElement(By.id("uname"));
        WebElement userField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"uname\"]")));
        userField.sendKeys("iary.corsiero@libero.it");

        //WebElement pwdField = driver.findElement(By.id("upassword"));
        WebElement pwdField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"upassword\"]")));
        pwdField.sendKeys("Pensumo21!");

        WebElement loginBotton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"login_btn\"]")));
        loginBotton.click();
        Thread.sleep(3000);

        // After Login
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement nextBotton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageButton")));
        nextBotton.click();
        Thread.sleep(3000);

         */
        WebElement headParsonalData = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Datos personales y creación de cuenta\"]")));

        //Filling fields for wrong test
        //Name
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text=\"ej. Pilar\"]")));
        nameField.sendKeys("FULANITO");

        //surname
        WebElement surnameField = driver.findElement(By.xpath("//android.widget.EditText[@text=\"ej. Perez García\"]"));
        surnameField.sendKeys("MENGANITO");

        ScreenshotUtils.takeScreenshot(driver, 21, "Datos Personales");
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

/*
        //Date of Birth --> Este no funciona en cuanto entra la fecha correcta pero la detecta como equivocada , hay que pasar por el calendario
        By dateFieldLocator = By.xpath("//android.widget.EditText[@text='14/01/2026']");
        WebElement dateField = driver.findElement(dateFieldLocator);
        //dateField.clear();  // Pulisce il campo
        dateField.sendKeys("29/09/1975");
        WebElement outsideElement = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout"));
        outsideElement.click();
*/
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        ScreenshotUtils.takeScreenshot(driver, 22, "Datos Personales");
        WebElement generalConditions = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Condiciones Generales\"]"));
        generalConditions.click();
        Thread.sleep(3000);

        ScreenshotUtils.takeScreenshot(driver, 23, "Datos Personales");

        //implementare cancel e cerrar
        WebElement downloadConditions = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Descargar Condiciones de uso\"]"));
        downloadConditions.click();
        Thread.sleep(3000);

        ScreenshotUtils.takeScreenshot(driver, 24, "Datos Personales");

        driver.navigate().back();
        WebElement cerrarDCWindow = driver.findElement(By.xpath("//android.widget.Button[@text=\"Cerrar\"]"));
        cerrarDCWindow.click();
        WebElement radioButtonConditions = driver.findElement(By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
        radioButtonConditions.click();

        ScreenshotUtils.takeScreenshot(driver, 25, "Datos Personales");

        Thread.sleep(1000);
        WebElement continuarButton = driver.findElement(By.xpath("//android.widget.Button[@text=\"Continuar\"]"));
        continuarButton.click();
        Thread.sleep(1000);

        ScreenshotUtils.takeScreenshot(driver, 26, "Datos Personales");

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement basicInfoButton = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Información Básica de Protección de Datos Personales\"]"));
        basicInfoButton.click();
        Thread.sleep(1000);

        ScreenshotUtils.takeScreenshot(driver, 27, "Datos Personales");

        WebElement basicInfoRadioButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"));
        basicInfoRadioButton.click();
        Thread.sleep(1000);
        WebElement basicInfoContinuarButton = driver.findElement(By.xpath("//android.widget.Button[@text=\"Continuar\"]"));
        basicInfoContinuarButton.click();
        Thread.sleep(3000);
        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsNo1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']")));
        radioButtonCommercialComunicationsNo1.click();

        ScreenshotUtils.takeScreenshot(driver, 28, "Datos Personales");

        SwipeUtils.swipeVertical(driver, 0.6, 0.4, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsNo2 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsNo2.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsSi3 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsSi3.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement radioButtonCommercialComunicationsSi4 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsSi4.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        WebElement radioButtonAcceptCommercialComunications = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup"));
        radioButtonAcceptCommercialComunications.click();

        ScreenshotUtils.takeScreenshot(driver, 29, "Datos Personales");

        WebElement radioButtonCommercialComunicationsNo5 = driver.findElement(By.xpath("//android.widget.RadioButton[@text='No' and @checked='false']"));
        radioButtonCommercialComunicationsNo5.click();

        SwipeUtils.swipeVertical(driver, 0.8, 0.2, 0.5, 1000);
        radioButtonAcceptCommercialComunications.click();

        ScreenshotUtils.takeScreenshot(driver, 30, "Datos Personales");

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


