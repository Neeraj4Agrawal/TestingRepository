package com.matellio.brideside.test;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.matellio.brideside.base.TestBase;
import com.matellio.brideside.util.BaseUtil;
import com.matellio.brideside.util.XlsReader;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PageTest {
	
	private TestPage testPage;
	private XlsReader datatable;
	private Map<String, String> TestPageObjectRepo1;
	private Logger logger = Logger.getLogger(TestPage.class);
	BaseUtil btl =  new BaseUtil();


// private Map<String, String> loginPageObjectText;

	//Phone Number is invalid or already taken.
//Email Already Existing
//
	@Given("^Initialize resources in the beginning of each scenario for TestPage$")
	public void Initialize_Resources() throws IOException, InterruptedException {
		TestBase.getInstance();
		TestBase.initializeGlobalVariables();
		TestBase.loadExcelFiles();
		TestPageObjectRepo1 = TestBase.getReadResources().getValuesFromXml("LoginPage.xml", "loginObjectRepository");
// loginPageObjectText = TestBase.getReadResources().getValuesFromXml(
// "LoginPage.xml", "loginObjectText");
		this.testPage = new TestPage();
		String envUrl = System.getProperty("url");
		if (envUrl == null || envUrl.trim().isEmpty()) {
			envUrl = TestBase.getReadEnvironmentUrls().get(TestBase.getReadConfigData().get("env"));
		}
		TestBase.getWebDriver().get(envUrl);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		TestBase.getWebDriverWait().until(expectation);
	}
	
	@When("^user on sign in page and check$")
	public void user_on_sign_in_page() throws Throwable {
		String message="Url not opened..";
		
		
		testPage.assertElementDisplayed(TestPageObjectRepo1.get("loginButton"), message);
	}
	
	@After("@LoginPage")
	public void afterClass(Scenario scenario) {
		testPage.closeResources(scenario);
	}

}
