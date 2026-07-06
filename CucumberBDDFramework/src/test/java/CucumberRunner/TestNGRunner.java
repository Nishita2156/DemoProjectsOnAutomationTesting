package CucumberRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefinitions",
		tags="@PlaceOrder or @OffersPage",
		plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json"
		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"},
		
		monochrome=true
		
		
		)
public class TestNGRunner  extends AbstractTestNGCucumberTests{
	// very important---this helps to run the test cases parallely from cucumber itself without 
	//testNG suite by overriding super class scenario method 
	//if you want to run specific tag just give the tag name or all the test just don't add the tag
	//report-html,json,xml,junit,Extent-report(rich UI format reporting format with pie chart), Allure(Feature based explanation)
	//run only failed test cases from cucumber by using rerun plugin from cucumberoptions
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios(){
		return super.scenarios();
		
	}
	

}
