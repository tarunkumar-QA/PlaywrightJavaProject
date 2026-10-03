package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class inventoryPage {

    private Page page;

    private Locator products;
    private Locator cartLink;

    public inventoryPage(Page page) {

        this.page = page;

        products = page.locator(".inventory_item");
        cartLink = page.locator(".shopping_cart_link");
    }

    public int getProductCount() {
    	products.first().waitFor();
        return products.count();
    }

    public void addProductToCart(String productName) {

    Locator product = products.filter( new Locator.FilterOptions().setHasText(productName));

    product.getByRole(com.microsoft.playwright.options.AriaRole.BUTTON,new Locator.GetByRoleOptions().setName("Add to cart")).click();
    
    }

    public void clickCart() {
        cartLink.click();
    }

    public String getPageTitle() {
        return page.locator(".title").innerText();
    }
}