package utilities;

import com.microsoft.playwright.Page;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtility {

    public static void captureScreenshot(Page page,String testName) {

        try {
            Path screenshotDirectory = Paths.get("screenshots");

            Files.createDirectories(screenshotDirectory);

            String fileName = testName + "_" + System.currentTimeMillis() + ".png";

            Path screenshotPath = screenshotDirectory.resolve(fileName);

            page.screenshot( new Page.ScreenshotOptions().setPath(screenshotPath).setFullPage(true));

            System.out.println("Screenshot saved: " + screenshotPath.toAbsolutePath() );

        } catch (Exception e) {
            System.out.println("Unable to capture screenshot: "+ e.getMessage()
            );
        }
    }
}