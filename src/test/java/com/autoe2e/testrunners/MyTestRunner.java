package com.autoe2e.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/java/features"},
		glue = {"stepdefinitions","hooks"},
		plugin = {"pretty"}
		
		)

public class MyTestRunner {

}
