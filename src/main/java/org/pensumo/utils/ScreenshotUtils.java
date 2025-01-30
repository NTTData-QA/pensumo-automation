package org.pensumo.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {
    private static int screenshotCounter = 3;

    public static void takeScreenshot(WebDriver driver, String className) {
        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        // Usa el contador como número de captura
        String fileName = screenshotCounter + "_" + className + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile = new File(screenshotDir, fileName);
        try {
            Files.copy(screenshot.toPath(), screenshotFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            screenshotCounter++; // Incrementa el contador después de guardar
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot", e);
        }
    }
}
