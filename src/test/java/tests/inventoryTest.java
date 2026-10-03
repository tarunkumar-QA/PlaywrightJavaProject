package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.baseTest;
import pages.inventoryPage;
import pages.loginPage;
import utilities.RetryAnalyzer;

public class inventoryTest extends baseTest {

	@Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyProductsAndAddToCart() {

        loginPage loginPage = new loginPage(page);

        loginPage.loginn("standard_user","secret_sauce");

        inventoryPage inventoryPage = new inventoryPage(page);

        Assert.assertEquals(inventoryPage.getPageTitle(),"Products");

        Assert.assertTrue(inventoryPage.getProductCount() > 0,"No products displayed");

        inventoryPage.addProductToCart("Sauce Labs Backpack");

        inventoryPage.clickCart();

        Assert.assertTrue(page.url().contains("/cart.html"));
    }
}