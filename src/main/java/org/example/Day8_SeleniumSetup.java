package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day8_SeleniumSetup {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Initialize Chrome WebDriver
        driver = new ChromeDriver();

        // Set implicit wait (10 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Initialize explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("✓ Browser launched!");
    }

    @Test
    public void testSauceDemoLogin() {
        System.out.println("\n=== Test 1: SauceDemo Login ===");

        // Step 1: Navigate to SauceDemo
        driver.navigate().to("https://www.saucedemo.com");
        System.out.println("✓ Navigated to SauceDemo");

        // Step 2: Verify page title
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Swag Labs"), "Page title should contain 'Swag Labs'");
        System.out.println("✓ Page title verified: " + pageTitle);

        // Step 3: Find username field and enter username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        System.out.println("✓ Entered username: standard_user");

        // Step 4: Find password field and enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        System.out.println("✓ Entered password");

        // Step 5: Find and click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        System.out.println("✓ Clicked login button");

        // Step 6: Wait for products page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Products page loaded");

        // Step 7: Verify we're on the products page
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        Assert.assertTrue(inventoryList.isDisplayed(), "Inventory list should be displayed");
        System.out.println("✓ Login successful! Inventory page displayed");
    }

    @Test
    public void testSauceDemoProductDisplay() {
        System.out.println("\n=== Test 2: Verify Product Display ===");

        driver.navigate().to("https://www.saucedemo.com");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Wait for products to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));
        System.out.println("✓ Products loaded");

        // Count number of products
        int productCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertTrue(productCount > 0, "Products should be displayed");
        System.out.println("✓ Found " + productCount + " products");

        // Verify first product has name and price
        WebElement firstProduct = driver.findElement(By.className("inventory_item"));
        WebElement productName = firstProduct.findElement(By.className("inventory_item_name"));
        WebElement productPrice = firstProduct.findElement(By.className("inventory_item_price"));

        Assert.assertTrue(productName.isDisplayed(), "Product name should be displayed");
        Assert.assertTrue(productPrice.isDisplayed(), "Product price should be displayed");
        System.out.println("✓ Product name: " + productName.getText());
        System.out.println("✓ Product price: " + productPrice.getText());
    }

    @Test
    public void testAddProductToCart() {
        System.out.println("\n=== Test 3: Add Product to Cart ===");

        driver.navigate().to("https://www.saucedemo.com");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Wait for products
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));
        System.out.println("✓ Products loaded");

        // Find and click "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        System.out.println("✓ Clicked 'Add to Cart'");

        // Verify button text changed to "Remove"
        wait.until(ExpectedConditions.textToBePresentInElement(addToCartButton, "Remove"));
        Assert.assertTrue(addToCartButton.getText().contains("Remove"), "Button should now say 'Remove'");
        System.out.println("✓ Button text changed to: " + addToCartButton.getText());

        // Verify cart badge shows 1 item
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "1", "Cart should show 1 item");
        System.out.println("✓ Cart badge shows: " + cartBadge.getText() + " item");
    }

    @Test
    public void testSortProducts() throws InterruptedException {
        System.out.println("\n=== Test 4: Sort Products ===");

        driver.navigate().to("https://www.saucedemo.com");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Wait for products
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));
        System.out.println("✓ Products loaded");

        // Find and click sort dropdown
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        sortDropdown.click();
        System.out.println("✓ Clicked sort dropdown");

        // Select "Price (high to low)"
        WebElement sortOption = driver.findElement(By.cssSelector("option[value='hilo']"));
        sortOption.click();
        System.out.println("✓ Selected 'Price (high to low)'");

        // Wait for products to re-sort
        Thread.sleep(1000);

        // Get first product price
        WebElement firstPrice = driver.findElement(By.className("inventory_item_price"));
        String priceText = firstPrice.getText().replace("$", "");
        double firstPrice_value = Double.parseDouble(priceText);
        System.out.println("✓ First product price: $" + firstPrice_value);

        // Get last product price (highest price first when sorted)
        java.util.List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        String lastPriceText = prices.get(prices.size() - 1).getText().replace("$", "");
        double lastPrice_value = Double.parseDouble(lastPriceText);
        System.out.println("✓ Last product price: $" + lastPrice_value);

        // Verify prices are sorted correctly (high to low)
        Assert.assertTrue(firstPrice_value >= lastPrice_value, "Prices should be sorted high to low");
        System.out.println("✓ Products sorted correctly: high to low");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("\n✓ Browser closed!");
        }
    }
}