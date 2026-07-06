package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class LandingPagePOM {
		public WebDriver dr;
		
		
		public LandingPagePOM(WebDriver dr) {
			this.dr=dr;
		}
		
		private By search= By.xpath("//input[@type='search']");
		private By 	productname=By.cssSelector("h4.product-name");
		private By topDeals=By.linkText("Top Deals");
		private By incrementSign=By.cssSelector("a.increment");
		private By addTocartButton=By.cssSelector("div.product-action button");
		
		public void searchItem(String name) {
			dr.findElement(search).sendKeys(name);
		}
	   public void getSearchText() {
		   dr.findElement(search).getText();
	   }
	   public void incrementQuantity(int quantity) {
		   int i=quantity-1;
		   while(i>0) {
			   dr.findElement(incrementSign).click();
			   i--;
			   
		   }
		   	
	   }
	   public void addtoCart() {
		   dr.findElement(addTocartButton).click();
	   }
	   public String getProductName() {
		  return dr.findElement(productname).getText(); 
	   }
	   public void selectTopDeals() {
		   dr.findElement(topDeals).click();
	   }
	   public String getTitleOfLandingPage() {
		   return dr.getTitle();
		   
	   }
}
