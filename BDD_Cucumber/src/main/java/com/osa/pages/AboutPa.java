package com.osa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutPa {
	WebDriver dr;
	public AboutPa(WebDriver dr){
		this.dr=dr;
		PageFactory.initElements(dr, this);
		
	}
	

}
