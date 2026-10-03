package tests;

import Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.cartPage;
import pages.inventoryPage;
import pages.loginPage;

public class cartTest extends baseTest {

    @Test
    public void verifyCartItem() {

    	loginPage loginPage = new loginPage(page);

        loginPage.loginn("standard_user","secret_sauce");

        inventoryPage inventoryPage = new inventoryPage(page);
        
        inventoryPage.addProductToCart("Sauce Labs Backpack");

        inventoryPage.clickCart();
        cartPage cartPage = new cartPage(page);

        Assert.assertEquals(cartPage.getCartItemCount(),1,"Cart item count is incorrect");

        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Backpack");
    }
}
