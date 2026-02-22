package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestcontextSetUp;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	//this is called dependency injection , by creating constructor of defalut class and having data from another 
	//class which has driver objects such as test base class has webdriver Manager method
	TestcontextSetUp testcontextSetUp;
	
	public Hooks(TestcontextSetUp testcontextSetUp) {
		this.testcontextSetUp=testcontextSetUp;
		
		
	}
	
	@After
	public void afterScenario() throws IOException {
		testcontextSetUp.testbase.WebDriverManager().quit();
		
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver dr=testcontextSetUp.testbase.WebDriverManager();//for getting driver
		if(scenario.isFailed()) {
			File srcFile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(srcFile);//for converting file to byte array using apache commons io
			scenario.attach(fileContent, "image/png", "image");
			
		}
		//System.out.println("I am Here");
		
	}
	

}
