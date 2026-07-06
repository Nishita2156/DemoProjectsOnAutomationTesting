package com.etsy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EtsyHomePage {
	 private WebDriver driver;

	    private By searchBox = By.id("global-enhancements-search-query");
	    private By searchButton = By.xpath("//span[@class='wt-icon wt-nudge-b-2 wt-nudge-r-1']");

	    public EtsyHomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void searchProduct(String productName) {
	        driver.findElement(searchBox).clear();
	        driver.findElement(searchBox).sendKeys(productName);
	        driver.findElement(searchButton).click();
	    }

}
