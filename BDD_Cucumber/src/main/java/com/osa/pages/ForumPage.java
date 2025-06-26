package com.osa.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ForumPage {
	WebDriver dr;
	public ForumPage(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(name="username") 
	WebElement usernameBox;
	@FindBy(id="password") 
	WebElement passwordBox;
	@FindBy(id="login_button")
	WebElement loginButton;
	
	
	public void enterUsername(String username) {
		usernameBox.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordBox.sendKeys(password);
	}
	public StudentPage clickOnLoginButton() {
		loginButton.click();
		return new StudentPage(dr);
	}
	
}
