package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {
	public LandingPagePOM LandingPagePOM;
	public OffersPagePOM OffersPagePOM;
	public CheckoutPagePOM CheckoutPagePOM;
	public WebDriver dr;
	
	public PageObjectsManager(WebDriver dr) {
		this.dr=dr;
		
	}
	
	public LandingPagePOM getLandingPage() {
	 LandingPagePOM =new LandingPagePOM(dr);
	 return LandingPagePOM; 
	} 
	public OffersPagePOM getOfferPage() {
		 OffersPagePOM =new OffersPagePOM(dr);
		 return OffersPagePOM; 
		} 
    public CheckoutPagePOM getCheckoutPage() {
    	CheckoutPagePOM=new CheckoutPagePOM(dr);
    	return CheckoutPagePOM;
    }
}
