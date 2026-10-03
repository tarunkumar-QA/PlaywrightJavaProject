package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utilities.configReader;

public class baseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    private static Page currentPage;

    @BeforeMethod
    public void setUp() {

        playwright = Playwright.create();

        String browserName =
                configReader.getProperty("browser");

        boolean headless =
                Boolean.parseBoolean(
                        configReader.getProperty("headless")
                );

        if (browserName.equalsIgnoreCase("chromium")) {

            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(headless)
            );

        } else if (browserName.equalsIgnoreCase("firefox")) {

            browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(headless)
            );

        } else if (browserName.equalsIgnoreCase("webkit")) {

            browser = playwright.webkit().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(headless)
            );

        } else {

            throw new RuntimeException(
                    "Invalid browser: " + browserName
            );
        }

        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoDir(
                                java.nio.file.Paths.get("videos")
                        )
        );

        context.tracing().start(
                new com.microsoft.playwright.Tracing.StartOptions()
                        .setScreenshots(true)
                        .setSnapshots(true)
                        .setSources(true)
        );

        // Create Page only once
        page = context.newPage();

        // Store the current page for listener
        setCurrentPage(page);

        page.navigate(
                configReader.getProperty("baseURL")
        );
    }

    @AfterMethod
    public void tearDown() {

        if (context != null) {

            context.tracing().stop(
                    new com.microsoft.playwright.Tracing.StopOptions()
                            .setPath(
                                    java.nio.file.Paths.get(
                                            "traces",
                                            "trace_" +
                                            System.currentTimeMillis() +
                                            ".zip"
                                    )
                            )
            );

            context.close();
        }

        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }

        setCurrentPage(null);
    }

    public Page getPage() {
        return page;
    }

	public static Page getCurrentPage() {
		return currentPage;
	}

	public static void setCurrentPage(Page currentPage) {
		baseTest.currentPage = currentPage;
	}
}