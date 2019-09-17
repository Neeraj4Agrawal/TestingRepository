package com.matellio.brideside.runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"src/test/features/GiftPage.feature",

}, monochrome = true,
 //we use tag when we need to run specific method
		tags=("@Test219"),    

		strict = true,
		plugin = {"pretty",
				"html:target/cucumber-htmlreport",
				"rerun:target/rerun.txt",
				"json:target/cucumber.json"},

		glue = {
				"com.matellio.brideside.shop",
				"com.matellio.brideside.signup",
				"com.matellio.brideside.test",
				"com.matellio.brideside.company",
				"com.matellio.brideside.login",
				"com.matellio.brideside.gift",
			
		}

)
public class RunAllTest {

}