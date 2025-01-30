package org.pensumo.reports;

import org.pensumo.utils.ScreenshotToWordUtils;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenshotToWordTest {

    @Test
    public void testCreateWordDocumentWithScreenshots() {


        String screenshotsDirPath = "screenshots";
        String reportsDirPath = "screenshots/Reports";
        // File di output
        String outputFilePath = reportsDirPath + "/ReportScreenshots.docx";

        try {
            File reportsDir = new File(reportsDirPath);
            if (!reportsDir.exists()) {
                boolean isCreated = reportsDir.mkdirs();
                if (!isCreated) {
                    System.err.println("Error in creation Dir  Reports.");
                    return;
                }
            }

            ScreenshotToWordUtils.createWordDocumentWithScreenshots(screenshotsDirPath, outputFilePath);
            System.out.println("Document Word successful created in: " + outputFilePath);
        } catch (Exception e) {
            System.err.println("Error during creation document  Word: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
