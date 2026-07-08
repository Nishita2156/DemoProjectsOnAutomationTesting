package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day_11PageObjectModel {

    WebDriver driver;
    WebDriverWait wait;

    // Page Objects
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://www.saucedemo.com");

        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        System.out.println("✓ Browser launched and Page Objects initialized");
    }

    // ===== EXERCISE 1: Login using POM =====
    @Test
    public void testLoginUsingPOM() {
        System.out.println("\n=== Exercise 1.1: Login using Page Object ===");

        // Using POM - No direct Selenium calls!
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("✓ Login performed using LoginPage object");

        // Wait for products
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Login successful, products page loaded");

        // Verify using POM
        Assert.assertTrue(productPage.isProductsLoaded(), "Products should be loaded");
        System.out.println("✓ Products page verified using ProductPage object");
    }

    // ===== EXERCISE 2: Add Product to Cart using POM =====
    @Test
    public void testAddProductToCartUsingPOM() {
        System.out.println("\n=== Exercise 1.2: Add Product to Cart using POM ===");

        // Login using POM
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Logged in");

        // Get initial product info using POM
        String productName = productPage.getFirstProductName();
        String productPrice = productPage.getFirstProductPrice();
        System.out.println("✓ First product: " + productName + " - " + productPrice);

        // Add to cart using POM
        productPage.addFirstProductToCart();
        System.out.println("✓ Added first product to cart using ProductPage");

        // Verify cart count using POM
        Assert.assertEquals(productPage.getCartItemCount(), 1, "Cart should have 1 item");
        System.out.println("✓ Cart count verified: 1 item");
    }

    // ===== EXERCISE 3: Sort Products using POM =====
    @Test
    public void testSortProductsUsingPOM() {
        System.out.println("\n=== Exercise 1.3: Sort Products using POM ===");

        // Login
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Logged in");

        // Sort using POM
        productPage.sortBy("lh"); // low to high
        System.out.println("✓ Sorted products by price (low to high)");

        // Get first product after sorting
        String firstProduct = productPage.getFirstProductName();
        System.out.println("✓ First product after sort: " + firstProduct);
    }

    // ===== EXERCISE 4: Add Multiple Products using POM =====
    @Test
    public void testAddMultipleProductsUsingPOM() {
        System.out.println("\n=== Exercise 1.4: Add Multiple Products using POM ===");

        // Login
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Logged in");

        // Add multiple products using POM
        productPage.addProductToCartByName("Sauce Labs Backpack");
        System.out.println("✓ Added 'Sauce Labs Backpack' to cart");

        productPage.addProductToCartByName("Sauce Labs Bike Light");
        System.out.println("✓ Added 'Sauce Labs Bike Light' to cart");

        productPage.addProductToCartByName("Sauce Labs Bolt T-Shirt");
        System.out.println("✓ Added 'Sauce Labs Bolt T-Shirt' to cart");

        // Verify cart count
        int cartCount = productPage.getCartItemCount();
        Assert.assertEquals(cartCount, 3, "Cart should have 3 items");
        System.out.println("✓ Cart has 3 items");
    }

    // ===== EXERCISE 5: Navigate to Cart using POM =====
    @Test
    public void testNavigateToCartUsingPOM() {
        System.out.println("\n=== Exercise 1.5: Navigate to Cart using POM ===");

        // Login
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Logged in");

        // Add product
        productPage.addFirstProductToCart();
        System.out.println("✓ Added product to cart");

        // Navigate to cart using POM
        productPage.clickCart();
        System.out.println("✓ Clicked cart using ProductPage");

        // Wait for cart page
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.id("checkout")
        ));
        System.out.println("✓ Cart page loaded");

        // Verify cart items using POM
        int cartItems = cartPage.getCartItemCount();
        Assert.assertTrue(cartItems > 0, "Cart should have items");
        System.out.println("✓ Cart items verified: " + cartItems);
    }

    // ===== EXERCISE 6: Remove Item from Cart using POM =====
    @Test
    public void testRemoveItemFromCartUsingPOM() {
        System.out.println("\n=== Exercise 1.6: Remove Item from Cart using POM ===");

        // Login
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Logged in");

        // Add 2 products
        productPage.addProductToCartByName("Sauce Labs Backpack");
        productPage.addProductToCartByName("Sauce Labs Bike Light");
        System.out.println("✓ Added 2 products to cart");

        // Go to cart
        productPage.clickCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.id("checkout")
        ));
        System.out.println("✓ Navigated to cart");

        // Get initial count
        int initialCount = cartPage.getCartItemCount();
        System.out.println("✓ Initial cart items: " + initialCount);

        // Remove an item
        cartPage.removeFirstItem();
        System.out.println("✓ Removed first item using CartPage");

        // Verify count decreased
        int finalCount = cartPage.getCartItemCount();
        Assert.assertEquals(finalCount, initialCount - 1, "Cart count should decrease");
        System.out.println("✓ Final cart items: " + finalCount);
    }

    // ===== EXERCISE 7: Complete Checkout Flow using POM =====
    @Test
    public void testCompleteCheckoutFlowUsingPOM() {
        System.out.println("\n=== Exercise 1.7: Complete Checkout Flow using POM ===");

        System.out.println("\n--- Step 1: Login ---");
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Logged in using LoginPage");

        System.out.println("\n--- Step 2: Sort Products ---");
        productPage.sortBy("lh");
        System.out.println("✓ Sorted products using ProductPage");

        System.out.println("\n--- Step 3: Add Products to Cart ---");
        productPage.addProductToCartByName("Sauce Labs Onesie");
        productPage.addProductToCartByName("Sauce Labs Backpack");
        System.out.println("✓ Added 2 products using ProductPage");

        System.out.println("\n--- Step 4: Verify Cart ---");
        int cartCount = productPage.getCartItemCount();
        Assert.assertEquals(cartCount, 2, "Cart should have 2 items");
        System.out.println("✓ Cart has 2 items");

        System.out.println("\n--- Step 5: Go to Cart ---");
        productPage.clickCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.id("checkout")
        ));
        System.out.println("✓ Navigated to cart using ProductPage");

        System.out.println("\n--- Step 6: Verify Cart Items ---");
        int finalCartItems = cartPage.getCartItemCount();
        Assert.assertEquals(finalCartItems, 2, "Cart should have 2 items");
        System.out.println("✓ Cart items verified: " + finalCartItems);

        System.out.println("\n--- Step 7: Proceed to Checkout ---");
        cartPage.proceedToCheckout();
        System.out.println("✓ Clicked checkout using CartPage");

        System.out.println("\n✓ Complete checkout flow executed successfully using POM!");
    }

    // ===== EXERCISE 8: POM Benefits Demonstration =====
    @Test
    public void testPOMBenefits() {
        System.out.println("\n=== Exercise 1.8: POM Benefits ===");

        System.out.println("\n✓ POM Benefits:");
        System.out.println("  1. Maintainability - Change locator in ONE place");
        System.out.println("  2. Reusability - Use same page object in multiple tests");
        System.out.println("  3. Readability - Tests read like user actions");
        System.out.println("  4. Separation of Concerns - Page logic ≠ Test logic");
        System.out.println("  5. Reduced Duplication - No repeating locator searches");
        System.out.println("  6. Easy Debugging - Centralized page methods");
        System.out.println("  7. Scalability - Add tests without adding complexity");
        System.out.println("  8. Team Collaboration - Clear structure for teams");

        System.out.println("\n✓ Without POM:");
        System.out.println("  ❌ Tests are tightly coupled to locators");
        System.out.println("  ❌ Hard to maintain when UI changes");
        System.out.println("  ❌ Tests are hard to read");
        System.out.println("  ❌ Lots of code duplication");

        System.out.println("\n✓ With POM:");
        System.out.println("  ✅ Tests focus only on business logic");
        System.out.println("  ✅ Easy to update locators");
        System.out.println("  ✅ Tests are clean and readable");
        System.out.println("  ✅ Maximum code reuse");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("\n✓ Browser closed!");
        }
    }
}