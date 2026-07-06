package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // WebDriverManager auto-downloads ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("✓ Browser launched!");
    }

    @Test
    public void testGoogleSearch() {
        driver.navigate().to("https://www.google.com");
        System.out.println("✓ Navigated to Google");

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title doesn't contain Google");
        System.out.println("✓ Page title verified: " + title);

        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
        System.out.println("✓ Typed 'Selenium WebDriver'");

        String searchText = driver.findElement(By.name("q")).getAttribute("value");
        Assert.assertEquals(searchText, "Selenium WebDriver", "Search text mismatch");
        System.out.println("✓ Search box verified!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✓ Browser closed!");
        }
    }
}
