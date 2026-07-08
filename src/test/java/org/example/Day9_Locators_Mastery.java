package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Day9_Locators_Mastery {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com");
        System.out.println("✓ Browser launched and navigated to SauceDemo");
    }

    // ===== EXERCISE 1: Find by ID =====
    @Test
    public void testLocatorById() {
        System.out.println("\n=== Exercise 1.1: Find Element by ID ===");

        // By ID: Most specific and reliable
        WebElement usernameField = driver.findElement(By.id("user-name"));
        Assert.assertTrue(usernameField.isDisplayed(), "Username field should be displayed");
        System.out.println("✓ Found username field by ID: user-name");

        WebElement passwordField = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordField.isDisplayed(), "Password field should be displayed");
        System.out.println("✓ Found password field by ID: password");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button should be displayed");
        System.out.println("✓ Found login button by ID: login-button");
    }

    // ===== EXERCISE 2: Find by Class Name =====
    @Test
    public void testLocatorByClassName() {
        System.out.println("\n=== Exercise 1.2: Find Element by Class Name ===");

        // Login first
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in successfully");

        // Find all products by class name
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        Assert.assertTrue(products.size() > 0, "Should find products");
        System.out.println("✓ Found " + products.size() + " products by class: inventory_item");

        // Find product names by class
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        Assert.assertTrue(productNames.size() > 0, "Should find product names");
        System.out.println("✓ Found " + productNames.size() + " product names by class: inventory_item_name");
        System.out.println("  First product: " + productNames.get(0).getText());
    }

    // ===== EXERCISE 3: Find by CSS Selector =====
    @Test
    public void testLocatorByCssSelector() {
        System.out.println("\n=== Exercise 1.3: Find Elements by CSS Selector ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in successfully");

        // CSS Selector 1: Element type
        List<WebElement> buttons = driver.findElements(By.cssSelector("button"));
        Assert.assertTrue(buttons.size() > 0, "Should find buttons");
        System.out.println("✓ Found " + buttons.size() + " buttons using: button");

        // CSS Selector 2: Class selector
        List<WebElement> prices = driver.findElements(By.cssSelector(".inventory_item_price"));
        Assert.assertTrue(prices.size() > 0, "Should find prices");
        System.out.println("✓ Found " + prices.size() + " prices using: .inventory_item_price");
        System.out.println("  First price: " + prices.get(0).getText());

        // CSS Selector 3: Attribute selector
        WebElement cartButton = driver.findElement(By.cssSelector("[id*='add-to-cart']"));
        Assert.assertTrue(cartButton.isDisplayed(), "Should find add to cart button");
        System.out.println("✓ Found add-to-cart button using: [id*='add-to-cart']");

        // CSS Selector 4: Child combinator
        List<WebElement> itemContainers = driver.findElements(By.cssSelector("div.inventory_item"));
        Assert.assertTrue(itemContainers.size() > 0, "Should find item containers");
        System.out.println("✓ Found " + itemContainers.size() + " item containers using: div.inventory_item");
    }

    // ===== EXERCISE 4: Find by XPath (Absolute) =====
    @Test
    public void testLocatorByXPathAbsolute() {
        System.out.println("\n=== Exercise 1.4: Find Elements by XPath (Absolute) ===");

        // Absolute XPath: Full path from root
        WebElement usernameField = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/form/div[1]/input"));
        Assert.assertTrue(usernameField.isDisplayed(), "Username field should be displayed");
        System.out.println("✓ Found username field by ABSOLUTE XPath");

        // This works but is brittle - not recommended!
        System.out.println("⚠ Absolute XPath works but breaks easily when DOM changes!");
        System.out.println("✓ Lesson learned: Avoid absolute XPath in production");
    }

    // ===== EXERCISE 5: Find by XPath (Relative) =====
    @Test
    public void testLocatorByXPathRelative() {
        System.out.println("\n=== Exercise 1.5: Find Elements by XPath (Relative) ===");

        // Relative XPath 1: By element name
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='user-name']"));
        Assert.assertTrue(usernameField.isDisplayed(), "Username field should be displayed");
        System.out.println("✓ Found username field by XPath: //input[@id='user-name']");

        // Relative XPath 2: By attribute
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        Assert.assertTrue(passwordField.isDisplayed(), "Password field should be displayed");
        System.out.println("✓ Found password field by XPath: //input[@type='password']");

        // Relative XPath 3: By multiple attributes
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button'][@type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button should be displayed");
        System.out.println("✓ Found login button by XPath: //input[@id='login-button'][@type='submit']");
    }

    // ===== EXERCISE 6: Find by Text Content =====
    @Test
    public void testLocatorByText() {
        System.out.println("\n=== Exercise 1.6: Find Elements by Text Content ===");

        // Login first
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in successfully");

        // Find element by exact text
        WebElement productByText = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertTrue(productByText.isDisplayed(), "Product should be found by text");
        System.out.println("✓ Found product by exact text: Sauce Labs Backpack");

        // Find element by partial text (contains)
        WebElement partialText = driver.findElement(By.xpath("//div[contains(text(), 'Backpack')]"));
        Assert.assertTrue(partialText.isDisplayed(), "Product should be found by partial text");
        System.out.println("✓ Found product by partial text (contains): 'Backpack'");
    }

    // ===== EXERCISE 7: Find by Partial Attribute =====
    @Test
    public void testLocatorByPartialAttribute() {
        System.out.println("\n=== Exercise 1.7: Find Elements by Partial Attribute ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in successfully");

        // Find by partial ID (starts with)
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[starts-with(@id, 'add-to-cart')]"));
        Assert.assertTrue(addToCartBtn.isDisplayed(), "Add to cart button should be found");
        System.out.println("✓ Found add to cart button by partial ID (starts-with)");

        // Find by partial ID (contains)
        List<WebElement> allAddButtons = driver.findElements(By.xpath("//button[contains(@id, 'add-to-cart')]"));
        Assert.assertTrue(allAddButtons.size() > 0, "Should find add to cart buttons");
        System.out.println("✓ Found " + allAddButtons.size() + " add to cart buttons by partial ID (contains)");
    }

    // ===== EXERCISE 8: Complex XPath Combinations =====
    @Test
    public void testComplexLocators() {
        System.out.println("\n=== Exercise 1.8: Complex Locator Combinations ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in successfully");

        // Find first product name
        WebElement firstProductName = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println("✓ First product: " + firstProductName.getText());

        // Find last product name
        WebElement lastProductName = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[last()]"));
        System.out.println("✓ Last product: " + lastProductName.getText());

        // Find product by position
        WebElement secondProduct = driver.findElement(By.xpath("(//div[@class='inventory_item'])[2]//div[@class='inventory_item_name']"));
        System.out.println("✓ Second product: " + secondProduct.getText());

        // Find button inside specific product
        WebElement firstAddButton = driver.findElement(By.xpath("(//div[@class='inventory_item'])[1]//button"));
        Assert.assertTrue(firstAddButton.isDisplayed(), "Add to cart button in first product should be found");
        System.out.println("✓ Found add to cart button in first product");
    }

    // ===== EXERCISE 9: Parent-Child Relationships =====
    @Test
    public void testParentChildLocators() {
        System.out.println("\n=== Exercise 1.9: Parent-Child Element Relationships ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in successfully");

        // Find parent container first
        WebElement firstItem = driver.findElement(By.xpath("//div[@class='inventory_item'][1]"));

        // Find child elements within parent
        WebElement name = firstItem.findElement(By.className("inventory_item_name"));
        WebElement price = firstItem.findElement(By.className("inventory_item_price"));
        WebElement button = firstItem.findElement(By.tagName("button"));

        System.out.println("✓ Product name: " + name.getText());
        System.out.println("✓ Product price: " + price.getText());
        System.out.println("✓ Button text: " + button.getText());
    }

    // ===== EXERCISE 10: Multiple Locator Strategies =====
    @Test
    public void testMultipleLocatorStrategies() {
        System.out.println("\n=== Exercise 1.10: Using Multiple Strategies Together ===");

        System.out.println("\n--- Method 1: By ID (Most Reliable) ---");
        WebElement username = driver.findElement(By.id("user-name"));
        System.out.println("✓ Found by ID");

        System.out.println("\n--- Method 2: By CSS Selector ---");
        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        System.out.println("✓ Found by CSS Selector");

        System.out.println("\n--- Method 3: By XPath ---");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        System.out.println("✓ Found by XPath");

        System.out.println("\n--- Method 4: By Class Name ---");
        List<WebElement> buttons = driver.findElements(By.className("login_button"));
        System.out.println("✓ Found " + buttons.size() + " elements by Class Name");

        System.out.println("\n✓ All locator strategies work!");
        System.out.println("✓ Choose based on: Reliability, Speed, Simplicity");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("\n✓ Browser closed!");
        }
    }
}
