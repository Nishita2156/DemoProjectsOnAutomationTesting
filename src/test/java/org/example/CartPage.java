package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {

    WebDriver driver;

    // Locators
    private By cartItems = By.className("cart_item");
    private By cartItemNames = By.className("inventory_item_name");
    private By cartItemPrices = By.className("inventory_item_price");
    private By removeButtons = By.xpath("//button[contains(@id, 'remove')]");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");
    private By cartBadge = By.className("shopping_cart_badge");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(cartItems);
    }

    public String getFirstItemName() {
        return driver.findElements(cartItemNames).get(0).getText();
    }

    public String getFirstItemPrice() {
        return driver.findElements(cartItemPrices).get(0).getText();
    }

    public void removeFirstItem() {
        driver.findElements(removeButtons).get(0).click();
    }

    public void removeItemByName(String itemName) {
        List<WebElement> items = driver.findElements(cartItemNames);
        for (WebElement item : items) {
            if (item.getText().equals(itemName)) {
                WebElement parent = item.findElement(By.xpath("ancestor::div[@class='cart_item']"));
                parent.findElement(By.xpath(".//button[contains(@id, 'remove')]")).click();
                break;
            }
        }
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void continueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    public boolean isCartEmpty() {
        try {
            driver.findElement(cartBadge).getText();
            return false; // Badge exists, cart has items
        } catch (Exception e) {
            return true; // No badge, cart is empty
        }
    }
}
