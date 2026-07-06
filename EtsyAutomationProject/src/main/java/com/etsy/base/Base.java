package com.etsy.base;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	public static WebDriver dr;
	
	 @BeforeMethod
	    public void setUp() {

	        String browserName = com.etsy.utils.ConfigReader.getProperty("browser");

	        switch (browserName.toLowerCase()) {
	            case "chrome":
	                dr = new ChromeDriver();
	                break;

	            case "firefox":
	                dr = new FirefoxDriver();
	                break;

	            case "edge":
	                dr = new EdgeDriver();
	                break;

	            default:
	                System.out.println("❌ Invalid browser name in config.properties!");
	                throw new RuntimeException("Unsupported browser");
	        }
		dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get(com.etsy.utils.ConfigReader.getProperty("url"));
		
		
	}
	@AfterMethod
	public static WebDriver closeBrowser() {
		WebDriver dr=null;
		dr.quit();
		return dr;
		
	}
	

}
