package com.yatra;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YatraCalenderAutomation {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOption=new ChromeOptions();
		chromeOption.addArguments("--disable-notifications");
		WebDriver dr=new ChromeDriver(chromeOption);
		WebDriverWait wait=new WebDriverWait(dr,Duration.ofSeconds(20));//synchronization of WebDriver
		dr.manage().window().maximize();
		closePopup(wait);
		dr.get("https://www.yatra.com/");
		clickOnDepartureDate(wait);
		
		
		WebElement currentCalenderWebElement=selectTheMonthFromCalender(wait, 0);
		WebElement nextMonthCalenderWebElement=selectTheMonthFromCalender(wait, 1);
		Thread.sleep(3000);
		
		String lowestPricecurrentMonth=getMeLowsetPrice(currentCalenderWebElement);
		String  lowsetPricenextMonth=getMeLowsetPrice(nextMonthCalenderWebElement);
		System.out.println(lowestPricecurrentMonth);
		System.out.println(lowsetPricenextMonth);
		compareTwoMonthsPrice(lowestPricecurrentMonth,lowsetPricenextMonth);
		
		
	}
	public static void clickOnDepartureDate(WebDriverWait wait) {
		By departureDateLocator=By.xpath("//div[@aria-label=\"Departure Date inputbox\" and @role=\"button\"]");
		WebElement departureDateButton=wait.until(ExpectedConditions.elementToBeClickable(departureDateLocator));
		departureDateButton.click();
	}
	public static void closePopup(WebDriverWait wait) {
		try {
		By popUpLocator=By.xpath("//div[contains(@class,\"style_popup\")][1]");
		WebElement popUpElement=wait.until(ExpectedConditions.visibilityOfElementLocated(popUpLocator));
		WebElement crossButton=popUpElement.findElement(By.xpath(".//img[@alt=\'cross\']"));
		}
		catch(TimeoutException e) {
			System.out.println("Pop up not shown in the screen !!");
		}
	}
	public static String getMeLowsetPrice(WebElement monthWebelement) {
		By priceLocator=By.xpath(".//span[contains(@class,\"custom-day-content\")]");
		List<WebElement> julyPriceList=monthWebelement.findElements(priceLocator);//chaining of webElement
		int lowestPrice=Integer.MAX_VALUE;
		WebElement priceElement=null;	
		for(WebElement price:julyPriceList) {
		String priceString=price.getText();
		if(priceString.length()>0) {
		priceString=priceString.replace("₹", "").replace(",", "");
		
		int priceInt=Integer.parseInt(priceString);
		if(priceInt<lowestPrice) {
			lowestPrice=priceInt;
			priceElement=price;
		}
		}
		}
		
		WebElement dateElement=priceElement.findElement(By.xpath(".//../.."));
	    String result=lowestPrice+" "+dateElement.getAttribute("aria-label") +"price is Rs." +lowestPrice;
	    return result;
	}
	
		public static WebElement selectTheMonthFromCalender(WebDriverWait wait, int index) {
			By calendermonthLocator=By.xpath("//div[@class=\"react-datepicker__month-container\"]");
			List<WebElement> monthsList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(calendermonthLocator));
			System.out.println(monthsList.size());
			WebElement MonthCalenderList=monthsList.get(0);
			return MonthCalenderList;
		}
		public static void compareTwoMonthsPrice(String currentMonthPrice, String nextMonthPrice) {
			int currentMonthRsIndex=currentMonthPrice.indexOf("Rs");
			int nextMonthRsIndex=nextMonthPrice.indexOf("Rs");
			String currentPrice=currentMonthPrice.substring(currentMonthRsIndex+2);
			String nextPrice=nextMonthPrice.substring(nextMonthRsIndex+2);
			int current=Integer.parseInt(currentPrice);
			int next=Integer.parseInt(nextPrice);
			
			if(current<next) {
				System.out.println("The lowset price for the two month is :"+current);
			}else if(current==next) {
				System.out.println("The price is same for both month");
			}else {
				System.out.println("The lowset price for the two month is :"+next);
				
			}
		}

}

