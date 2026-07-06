package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.LandingPagePOM;
import PageObjects.OffersPagePOM;
import PageObjects.PageObjectsManager;
import Utils.TestcontextSetUp;
import io.cucumber.java.en.Then;

public class offerPage {
	
	public String offerPageProductName;
	TestcontextSetUp testcontextSetUp;
	PageObjectsManager pageObjectsManager;
	
	public offerPage(TestcontextSetUp testcontextSetUp) {
		this.testcontextSetUp=testcontextSetUp;
	}
	@Then("^User searched for (.+) shortname in offers page to check if product exists$")
	public void user_searched_for_short_name_in_offers_page_to_check_if_product_exists(String shortName) {
		switchToOffersPage();
		OffersPagePOM offersPage =testcontextSetUp.pageObjectsManager.getOfferPage();
		offersPage.searchItem(shortName);
		offerPageProductName=offersPage.getProductName();
		 System.out.println("Product name extracted from offer page "+offerPageProductName);
		
		Assert.assertEquals(testcontextSetUp.landingPageProductName, offerPageProductName);
		
	    
	}
	public void switchToOffersPage() {
	
		LandingPagePOM landingPage=testcontextSetUp.pageObjectsManager.getLandingPage();
		landingPage.selectTopDeals();
		testcontextSetUp.genericUtils.switchWindowToChild();
	}


}
