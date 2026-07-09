package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Day12_TestNGAdvanced {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    // ===== SETUP & TEARDOWN =====

    @BeforeClass
    public void beforeClass() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  @BeforeClass - Runs ONCE before all tests in class");
        System.out.println("╚════════════════════════════════════════╝");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://www.saucedemo.com");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);

        System.out.println("\n✓ @BeforeMethod: Browser & Page Objects initialized");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✓ @AfterMethod: Browser closed\n");
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║  @AfterClass - Runs ONCE after all tests in class");
        System.out.println("╚════════════════════════════════════════╝");
    }

    // ===== EXERCISE 1: Test Grouping with @Test Groups =====

    @Test(groups = "smoke")
    public void testLoginSmoke() {
        System.out.println("\n=== Test 1.1: Login (SMOKE Group) ===");
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        Assert.assertTrue(productPage.isProductsLoaded(), "Products should load");
        System.out.println("✓ Login smoke test PASSED");
    }

    @Test(groups = "smoke")
    public void testProductLoadSmoke() {
        System.out.println("\n=== Test 1.2: Product Load (SMOKE Group) ===");
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        int productCount = productPage.getProductCount();
        Assert.assertTrue(productCount > 0, "Products should be loaded");
        System.out.println("✓ Product load smoke test PASSED");
    }

    @Test(groups = "regression")
    public void testAddToCartRegression() {
        System.out.println("\n=== Test 1.3: Add to Cart (REGRESSION Group) ===");
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        productPage.addFirstProductToCart();
        Assert.assertEquals(productPage.getCartItemCount(), 1, "Cart should have 1 item");
        System.out.println("✓ Add to cart regression test PASSED");
    }

    @Test(groups = "regression")
    public void testSortProductsRegression() {
        System.out.println("\n=== Test 1.4: Sort Products (REGRESSION Group) ===");
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        productPage.sortBy("lh");
        String firstProduct = productPage.getFirstProductName();
        Assert.assertNotNull(firstProduct, "Product name should not be null");
        System.out.println("✓ Sort products regression test PASSED");
    }

    @Test(groups = {"regression", "cart"})
    public void testRemoveFromCartRegression() {
        System.out.println("\n=== Test 1.5: Remove from Cart (REGRESSION & CART Groups) ===");
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        productPage.addFirstProductToCart();
        productPage.clickCart();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.id("checkout")
        ));
        cartPage.removeFirstItem();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart should be empty");
        System.out.println("✓ Remove from cart regression test PASSED");
    }

    // ===== EXERCISE 2: Test Priority =====

    @Test(priority = 1)
    public void testPriority1_CriticalTest() {
        System.out.println("\n=== Test 2.1: Priority 1 (CRITICAL - Runs First) ===");
        System.out.println("✓ This test runs FIRST (lowest priority number = runs first)");
    }

    @Test(priority = 2)
    public void testPriority2_HighTest() {
        System.out.println("\n=== Test 2.2: Priority 2 (HIGH - Runs Second) ===");
        System.out.println("✓ This test runs SECOND");
    }

    @Test(priority = 3)
    public void testPriority3_MediumTest() {
        System.out.println("\n=== Test 2.3: Priority 3 (MEDIUM - Runs Third) ===");
        System.out.println("✓ This test runs THIRD");
    }

    // ===== EXERCISE 3: Dependent Tests =====

    @Test(description = "Login test - prerequisite for other tests")
    public void testLoginDependency() {
        System.out.println("\n=== Test 3.1: Login Dependency ===");
        loginPage.login("standard_user", "secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.className("inventory_list")
        ));
        System.out.println("✓ Login successful - other tests can depend on this");
    }

    @Test(dependsOnMethods = "testLoginDependency", description = "Test that depends on login")
    public void testAddProductDependency() {
        System.out.println("\n=== Test 3.2: Add Product (Depends on Login) ===");
        System.out.println("✓ This test runs ONLY if login test passed");
        // Note: In real scenario, we'd need to maintain driver state
        // For now, just demonstrating the concept
    }

    // ===== EXERCISE 4: Test Timeouts =====

    @Test(timeOut = 5000, description = "Test with 5-second timeout")
    public void testWithTimeout() {
        System.out.println("\n=== Test 4.1: Test with Timeout ===");
        System.out.println("✓ This test has a 5-second timeout");
        System.out.println("✓ If test takes longer than 5 seconds, it FAILS");
        try {
            Thread.sleep(1000); // Sleep for 1 second (within timeout)
            System.out.println("✓ Test completed within timeout");
        } catch (InterruptedException e) {
            System.out.println("✗ Test interrupted");
        }
    }

    // ===== EXERCISE 5: Parameterized Tests =====

    @Test(dataProvider = "loginCredentials")
    public void testParameterizedLogin(String username, String password, boolean shouldPass) {
        System.out.println("\n=== Test 5.1: Parameterized Login ===");
        System.out.println("✓ Testing with username: " + username + ", password: " + password);

        if (shouldPass) {
            System.out.println("✓ Expected: Login should succeed");
        } else {
            System.out.println("✓ Expected: Login should fail");
        }
    }

    @DataProvider(name = "loginCredentials")
    public Object[][] getLoginCredentials() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"locked_out_user", "secret_sauce", false},
                {"problem_user", "secret_sauce", true},
        };
    }

    // ===== EXERCISE 6: Ignored Tests =====

    @Test
    public void testActiveTest() {
        System.out.println("\n=== Test 6.1: Active Test ===");
        System.out.println("✓ This test runs normally");
    }

    @Test(enabled = false)
    public void testDisabledTest() {
        System.out.println("\n=== Test 6.2: Disabled Test ===");
        System.out.println("✗ This test is SKIPPED (enabled = false)");
    }

    // ===== EXERCISE 7: Test Descriptions =====

    @Test(description = "Verifies that users can successfully login with valid credentials")
    public void testWithDescription() {
        System.out.println("\n=== Test 7.1: Test with Description ===");
        System.out.println("✓ Description: Verifies that users can successfully login");
        System.out.println("✓ Descriptions appear in test reports");
    }

    // ===== EXERCISE 8: Expected Exceptions =====

    @Test(expectedExceptions = NumberFormatException.class)
    public void testExpectedExceptionTest() {
        System.out.println("\n=== Test 8.1: Expected Exception ===");
        System.out.println("✓ This test expects NumberFormatException");
        String number = "abc";
        int value = Integer.parseInt(number); // This will throw exception
        System.out.println("✓ Exception thrown and caught as expected");
    }

    // ===== EXERCISE 9: Test Execution Order =====

    @Test(priority = 10, description = "First in execution order")
    public void testExecutionOrder1() {
        System.out.println("\n=== Test 9.1: Execution Order (Priority 10) ===");
        System.out.println("✓ Runs FIRST among these 3 tests");
    }

    @Test(priority = 20, description = "Second in execution order")
    public void testExecutionOrder2() {
        System.out.println("\n=== Test 9.2: Execution Order (Priority 20) ===");
        System.out.println("✓ Runs SECOND among these 3 tests");
    }

    @Test(priority = 30, description = "Third in execution order")
    public void testExecutionOrder3() {
        System.out.println("\n=== Test 9.3: Execution Order (Priority 30) ===");
        System.out.println("✓ Runs THIRD among these 3 tests");
    }

    // ===== EXERCISE 10: TestNG Features Summary =====

    @Test
    public void testNGFeaturesOverview() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║            TESTNG FEATURES OVERVIEW                     ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ @BeforeClass    - Run once before ALL tests            ║");
        System.out.println("║ @BeforeMethod   - Run before EACH test                  ║");
        System.out.println("║ @Test           - Mark method as test                   ║");
        System.out.println("║ @AfterMethod    - Run after EACH test                   ║");
        System.out.println("║ @AfterClass     - Run once after ALL tests              ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ groups          - Organize tests into categories        ║");
        System.out.println("║ priority        - Control test execution order          ║");
        System.out.println("║ dependsOnMethods- Chain tests with dependencies         ║");
        System.out.println("║ dataProvider    - Run test with multiple datasets       ║");
        System.out.println("║ timeOut         - Set maximum test duration             ║");
        System.out.println("║ enabled         - Enable/disable tests                  ║");
        System.out.println("║ description     - Add meaningful descriptions           ║");
        System.out.println("║ expectedExceptions - Test exception handling           ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
