package com.osa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver dr;
	public HomePage(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
    @FindBy(xpath="//a[text()='About']")
    WebElement aboutButton;
	@FindBy(xpath="//a[text()='Forum']") 
	WebElement forumButton;
	 
	public AboutPa clickOnAboutButton() {
		aboutButton.click();
		return new AboutPa(dr);
	}
	
	public ForumPage clickOnForumButton() {
		forumButton.click();
		return new ForumPage(dr);
	}
}
