package utilities;

import Base.baseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testInstance = result.getInstance();

        if (testInstance instanceof baseTest) {

            baseTest test =
                    (baseTest) testInstance;

            if (test.getPage() != null) {

                ScreenshotUtility.captureScreenshot(
                        test.getPage(),
                        result.getName()
                );

            } else {

                System.out.println(
                        "Screenshot skipped: Page was not created."
                );
            }
        }
    }
}