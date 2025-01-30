/*
package org.pensumo.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotToWordUtils {

    public static void createWordDocumentWithScreenshots(String screenshotsDirPath, String outputFilePath) {
        File screenshotsDir = new File(screenshotsDirPath);

        if (!screenshotsDir.exists() || !screenshotsDir.isDirectory()) {
            throw new IllegalArgumentException("The specified directory does not exist or is not a directory.");
        }

        File[] screenshotFiles = screenshotsDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

        if (screenshotFiles == null || screenshotFiles.length == 0) {
            throw new IllegalStateException("No screenshots were found in the specified directory.");
        }

        try (XWPFDocument document = new XWPFDocument()) {
            for (File screenshotFile : screenshotFiles) {
                // Create table
                XWPFTable table = document.createTable(3, 1);

                // Remove table borders
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
                        // Set invisible borders
                        cell.getCTTc().addNewTcPr().addNewNoWrap();
                    }
                }

                // Title
                XWPFTableCell titleCell = table.getRow(0).getCell(0);
                XWPFParagraph titleParagraph = titleCell.addParagraph();
                titleParagraph.setAlignment(ParagraphAlignment.CENTER); // Align to center
                titleParagraph.createRun().setText(screenshotFile.getName());

                // Image
                XWPFTableCell imageCell = table.getRow(1).getCell(0);
                XWPFParagraph imageParagraph = imageCell.addParagraph();
                try {
                    byte[] imageBytes = Files.readAllBytes(screenshotFile.toPath());
                    XWPFRun imageRun = imageParagraph.createRun(); // Add a paragraph for the image
                    imageRun.addPicture(
                            new FileInputStream(screenshotFile), // Read the image file directly
                            XWPFDocument.PICTURE_TYPE_PNG,       // Image type
                            screenshotFile.getName(),            // Image name
                            Units.toEMU(220),             // Image width
                            Units.toEMU(400)              // Image height
                    );
                    imageParagraph.setAlignment(ParagraphAlignment.CENTER); // Center the image
                } catch (InvalidFormatException | IOException e) {
                    System.err.println("Error while adding the screenshot: " + screenshotFile.getName());
                    e.printStackTrace();
                }

                // Observations
                XWPFTableCell observationsCell = table.getRow(2).getCell(0);
                XWPFParagraph observationsParagraph = observationsCell.addParagraph();
                observationsParagraph.setAlignment(ParagraphAlignment.LEFT); // Align to left
                // Add a placeholder visible text for the observations
                observationsParagraph.createRun().setText("Observations:");

                // Add a page break
                XWPFParagraph pageBreak = document.createParagraph();
                pageBreak.setPageBreak(true);
            }

            // Write the document to a file
            try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                document.write(outputStream);
                System.out.println("Word document created successfully: " + outputFilePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while creating the Word file.", e);
        }
    }
}
*/
package org.pensumo.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class ScreenshotToWordUtils {

    public static void createWordDocumentWithScreenshots(String screenshotsDirPath, String outputFilePath) {
        File screenshotsDir = new File(screenshotsDirPath);

        if (!screenshotsDir.exists() || !screenshotsDir.isDirectory()) {
            throw new IllegalArgumentException("The specified directory does not exist or is not a directory.");
        }

        File[] screenshotFiles = screenshotsDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));

        if (screenshotFiles == null || screenshotFiles.length == 0) {
            throw new IllegalStateException("No screenshots were found in the specified directory.");
        }

        // Ordina i file in base al numero presente nel nome
        Arrays.sort(screenshotFiles, Comparator.comparingInt(ScreenshotToWordUtils::extractNumber));

        try (XWPFDocument document = new XWPFDocument()) {
            for (File screenshotFile : screenshotFiles) {
                // Create table
                XWPFTable table = document.createTable(3, 1);

                // Remove table borders
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
                        // Set invisible borders
                        cell.getCTTc().addNewTcPr().addNewNoWrap();
                    }
                }

                // Title
                XWPFTableCell titleCell = table.getRow(0).getCell(0);
                XWPFParagraph titleParagraph = titleCell.addParagraph();
                titleParagraph.setAlignment(ParagraphAlignment.CENTER); // Align to center
                titleParagraph.createRun().setText(screenshotFile.getName().replaceFirst("^\\d+_", "").replaceFirst("\\.png$", ""));

                // Image
                XWPFTableCell imageCell = table.getRow(1).getCell(0);
                XWPFParagraph imageParagraph = imageCell.addParagraph();
                try {
                    byte[] imageBytes = Files.readAllBytes(screenshotFile.toPath());
                    XWPFRun imageRun = imageParagraph.createRun(); // Add a paragraph for the image
                    imageRun.addPicture(
                            new FileInputStream(screenshotFile), // Read the image file directly
                            XWPFDocument.PICTURE_TYPE_PNG,       // Image type
                            screenshotFile.getName(),            // Image name
                            Units.toEMU(220),             // Image width
                            Units.toEMU(450)              // Image height
                    );
                    imageParagraph.setAlignment(ParagraphAlignment.CENTER); // Center the image
                } catch (IOException e) {
                    System.err.println("Error while adding the screenshot: " + screenshotFile.getName());
                    e.printStackTrace();
                } catch (InvalidFormatException e) {
                    throw new RuntimeException(e);
                }

                // Observations
                XWPFTableCell observationsCell = table.getRow(2).getCell(0);
                XWPFParagraph observationsParagraph = observationsCell.addParagraph();
                observationsParagraph.setAlignment(ParagraphAlignment.LEFT); // Align to left
                // Add a placeholder visible text for the observations
                observationsParagraph.createRun().setText("Observations:");

                // Add a page break
                XWPFParagraph pageBreak = document.createParagraph();
                pageBreak.setPageBreak(true);
            }

            // Write the document to a file
            try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                document.write(outputStream);
                System.out.println("Word document created successfully: " + outputFilePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while creating the Word file.", e);
        }
    }

    // Metodo per estrarre il numero dal nome del file
    private static int extractNumber(File file) {
        String name = file.getName();
        try {
            String numberPart = name.split("_")[0]; // Prendi la parte numerica prima di "_"
            return Integer.parseInt(numberPart);
        } catch (NumberFormatException e) {
            System.err.println("Invalid file name format: " + name);
            return Integer.MAX_VALUE; // Metti in fondo i file che non seguono il formato
        }
    }
}
