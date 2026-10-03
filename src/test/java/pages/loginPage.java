package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class loginPage {

	private Page page;
	private Locator username;
	private Locator password;
	private Locator loginBtn;
	
	public loginPage(Page page) {
		this.page = page;
		
		username = page.locator("#user-name");
		password = page.locator("//input[@type='password']");
		loginBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
	}


	public void enterUsername(String value) {
		username.fill(value);
	}
	
	public void enterPassword(String value) {
		password.fill(value);
	}
	
	public void clickLogin(){
		loginBtn.click();
	}
	
	public void loginn(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
}
