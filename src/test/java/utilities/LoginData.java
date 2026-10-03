package utilities;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"standard_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "negativeLoginData")
    public Object[][] getNegativeLoginData() {

        return new Object[][] {
            {"wrong_user", "secret_sauce"},
            {"standard_user", "wrong_password"},
            {"wrong_user", "wrong_password"},
            {"", "secret_sauce"},
            {"standard_user", ""}
        };
    }
}