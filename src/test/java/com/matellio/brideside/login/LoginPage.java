package com.matellio.brideside.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.jetty.util.URI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.matellio.brideside.base.TestBase;
import com.matellio.brideside.util.BaseUtil;


public class LoginPage extends BaseUtil {
	
	
    BaseUtil btl =  new BaseUtil();
	private Logger logger = Logger.getLogger(LoginPage.class);
	public boolean isElementDisplayed(String objLocator) {
		return verifyElementDisplayed(objLocator);
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

	public void enterTextInTextBox(String objLocator, String testdata) {
		enterText(objLocator, testdata);
	}

	

	public void getthetextofelement(String objLocator) {
		getElementText(objLocator);
	}
	
	public void clickElement(String objLocator) {
		click(objLocator);
	}

	public void explicitWait(long milliSec) {
		try {
			Thread.sleep(milliSec);
		} catch (Exception e) {
			logger.error("Error while doing explicit wait : " + e.getMessage());
		}
	}

	
	
	
	public void verifyUrlLastPath(String lastPath) {
		String uri=getCurrentUrl();
		String[] segments = uri.split("/");
		String idStr = segments[segments.length-1];
		Assert.assertEquals(idStr, lastPath);
		
	}
	
	public void assertColorMatched(String objLocator,String expected, String message) {	
		for(int i=0;i<elementsSize(objLocator);i++) {
			Assert.assertTrue(message, false);
			
		}		
	}
	public void assertElementSize(int expected, int actual) {
		Assert.assertEquals(expected, actual);
	}
	
	public void AssertCurrentUrl(String key) {
		
		URI uri = new URI(getCurrentUrl());
		String path = uri.getPath();
		String idStr = path.substring(path.lastIndexOf('/') + 1);
		//int id = Integer.parseInt(idStr);
		
		//Assert.assertTrue("key not found in url", getCurrentUrl().contentEquals(key));
		Assert.assertTrue(idStr.contains(key));
	}
	
	public void AssertCurrentUrlForQueryParam(String key) {
		String cururl=getCurrentUrl();
		System.out.println(cururl);
		Assert.assertTrue(getCurrentUrl().contains(key));
	}
	
	public void AssertTextContains(String objLocator,String key) {
		
	Assert.assertTrue("Color not found in url", objLocator.contains(key));
	}
	
	public void AssertInteger(int expected, int actual) {
		Assert.assertEquals(expected, actual);
	}
	
	public void assertColorMatch(String expectedColor, String actualColor) {
		Assert.assertEquals(expectedColor, actualColor);
	}
	
	public void assertTextMatch(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}
	public String getAlertText(WebDriver webdriver) {
		String alertText=webdriver.switchTo().alert().getText();
		System.out.println(alertText);
		
		return alertText;
	}
	
	
	public void getElementColor(String objLocator) {
		getColor(objLocator);
		
	}
	
	
	
	public void verifyColor(List<WebElement> productList, String color) {
		for (WebElement element : productList) {
			System.out.println("Actual Color: "+element.getCssValue("color"));
			System.out.println("Expected Color: "+color);
			Assert.assertTrue(element+"Colcor Not Mach", element.getCssValue("color").equals(color));
		}
		
	}
	
	public void findColorNames(List<WebElement> colorList) {
		for (WebElement element : colorList) {
			System.out.println("Color names are: "+element.getCssValue("color"));
			
		}
		
	}

	public void zoomIn() throws AWTException {
		 Robot robot = new Robot();
		 System.out.println("About to zoom in");
		 for (int i = 0; i < 3; i++) { 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_ADD);
		 }
	}
	public void AssertSelectedColorInUrl(String color) {
			String currenturl=getCurrentUrl();
		Assert.assertTrue("Color not found in url", currenturl.contains(color));
		
	}
	
	public void VerifySelectedElementClass(String ElementClass) {
		
			Assert.assertTrue(ElementClass.contains("active"));
	}

	public void AssertQueryParam(String queryParam) {
		
		
	}

	public void VerifyTextNotContain(String objLocator, String string) {
		
			Assert.assertNotEquals(objLocator, string);
	}
	public String getBrowserTitle() {
		String title=TestBase.getWebDriver().getTitle();
		System.out.println("Browser Title: "+title);
		return title;
		
	}

	
	
	
}
