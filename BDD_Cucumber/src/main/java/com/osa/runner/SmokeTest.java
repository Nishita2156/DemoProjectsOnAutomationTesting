package com.osa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/main/java/com/osa/features"},
		glue="com.osa.steps",
		tags= {"@smoke"},
		plugin = {"json:target/cucumber-reports/Cucumber.json","pretty","de.monochromata.cucumber.report.PrettyReports:target/cucumber","html:target/pretty-cucumber"}
		)
public class SmokeTest {

}
