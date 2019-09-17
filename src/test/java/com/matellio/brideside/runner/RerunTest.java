package com.matellio.brideside.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@target/rerun.txt"},

plugin = { "pretty", 
		"html:target/cucumber-rerun-htmlreport",
		"json:target/cucumber.json",
		"rerun:target/rerun.txt" },

glue = {"com.matellio.brideside.shop",
		"com.matellio.brideside.signup",
		"com.matellio.brideside.login",})

public class RerunTest {
}
