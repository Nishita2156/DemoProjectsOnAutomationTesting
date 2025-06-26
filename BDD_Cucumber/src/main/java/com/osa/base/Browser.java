package com.osa.base;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

public static WebDriver openBrowser(String browser) {
	WebDriver dr=null;
	  if(browser.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup(); 
		  dr=new FirefoxDriver();
	  }else if(browser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  dr=new ChromeDriver();
	  }else {
		  System.out.println("Enter the browser name either firefox or chrome");
	  }
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 dr.get("https://www.osaconsultingtech.com");
	 return dr;
}
}
