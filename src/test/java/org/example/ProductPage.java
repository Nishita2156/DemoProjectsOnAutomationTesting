package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class ProductPage {

    WebDriver driver;

    // Locators
    private By inventoryList = By.className("inventory_list");
    private By inventoryItems = By.className("inventory_item");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By addToCartButtons = By.xpath("//button[contains(@id, 'add-to-cart')]");
    private By sortDropdown = By.className("product_sort_container");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public boolean isProductsLoaded() {
        try {
            return driver.findElement(inventoryList).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getProductCount() {
        return driver.findElements(inventoryItems).size();
    }

    public String getFirstProductName() {
        return driver.findElements(productNames).get(0).getText();
    }

    public String getFirstProductPrice() {
        return driver.findElements(productPrices).get(0).getText();
    }

    public void addFirstProductToCart() {
        driver.findElements(addToCartButtons).get(0).click();
    }

    public void addProductToCartByName(String productName) {
        List<WebElement> products = driver.findElements(productNames);
        for (WebElement product : products) {
            if (product.getText().equals(productName)) {
                WebElement parent = product.findElement(By.xpath("ancestor::div[@class='inventory_item']"));
                parent.findElement(By.tagName("button")).click();
                break;
            }
        }
    }

    public void sortBy(String sortValue) {
        WebElement dropdown = driver.findElement(sortDropdown);
        Select select = new Select(dropdown);
        select.selectByValue(sortValue);
    }

    public int getCartItemCount() {
        try {
            return Integer.parseInt(driver.findElement(cartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public void clickCart() {
        driver.findElement(cartIcon).click();
    }

    public void clickProductByName(String productName) {
        List<WebElement> products = driver.findElements(productNames);
        for (WebElement product : products) {
            if (product.getText().equals(productName)) {
                product.click();
                break;
            }
        }
    }
}
