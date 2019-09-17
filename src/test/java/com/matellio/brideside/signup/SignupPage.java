package com.matellio.brideside.signup;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.matellio.brideside.login.LoginPage;
import com.matellio.brideside.util.BaseUtil;

import cucumber.api.java.en.Then;

public class SignupPage extends BaseUtil {
	
	
    BaseUtil btl =  new BaseUtil();
	private Logger logger = Logger.getLogger(SignupPage.class);
	
	public boolean isElementDisplayed(String objLocator) {
		return verifyElementDisplayed(objLocator);
	}

	public void enterTextInTextBox(String objLocator, String testdata) {
		enterText(objLocator, testdata);
	}
	
	public void assertElementDisplayed(String objLocator, String message) {
		try {
			Assert.assertTrue(message, verifyElementDisplayed(objLocator));
		} catch (NoSuchElementException ex) {
			Assert.fail(message + " as element not available : " + ex.getMessage());
		} catch (ElementNotFoundException ex) {
			Assert.fail(message + " as element not available : " + ex.getMessage());
		} catch (NullPointerException ex) {
			Assert.fail(message + " due to some error : " + ex.getMessage());
		}
	}

	
	
	public void assertElementDisplayeds(String objLocator, String message) {
		try {
			Assert.assertEquals(message, btl.getElementText(objLocator));
		} catch (NoSuchElementException ex) {
			Assert.fail(message + " as element not available : " + ex.getMessage());
		} catch (ElementNotFoundException ex) {
			Assert.fail(message + " as element not available : " + ex.getMessage());
		} catch (NullPointerException ex) {
			Assert.fail(message + " due to some error : " + ex.getMessage());
		}
	}
	
	public void getthetextofelement(String objLocator) {
		getElementText(objLocator);
	}
	
	public void assertTextMatch(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}

	public void assertTextMatchwithMessage(String expected, String actual) {
		Assert.assertEquals("Alert message is not showing or incorrect message showing",expected, actual);
	}
	
	

	public void enterTextInTextBoxes(String objLocator, String testdata) {
		enterText(objLocator, testdata);
	}

	
	
	public void continuebutton_color(String objLocator)
	{
		String color =btl.getColor(objLocator);
		System.out.print("Color of element is    "+color);
	}
	
	
	
	
	
}
