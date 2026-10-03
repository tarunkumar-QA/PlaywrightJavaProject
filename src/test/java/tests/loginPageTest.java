package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;
import pages.loginPage;
import utilities.LoginData;


public class loginPageTest extends baseTest {
	
	@Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
	public void validLoginTest(String username, String password) {

	    loginPage loginPage = new loginPage(page);

	    loginPage.loginn(username, password);

	    Assert.assertEquals(page.url(),"https://www.saucedemo.com/inventory.html");
	}
	}

