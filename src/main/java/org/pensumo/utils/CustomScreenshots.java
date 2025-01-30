package org.pensumo.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CustomScreenshots {
  public static void main(String[] args) {
    AndroidDriver driver = DriverManagerUtils.initializeDriver();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print(
          "Ingrese el nombre del archivo de la screenshot (sin extensión o 'exit' para salir): ");
      String inputFileName = scanner.nextLine().trim();

      if (inputFileName.equalsIgnoreCase("exit")) {
        System.out.println("Saliendo del programa...");
        break;
      }

      if (inputFileName.isEmpty()) {
        System.out.println("El nombre no puede estar vacío. Se usará el nombre por defecto.");
        inputFileName = "screenshot_default";
      }

      File screenshotDir = new File("screenshots");
      if (!screenshotDir.exists()) {
        screenshotDir.mkdirs();
      }

      String fileName = inputFileName + ".png";
      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File screenshotFile = new File(screenshotDir, fileName);

      try {
        Files.copy(
            screenshot.toPath(), screenshotFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Captura guardada como: " + screenshotFile.getAbsolutePath());
      } catch (IOException e) {
        throw new RuntimeException("Failed to save screenshot", e);
      }
    }

    scanner.close();
    driver.close();
  }
}
