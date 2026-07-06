package com.osa.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/main/java/com/osa/features"},
		glue="com.osa.steps",
		tags= {"@regression"},
		plugin = {"json:target/cucumber-reports/Cucumber.json","pretty",
				"de.monochromata.cucumber.report.PrettyReports:target/cucumber","html:target/pretty-cucumber"}
		
		)
public class RegressionQA extends AbstractTestNGCucumberTests {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("$$$$$$$$$$$Running before suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("=====Running after suite=====");
	}
}
