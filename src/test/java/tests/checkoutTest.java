package tests;

import Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cartPage;
import pages.checkoutPage;
import pages.inventoryPage;
import pages.loginPage;

public class checkoutTest extends baseTest {

    @Test
    public void completeCheckout() {

        // Login
        loginPage loginPage = new loginPage(page);

        loginPage.loginn("standard_user","secret_sauce");

        // Add product
        inventoryPage inventoryPage = new inventoryPage(page);

        inventoryPage.addProductToCart("Sauce Labs Backpack");

        // Go to cart
        inventoryPage.clickCart();

        // Checkout
        cartPage cartPage = new cartPage(page);

        cartPage.clickCheckout();

        // Enter customer details
        checkoutPage checkoutPage = new checkoutPage(page);

        checkoutPage.enterCustomerDetails("Tarun","Kumar","500001");

        checkoutPage.clickContinue();

        // Finish order
        checkoutPage.clickFinish();

        // Verify order
        Assert.assertEquals(checkoutPage.getConfirmationMessage(),"Thank you for your order!");
    }
}