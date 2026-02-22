package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectsManager;

public class TestcontextSetUp {
	public WebDriver dr;
	public String landingPageProductName;
	public PageObjectsManager pageObjectsManager;
	public TestBase testbase;
	public GenericUtils genericUtils;
	
	public TestcontextSetUp() throws IOException {
		testbase=new TestBase();
		pageObjectsManager=new PageObjectsManager(testbase.WebDriverManager());
		genericUtils=new GenericUtils(testbase.WebDriverManager());
		
		
	}
	
}
