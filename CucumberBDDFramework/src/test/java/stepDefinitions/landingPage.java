package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPagePOM;
import Utils.TestcontextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class landingPage {
	public WebDriver dr;
	public String landingPageProductName;
	public String offerPageProductName;
	TestcontextSetUp testcontextSetUp;
	public LandingPagePOM landingPage;
	
	public landingPage(TestcontextSetUp testcontextSetUp) {
		this.testcontextSetUp=testcontextSetUp;
		this.landingPage=testcontextSetUp.pageObjectsManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_GreenCart_Landing_page() {
		
	Assert.assertTrue(landingPage.getTitleOfLandingPage().contains("GreenKart"));
		
		
	    
	}
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testcontextSetUp.landingPageProductName=landingPage.getProductName().split("-")[0].trim();//because it has more text other than tomato and also space
		System.out.println("Product name is extacted from home page "+landingPageProductName);
		
		
	    
	}
	@When("Added {string} items of selected product to the cart")
	public void add_Items_To_The_Cart(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addtoCart();
		
		
	}

}
