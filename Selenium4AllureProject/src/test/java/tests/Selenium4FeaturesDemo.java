package tests;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

@Epic("Selenium 4 Features")
@Feature("Allure Integration")
public class Selenium4FeaturesDemo {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nishita Jannat Alam\\Desktop\\selenium2021\\chromedriver.exe");
        
       driver = new ChromeDriver(new ChromeOptions());
    }

    @Test(description = "Test with Relative Locators")
    @Severity(SeverityLevel.NORMAL)
    @Description("Enter text using Relative Locator")
    public void testRelativeLocator() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement label = driver.findElement(By.tagName("label"));
        WebElement input = driver.findElement(with(By.tagName("input")).below(label));
        input.sendKeys("Test input");
        Allure.step("Entered text using relative locator");
    }

    @Test(description = "Take Screenshot of Element")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Takes screenshot of Selenium logo")
    public void testElementScreenshot() throws IOException {
        driver.get("https://www.selenium.dev/");
        WebElement logo = driver.findElement(By.cssSelector("img[alt='Selenium Logo']"));
        File src = logo.getScreenshotAs(OutputType.FILE);
        File dest = new File("target/selenium_logo.png");
        FileUtils.copyFile(src, dest);
        Allure.addAttachment("Logo Screenshot", FileUtils.openInputStream(dest));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}