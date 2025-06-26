package com.osa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StudentPage {
	WebDriver dr;
	public StudentPage(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
}
