package com.osa.steps;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.osa.base.Browser;
import com.osa.pages.AboutPa;
import com.osa.pages.ForumPage;
import com.osa.pages.HomePage;
import com.osa.pages.ServicePage;
import com.osa.pages.StudentPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FoumLogin{
	AboutPa ap;
	ServicePage sep;
	HomePage hp;
	ForumPage fp;
	StudentPage sp;
	WebDriver dr;
	
	@Given("^I am on OSAs home page$") //This is regular expression
	public void i_am_on_OSAs_home_page() {
		dr=Browser.openBrowser("chrome");
		hp=new HomePage(dr);
	}
	@And("^I click on Forum page$")
	public void  i_click_on_Forum_page() throws InterruptedException {
		fp=hp.clickOnForumButton();
	}
	@When("^user clicks on service button$")
	public void user_clicks_on_service_button(){
		sep=sep.clickOnServicesButton();
		
	}
	@Then ("^verify the title of the service page$")
	public void verify_the_title_of_the_service_page() {
		System.out.println("title is found");
	}
	@When("^I get the Forum page title$")
	public void  i_get_the_Forum_page_title() {
		System.out.println("this method is working");
	}
	
	@Then("^I verify the title with expectd one$")
	public void  i_verify_the_title_with_expectd_one() {
		System.out.println("this method is working");
	}
	@And("^I close the browser$")
	public void i_close_the_browser() throws InterruptedException {
		Thread.sleep(3000);
		dr.quit();
	}
	String homePagetitle=null;
	@When("^I get the home page title$")
	public void i_get_the_home_page_title() {
		homePagetitle=dr.getTitle();
	}
	@Then("^I verify the title$")
	public void i_verify_the_title() {
		System.out.println("Expected Title :"+"OSA Consulting Tech Corp || Best Available Resources For Software Industry");
		System.out.println("Actual Title :"+homePagetitle);
	}
	@And("I enter username")
	public void i_enter_username() {
	   fp.enterUsername("Username");
	}

	@And("I enter password")
	public void i_enter_password() {
		fp.enterPassword("mypassword");
	}

	@When("I click on forum login button")
	public void i_click_on_forum_login_button() {
		sp =fp.clickOnLoginButton();
	}

	@Then("I should be able to see the student page")
	public void i_should_be_able_to_see_the_student_page() {
	   
	}
	
	@Given("I enter username as {string}")
	public void i_enter_username_as(String username) {
		fp.enterUsername(username);
	}

	@Given("I enter password as {string}")
	public void i_enter_password_as(String password) {
		fp.enterPassword(password);
	}
	@When("I click on Forum Page")
	public void i_click_on_Forum_Page() {
		sp=fp.clickOnLoginButton();
	}

	@Then("I verify the forum page title")
	public void i_verify_the_forum_page_title() {
		String forumPageTitle=dr.getTitle();
		String actualForumPageTitle="OSA Consulting Tech - All the projects";
		if(forumPageTitle.equals(actualForumPageTitle)) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			System.out.println("Expected Value: "+forumPageTitle);
			System.out.println("Actual Value: "+actualForumPageTitle);
			Assert.assertEquals(forumPageTitle, actualForumPageTitle);
		}
	}


}
