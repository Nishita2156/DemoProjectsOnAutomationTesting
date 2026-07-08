package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Day10_WaitsActionsInteractions {

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

    // ===== EXERCISE 1: Implicit vs Explicit Waits =====
    @Test
    public void testImplicitWait() {
        System.out.println("\n=== Exercise 1.1: Implicit Wait ===");

        // Implicit wait: Applied to ALL elements (set in setUp - 10 seconds)
        // It waits up to 10 seconds for any element to appear

        System.out.println("✓ Implicit wait is set to 10 seconds");
        System.out.println("✓ Any findElement() call will wait up to 10 seconds");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        Assert.assertTrue(usernameField.isDisplayed(), "Username field should appear within 10 seconds");
        System.out.println("✓ Username field found within implicit wait");

        System.out.println("\n⚠ Implicit Wait Notes:");
        System.out.println("  • Applied globally to all elements");
        System.out.println("  • Waits full time even if element appears earlier");
        System.out.println("  • Can cause tests to be SLOW");
        System.out.println("  • Use Explicit Wait instead for better control!");
    }

    // ===== EXERCISE 2: Explicit Wait (WebDriverWait) =====
    @Test
    public void testExplicitWait() {
        System.out.println("\n=== Exercise 1.2: Explicit Wait (WebDriverWait) ===");

        // Explicit wait: Wait for specific condition
        // Much better than implicit wait!

        System.out.println("✓ Using WebDriverWait with ExpectedConditions");

        // Wait for element to be visible
        WebElement loginButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );
        Assert.assertTrue(loginButton.isDisplayed(), "Login button should be visible");
        System.out.println("✓ Login button is visible (waited only as long as needed)");

        System.out.println("\n✓ Explicit Wait Benefits:");
        System.out.println("  • Wait only as long as needed (faster tests)");
        System.out.println("  • Wait for specific conditions (not just presence)");
        System.out.println("  • Better control and error messages");
        System.out.println("  • Recommended for professional automation!");
    }

    // ===== EXERCISE 3: Expected Conditions =====
    @Test
    public void testExpectedConditions() {
        System.out.println("\n=== Exercise 1.3: Expected Conditions ===");

        System.out.println("\n--- Condition 1: presenceOfElementLocated ---");
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user-name"))
        );
        System.out.println("✓ Element is present in DOM (may not be visible)");

        System.out.println("\n--- Condition 2: visibilityOfElementLocated ---");
        WebElement visible = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("password"))
        );
        System.out.println("✓ Element is visible on page");

        System.out.println("\n--- Condition 3: elementToBeClickable ---");
        WebElement clickable = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("login-button"))
        );
        System.out.println("✓ Element is clickable (visible AND enabled)");

        System.out.println("\n✓ Common ExpectedConditions:");
        System.out.println("  • presenceOfElementLocated() - Element in DOM");
        System.out.println("  • visibilityOfElementLocated() - Element visible");
        System.out.println("  • elementToBeClickable() - Element clickable");
        System.out.println("  • textToBePresentInElement() - Text appears");
        System.out.println("  • titleIs() - Page title matches");
        System.out.println("  • urlContains() - URL contains string");
    }

    // ===== EXERCISE 4: Wait for Elements to Load =====
    @Test
    public void testWaitForDynamicContent() {
        System.out.println("\n=== Exercise 1.4: Wait for Dynamic Content ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("✓ Logging in...");

        // Wait for products to load (dynamic content)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Products loaded (waited for dynamic content)");

        // Verify products are displayed
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        Assert.assertTrue(products.size() > 0, "Products should be loaded");
        System.out.println("✓ Found " + products.size() + " products after waiting");
    }

    // ===== EXERCISE 5: ActionChains - Click =====
    @Test
    public void testActionChainClick() {
        System.out.println("\n=== Exercise 1.5: ActionChains - Click ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in");

        // Find a product
        WebElement product = driver.findElement(By.className("inventory_item"));

        // Using ActionChains to move to element and click
        Actions actions = new Actions(driver);
        actions.moveToElement(product).click().perform();
        System.out.println("✓ Moved to element and clicked using ActionChains");

        // Verify we're on product detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details")));
        System.out.println("✓ Product detail page loaded");
    }

    // ===== EXERCISE 6: ActionChains - Hover =====
    @Test
    public void testActionChainHover() {
        System.out.println("\n=== Exercise 1.6: ActionChains - Hover ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in");

        // Find a product
        WebElement addToCartButton = driver.findElement(By.xpath("(//button[contains(@id, 'add-to-cart')])[1]"));

        // Hover over the button
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).perform();
        System.out.println("✓ Hovered over 'Add to Cart' button");

        // Verify button is still visible and clickable
        Assert.assertTrue(addToCartButton.isDisplayed(), "Button should be visible after hover");
        System.out.println("✓ Button is visible and ready to click");
    }

    // ===== EXERCISE 7: ActionChains - Double Click =====
    @Test
    public void testActionChainDoubleClick() {
        System.out.println("\n=== Exercise 1.7: ActionChains - Double Click ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in");

        // Find and double-click a product
        WebElement product = driver.findElement(By.className("inventory_item"));

        Actions actions = new Actions(driver);
        actions.doubleClick(product).perform();
        System.out.println("✓ Double-clicked on product");

        // May navigate to product detail page
        System.out.println("✓ Double-click action completed");
    }

    // ===== EXERCISE 8: ActionChains - Drag and Drop =====
    @Test
    public void testActionChainDragDrop() {
        System.out.println("\n=== Exercise 1.8: ActionChains - Drag and Drop ===");

        System.out.println("✓ Drag and drop is used for:");
        System.out.println("  • Moving elements around");
        System.out.println("  • Reordering items");
        System.out.println("  • Selecting multiple items");
        System.out.println("  • File uploads");

        System.out.println("\n✓ Syntax: actions.dragAndDrop(source, target).perform();");
        System.out.println("✓ Note: SauceDemo doesn't have drag-and-drop elements");
        System.out.println("✓ You'll use this on other websites with draggable items");
    }

    // ===== EXERCISE 9: Handle Dropdowns (Select) =====
    @Test
    public void testHandleDropdowns() {
        System.out.println("\n=== Exercise 1.9: Handle Dropdowns ===");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Logged in");

        // Find dropdown
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));

        // Create Select object
        Select select = new Select(sortDropdown);

        System.out.println("\n--- Method 1: Select by Value ---");
        select.selectByValue("hilo");
        System.out.println("✓ Selected 'Price (high to low)' by value: hilo");

        System.out.println("\n--- Method 2: Select by Index ---");
        select.selectByIndex(0);
        System.out.println("✓ Selected first option by index: 0");

        System.out.println("\n--- Method 3: Select by Visible Text ---");
        select.selectByVisibleText("Name (Z to A)");
        System.out.println("✓ Selected 'Name (Z to A)' by visible text");

        // Get all options
        List<WebElement> allOptions = select.getOptions();
        System.out.println("\n✓ Total options in dropdown: " + allOptions.size());
        for (WebElement option : allOptions) {
            System.out.println("  • " + option.getText());
        }

        // Get currently selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("\n✓ Currently selected: " + selectedOption.getText());
    }

    // ===== EXERCISE 10: Handle Alerts =====
    @Test
    public void testHandleAlerts() {
        System.out.println("\n=== Exercise 1.10: Handle Alerts ===");

        System.out.println("✓ Alert types and handling:");
        System.out.println("  • Simple Alert - Just message, OK button");
        System.out.println("  • Confirmation Alert - Message, OK/Cancel buttons");
        System.out.println("  • Prompt Alert - Message, text input, OK/Cancel");

        System.out.println("\n✓ Syntax for handling alerts:");
        System.out.println("  Alert alert = driver.switchTo().alert();");
        System.out.println("  alert.getText(); - Get alert message");
        System.out.println("  alert.accept(); - Click OK");
        System.out.println("  alert.dismiss(); - Click Cancel");
        System.out.println("  alert.sendKeys('text'); - Type in prompt");

        System.out.println("\n✓ Note: SauceDemo doesn't have alerts");
        System.out.println("✓ You'll use this on other websites with JavaScript alerts");
    }

    // ===== EXERCISE 11: Handle Multiple Windows/Tabs =====
    @Test
    public void testHandleMultipleWindows() {
        System.out.println("\n=== Exercise 1.11: Handle Multiple Windows/Tabs ===");

        // Get current window handle
        String mainWindow = driver.getWindowHandle();
        System.out.println("✓ Main window handle: " + mainWindow);

        // Get all window handles
        java.util.Set<String> allWindows = driver.getWindowHandles();
        System.out.println("✓ Total windows open: " + allWindows.size());

        System.out.println("\n✓ Syntax for switching windows:");
        System.out.println("  driver.switchTo().window(windowHandle);");

        System.out.println("\n✓ Switching between windows:");
        System.out.println("  1. Get current window handle");
        System.out.println("  2. Get all window handles");
        System.out.println("  3. Loop through and find target window");
        System.out.println("  4. Switch to target window");
        System.out.println("  5. Perform actions in that window");
        System.out.println("  6. Switch back to main window if needed");
    }

    // ===== EXERCISE 12: Switch to IFrames =====
    @Test
    public void testSwitchToIFrame() {
        System.out.println("\n=== Exercise 1.12: Switch to IFrames ===");

        System.out.println("✓ IFrames are embedded HTML pages within a page");

        System.out.println("\n✓ Syntax for switching to iFrame:");
        System.out.println("  driver.switchTo().frame(\"frameName\");");
        System.out.println("  driver.switchTo().frame(0); // By index");
        System.out.println("  driver.switchTo().frame(frameElement); // By element");

        System.out.println("\n✓ After working in iFrame, switch back:");
        System.out.println("  driver.switchTo().defaultContent(); // Back to main page");

        System.out.println("\n✓ Workflow:");
        System.out.println("  1. Find iFrame element");
        System.out.println("  2. Switch to iFrame: driver.switchTo().frame(iframe)");
        System.out.println("  3. Find and interact with elements inside iFrame");
        System.out.println("  4. Switch back: driver.switchTo().defaultContent()");

        System.out.println("\n✓ Note: SauceDemo doesn't have iFrames");
    }

    // ===== EXERCISE 13: Complete User Flow with Waits & Actions =====
    @Test
    public void testCompleteUserFlowWithWaitsAndActions() {
        System.out.println("\n=== Exercise 1.13: Complete User Flow ===");

        // Step 1: Login
        System.out.println("\n--- Step 1: Login ---");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println("✓ Login clicked");

        // Step 2: Wait for products to load
        System.out.println("\n--- Step 2: Wait for Products ---");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        System.out.println("✓ Products loaded");

        // Step 3: Sort products
        System.out.println("\n--- Step 3: Sort Products ---");
        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortDropdown);
        select.selectByValue("lh");
        System.out.println("✓ Selected 'Price (low to high)'");

        // Step 4: Get first product
        System.out.println("\n--- Step 4: Get First Product ---");
        WebElement firstProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='inventory_item'])[1]"))
        );
        System.out.println("✓ First product visible");

        // Step 5: Add to cart using ActionChains
        System.out.println("\n--- Step 5: Add to Cart ---");
        WebElement addButton = firstProduct.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(addButton).click().perform();
        System.out.println("✓ Clicked 'Add to Cart' using ActionChains");

        // Step 6: Verify cart updated
        System.out.println("\n--- Step 6: Verify Cart ---");
        WebElement cartBadge = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge"))
        );
        Assert.assertEquals(cartBadge.getText(), "1", "Cart should have 1 item");
        System.out.println("✓ Cart shows 1 item");

        System.out.println("\n✓ Complete user flow executed successfully!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("\n✓ Browser closed!");
        }
    }
}
