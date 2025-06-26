package com.osa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicePage {
WebDriver dr;
public ServicePage(WebDriver dr) {
	this.dr=dr;
	PageFactory.initElements(dr,this);
}
	@FindBy(xpath="//li[@class='nav-item active']")
	WebElement servicesButton;
	
	public ServicePage clickOnServicesButton() {
		servicesButton.click();
		return new ServicePage(dr);
		
	}
			
	
	


}
