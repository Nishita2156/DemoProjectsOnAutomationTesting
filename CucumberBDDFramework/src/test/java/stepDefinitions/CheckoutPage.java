package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.CheckoutPagePOM;
import PageObjects.LandingPagePOM;
import Utils.TestcontextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutPage {
	public WebDriver dr;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPagePOM checkoutPagePOM;
	TestcontextSetUp testcontextSetUp;
	
	public CheckoutPage(TestcontextSetUp testcontextSetUp) {
		this.testcontextSetUp=testcontextSetUp;
		this.checkoutPagePOM=testcontextSetUp.pageObjectsManager.getCheckoutPage();
	}
	

	@Then("User has ability to enter promo code and checkout product")
	public void user_has_ability_to_enter_promo_code_and_checkout_product() {
	    
	    Assert.assertTrue(checkoutPagePOM.verifyPromobutton());
	    Assert.assertTrue(checkoutPagePOM.verifyPlaceOrder());
	}
	@Then("^User proceeds to checkout page and vaidate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_page_and_vaidate_the_Tom_items_in_checkout_page(String name){
			
		checkoutPagePOM.checkoutItems();
		
		//assertion to extract the name from screen and compare with name
	    
	}


}
