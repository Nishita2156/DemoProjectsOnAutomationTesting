package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPagePOM {
public WebDriver dr;
	
	
	public OffersPagePOM(WebDriver dr) {
		this.dr=dr;
	}
	
	private By search= By.xpath("//input[@type='search']");
	private By 	productname=By.xpath("//tr//td[text()='Tomato']");
	
	public void searchItem(String name) {
		dr.findElement(search).sendKeys(name);
	}
   public void getSearchText() {
	   dr.findElement(search).getText();
   }
   public String getProductName() {
	  return dr.findElement(productname).getText(); 
   }
}
