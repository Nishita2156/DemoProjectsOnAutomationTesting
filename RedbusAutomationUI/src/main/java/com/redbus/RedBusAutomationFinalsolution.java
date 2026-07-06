package com.redbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusAutomationFinalsolution {
	public static void main(String[] args)  {
		ChromeOptions chromeoptions=new ChromeOptions();//creating chromeoptions for passing the arguments to the driver
		chromeoptions.addArguments("--start-maximized");
	
		WebDriver wd=new ChromeDriver(chromeoptions);
		WebDriverWait wait=new WebDriverWait(wd,Duration.ofSeconds(30));//synchronization solution
	
        wd.get("https://www.redbus.in/");
        By sourceButtonLocator=By.xpath("//div[contains(@class,\"srcDestWrapper\") and @role=\"button\"]");//returning by kind of data
        WebElement sourceButton=wd.findElement(sourceButtonLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sourceButtonLocator));
        sourceButton.click();
        By searchSuggestionSelectionLocator=By.xpath("//div[contains(@class,\"searchSuggestionWrapper\")]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggestionSelectionLocator));
        
        selectLocation(wd,wait,"Mumbai");//for location
        selectLocation(wd,wait,"Pune");//to location
        By searchButtonLocator=By.xpath("//div[contains(@class,\"searchBtnWrapper\")]");
        WebElement searchButton=wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        By primobuttonLocator=By.xpath("//div[text()=\"Primo Bus\"]");
        WebElement primobutton=wait.until(ExpectedConditions.elementToBeClickable(primobuttonLocator));
        primobutton.click();
        //Thread.sleep(4000);//delay for time to load rows
        By NTAbhinavLocator=By.xpath("//div[text()=\"N.T Abhinav\"]");//found the row locator
        By busNameLocator=By.xpath("//div[contains(@class,\"travelsName\")]");//bus name locator
        List<WebElement> rowList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NTAbhinavLocator));
        
        By eveningButtonLocator=By.xpath("//div[text()=\"Evening\"]");
        WebElement eveningbutton=wait.until(ExpectedConditions.elementToBeClickable(eveningButtonLocator));
        eveningbutton.click();
        By subtitleLocator=By.xpath("//span[contains(@class,\"subtitle\")]");
        WebElement subtitle=null;
        if(wait.until(ExpectedConditions.textToBePresentInElementLocated(subtitleLocator, "buses"))){
        	subtitle=wait.until(ExpectedConditions.visibilityOfElementLocated(subtitleLocator));
        }
        System.out.println(subtitle.getText());//showing...dots,solving it using webDriverwait because thread.sleep is not ideal here , goona slow the script
        
        JavascriptExecutor js=(JavascriptExecutor)wd;
        
       // Thread.sleep(5000);
       
       while(true) {
    	   
    	   List<WebElement> rowlist=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(NTAbhinavLocator));
    	   List<WebElement>endOfList=wd.findElements(By.xpath("//span[text()=\"End of list\"]"));
    	   
    	   if(!endOfList.isEmpty()) {
    		   break;//exit condition for the while loop
    	   }
    	   js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'})", rowList.get(rowList.size()-3));
       }
       
       System.out.println("Total number of buses loaded with primo and evening filter :"+rowList.size());
        
	}
        public static void selectLocation(WebDriver wd, WebDriverWait wait, String locationData) {
        WebElement SearchTextboxElement=wd.switchTo().activeElement();//give me that text box by switching to the element
         SearchTextboxElement.sendKeys("locationData");
        //getting the automatic suggestions
        By searchCategoryLocator=By.xpath("//div[contains(@class=\"searchCategory\")]");
       List<WebElement> searchList=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategoryLocator, 2));
        System.out.println(searchList.size()); 
        WebElement locationseacrhlist=searchList.get(0);
        //chaining of locators
        By locationNameLocator=By.xpath(".//div[contains(@class,\"listHeader\")]");
       List<WebElement> locationList=locationseacrhlist.findElements(locationNameLocator);
       System.out.println(locationList.size());
       for(WebElement location:locationList) {
    	   String lName=location.getText();
    	   if(lName.equalsIgnoreCase("locationData")) {
    		   location.click();
    		   break;
    	   }
    	   
       }
        }
        
        
        
        
    
       
       
	}


