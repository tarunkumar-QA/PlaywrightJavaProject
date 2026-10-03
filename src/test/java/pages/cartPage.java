package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class cartPage {

    private Page page;
    private Locator cartItems;
    private Locator checkoutButton;

    public cartPage(Page page) {
        this.page = page;

        cartItems = page.locator(".cart_item");
        checkoutButton = page.locator("#checkout");
    }

    public int getCartItemCount() {
        cartItems.first().waitFor();
        return cartItems.count();
    }

    public String getProductName() {
        return cartItems.first() .locator(".inventory_item_name").innerText();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
    
}