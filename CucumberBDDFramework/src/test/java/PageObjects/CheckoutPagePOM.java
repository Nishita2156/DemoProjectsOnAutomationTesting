package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPagePOM {
	public WebDriver dr;
	
	
	public  CheckoutPagePOM(WebDriver dr) {
		this.dr=dr;
	}
	
	private By cartBag= By.xpath("//img[@alt='Cart']");
	private By 	checkoutButton=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By promoButton=By.xpath("//button[text()='Apply']");
	private By placeOrderbutton=By.xpath("//button[text()='Place Order']");
	
	
	public void checkoutItems() {
		dr.findElement(cartBag).click();
		dr.findElement(checkoutButton).click();
	}
	public boolean verifyPromobutton() {
		return dr.findElement(promoButton).isDisplayed();
	}
	public boolean verifyPlaceOrder() {
		return dr.findElement(placeOrderbutton).isDisplayed();
		
	} 
   
}
