package com.etsy.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.etsy.base.Base;
import com.etsy.pages.EtsyHomePage;
import com.etsy.pages.EtsySearchResultPage;
import com.etsy.utils.StepsLogger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class EtsySearch extends Base {
	EtsyHomePage homePage;
	EtsySearchResultPage SearchResultPage;
	
	@Given("user launches the Etsy Website")
    public void user_launches_the_etsy_website(WebDriver dr) {
        String step = "Given user launches the Etsy Website";
        
		try {
            homePage = new EtsyHomePage(dr);
            SearchResultPage = new EtsySearchResultPage(dr);
            StepsLogger.logPass(step);
        } catch (Exception e) {
            StepsLogger.logFail(step, e, dr);
            throw e;
        }
    }
	 @When("user searches for {string} using search bar")
	    public void user_searches_for_using_search_bar(String product, WebDriver dr) {
	        String step = "When user searches for \"" + product + "\" using search bar";
	        try {
	            homePage.searchProduct(product);
	            StepsLogger.logPass(step);
	        } catch (Exception e) {
	            
				StepsLogger.logFail(step, e, dr);
	            throw e;
	        }
	    }
    
	 @Then("the serach results page should display relevant items for {string}")
	    public void the_search_results_page_should_display_relevant_items_for(String product, WebDriver dr) {
	        String step = "Then the search results page should display relevant items for \"" + product + "\"";
	        try {
	            String actual = SearchResultPage.getSearchResultText().toLowerCase().trim();
	            String expected = product.toLowerCase().trim();
	            Assert.assertTrue(actual.contains(expected), "Search result mismatch!");
	            StepsLogger.logPass(step);
	        } catch (Exception e) {
	            StepsLogger.logFail(step, e, dr);
	            throw e;
	        }
	    }
	 @Then("the page title should reflect the searched {string}")
	    public void the_page_title_should_reflect_the_searched(String product, WebDriver dr) {
	        String step = "Then the page title should reflect the searched \"" + product + "\"";
	        try {
	            String title = SearchResultPage.getPageTitle().toLowerCase();
	            Assert.assertTrue(title.contains(product.toLowerCase()), "Title mismatch!");
	            StepsLogger.logPass(step);
	        } catch (Exception e) {
	            StepsLogger.logFail(step, e, dr);
	            throw e;
	        }
	    }

	    @Then("the browser URL should include the search term {string}")
	    public void the_browser_url_should_include_the_search_term(String product, WebDriver dr) {
	        String step = "Then the browser URL should include the search term \"" + product + "\"";
	        try {
	            String url = SearchResultPage.getCurrentUrl().toLowerCase();
	            Assert.assertTrue(url.contains(product.toLowerCase()), "URL mismatch!");
	            StepsLogger.logPass(step);
	        } catch (Exception e) {
	            StepsLogger.logFail(step, e, dr);
	            throw e;
	        }
	    }
	    @Then("filtering options should be available on the left side")
	    public void filtering_options_should_be_available_on_the_left_side(WebDriver dr) {
	        String step = "Then filtering options should be available on the left side";
	        try {
	            Assert.assertTrue(SearchResultPage.isFilterSectionVisible(), "Filter section not found!");
	            StepsLogger.logPass(step);
	        } catch (Exception e) {
	            StepsLogger.logFail(step, e, dr);
	            throw e;
	        }
	    }

	    @Then("a list of product results should be visible to the user")
	    public void a_list_of_product_results_should_be_visible_to_the_user(WebDriver dr) {
	        String step = "Then a list of product results should be visible to the user";
	        try {
	            Assert.assertTrue(SearchResultPage.isFirstProductVisible(), "Product results not visible");
	            Assert.assertTrue(SearchResultPage.arePricesVisible(), "Prices missing");
	            Assert.assertTrue(SearchResultPage.areRatingsVisible(), "Ratings missing");
	            StepsLogger.logPass(step);
	        } catch (Exception e) {
	            StepsLogger.logFail(step, e, dr);
	            throw e;
	        }
	    }
}
