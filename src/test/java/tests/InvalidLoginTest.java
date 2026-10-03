package tests;

import Base.baseTest;
import com.microsoft.playwright.Locator;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import utilities.LoginData;

public class InvalidLoginTest extends baseTest {

    @Test(
        dataProvider = "negativeLoginData",
        dataProviderClass = LoginData.class
    )
    public void invalidLoginTest(
            String username,
            String password) {

        System.out.println(
            "Testing username: [" + username +
            "] password: [" + password + "]"
        );

        loginPage loginPage = new loginPage(page);

        loginPage.loginn(username, password);

        Locator errorMessage =
                page.locator("[data-test='error']");

        errorMessage.waitFor();

        Assert.assertTrue(
                errorMessage.isVisible(),
                "Error message is not displayed"
        );
    }
}