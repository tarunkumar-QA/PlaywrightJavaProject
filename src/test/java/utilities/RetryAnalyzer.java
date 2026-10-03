package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetryCount) {
            count++;
            System.out.println(
                "Retrying test: " + result.getName() +
                " | Attempt: " + (count + 1)
            );
            return true;
        }

        return false;
    }
}