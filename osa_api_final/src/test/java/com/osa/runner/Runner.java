package com.osa.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//its for set up every report like cucumber report its come under the target folder 
@CucumberOptions(tags = "@Tests", 
                  features = {"src/test/java/com/osa/features"},
                   glue = {"com.osa.steps"},
                plugin = {"json:target/cucumber-reports/Cucumer.json","pretty",
		         "de.monochromata.cucumber.report.PrettyReports:target/cucumber"})

public class Runner  extends AbstractTestNGCucumberTests{

}
