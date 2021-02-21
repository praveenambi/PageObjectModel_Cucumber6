package com.autoe2e.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@target/failedrerun.txt"},
		glue = {"stepdefinitions","hooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-reports-thread/",
				"rerun:target/failedrerun.txt"},
		monochrome = true
		
		)
public class FailedScenarioRerun {

}
