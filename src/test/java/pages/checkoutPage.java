package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class checkoutPage {

    private Page page;

    private Locator firstName;
    private Locator lastName;
    private Locator postalCode;
    private Locator continueButton;
    private Locator finishButton;
    private Locator confirmationMessage;

    public checkoutPage(Page page) {
        this.page = page;

        firstName = page.locator("#first-name");
        lastName = page.locator("#last-name");
        postalCode = page.locator("#postal-code");
        continueButton = page.locator("#continue");
        finishButton = page.locator("#finish");
        confirmationMessage = page.locator(".complete-header");
    }

    public void enterCustomerDetails(
            String firstNameValue,
            String lastNameValue,
            String postalCodeValue) {

        firstName.fill(firstNameValue);
        lastName.fill(lastNameValue);
        postalCode.fill(postalCodeValue);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public String getConfirmationMessage() {
        confirmationMessage.waitFor();
        return confirmationMessage.innerText();
    }
}