package com.matellio.brideside.util;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.matellio.brideside.base.TestBase;

import cucumber.api.Scenario;

public class BaseUtil {
	public static Logger logger = Logger.getLogger(BaseUtil.class);

	public List<WebElement> products;
	public List<WebElement> elements;

	public void checkCheckBox(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		if (!element.isSelected()) {
			element.click();
			logger.info("The Given Element is clicked");
		}
	}

	public void scrollTab(WebDriver webDriver, String objLocator, int milliSec) {
		explicitWait(milliSec);
		JavascriptExecutor je = (JavascriptExecutor) webDriver;
		WebElement element = webDriver.findElement(getLocator(objLocator));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		explicitWait(milliSec);
	}

	// santosh
	public void scrollPage(WebDriver webDriver) {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	// Santosh
	public void scrollPageUptoBottom(WebDriver webDriver) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// Santosh
	public void scrollPageUp(WebDriver webDriver) {
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public void unCheckCheckBox(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		if (element.isSelected()) {
			element.click();
			logger.info("The Given Element is clicked");
		}
	}

	public void defaultStateCheckBox(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		if (element.isSelected()) {
			logger.info("The Given Element is checked");
		} else {
			logger.info("The Given Element is not checked");
		}
	}

	public void checkCheckBox(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		if (!element.isSelected()) {
			element.click();
			logger.info("The Given Element is clicked");
		}
	}

	public void click(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		element.click();
		logger.info("The Given Element is clicked");
	}

	public void clickAndWait(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		WebElement element = waitAndgetElement(objLocator);
		element.click();
		logger.info("After waiting, the Given Element is clicked");
	}

	public void clickLinkText(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = waitAndgetElement(objLocator);
		element.click();
		logger.info("After waiting, the Given Element is clicked");
	}

	public void click(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		element.click();
		logger.info("The Given Element is clicked");
	}

	public void clickElement(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		element.sendKeys(Keys.ENTER);
		logger.info("The Given Element is clicked");
	}

	// By Santosh
	public void ClickEnterKey(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		element.sendKeys(Keys.ENTER);
		logger.info("The Given Element is clicked");
	}

	// By Santosh
	public void NavigateBackToPreviousPage() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		TestBase.getWebDriver().navigate().back();
	}

	public void enterText(String objLocator, String text) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		logger.info("The data to be filled in the Textbox is " + text);
		element.clear();
		element.sendKeys(text);
		logger.info("The data is entered to the Text Field");
	}

	public void enterText(String objLocator, int index, String text) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		logger.info("The data to be filled in the Textbox is " + text);
		element.clear();
		element.sendKeys(text);
		logger.info("The data is entered to the Text Field");
	}

	public String getElementText(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		logger.info("Element is having the text... " + element.getText());
		return element.getText();

	}

	public String getElementText(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		logger.info("Element is having the text... " + element.getText());
		return element.getText();
	}

	// Santosh
	public void getElementByIndex(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		logger.info("Element is having the text... " + element.getText());

	}

	public void selectDropDownByValue(String objLocator, String value) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		Select select = new Select(getElementAfterLoaded(objLocator));
		List<WebElement> list = select.getOptions();
		boolean flg = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().trim().equalsIgnoreCase(value)) {
				logger.info(list.get(i).getText() + "=" + value);
				select.selectByIndex(i);
				explicitWait(4000);
				flg = true;
				break;
			}
		}

		if (!flg) {
			Assert.fail("Fail to select the given value: " + value + " from the dropdown");
		}
	}

	public void selectTabByIndex(int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		ArrayList<String> tabs = new ArrayList<String>(TestBase.getWebDriver().getWindowHandles());
		TestBase.getWebDriver().switchTo().window(tabs.get(index));
	}

	public int getSelectedTabIndex() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		ArrayList<String> tabs = new ArrayList<String>(TestBase.getWebDriver().getWindowHandles());
		return tabs.size();
	}

	public void selectDropDownByIndex(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		Select select = new Select(getElementAfterLoaded(objLocator));
		select.selectByIndex(index);
	}

	public List<WebElement> getDropDownValues(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		click(objLocator);
		Select select = new Select(getElementAfterLoaded(objLocator));
		return select.getOptions();
	}

	public void selectMultipelValues(String objLocator, String multipleVals) {
		String multipleSel[] = multipleVals.split(",");
		for (String valueToBeSelected : multipleSel) {
			Select select = new Select(getElementAfterLoaded(objLocator));
			select.selectByVisibleText(valueToBeSelected);
			WebElement element = getElementAfterLoaded(objLocator);
			element.sendKeys(Keys.CONTROL);
		}
	}

	public List<String> getDropDownText(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		Select select = new Select(getElementAfterLoaded(objLocator));
		List<String> dropDownText = new ArrayList<>();
		for (WebElement element : select.getOptions()) {
			dropDownText.add(element.getText());
		}
		return dropDownText;
	}

	public String getSelectedDropDownValues(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		Select select = new Select(getElementAfterLoaded(objLocator));
		logger.info("Selected option is the drop down is : " + select.getFirstSelectedOption().getText());
		return select.getFirstSelectedOption().getText();
	}

	public String getDownloadsPath() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		String userDir = System.getProperty("user.home");
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String path = userDir.replace(cbackslash, cforwardslash);
		logger.info("The download path is : " + path + "/Downloads/");
		return path + "/Downloads/";
	}

	public void uploadFile(String objLocator, String filePath) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		element.sendKeys(filePath);
	}

	public boolean verifyElementDisplayed(String objLocator) {
		try {
			logger.debug("Executing Test Step::" + new Object() {
			}.getClass().getEnclosingMethod().getName());
			logger.debug("Waiting for element to be clickable. Timeout:" + TestBase.getTimeout());
			WebElement element = getElementAfterLoaded(objLocator);
			return element.isDisplayed() ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyElementDisplayed(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		return element.isDisplayed() ? true : false;
	}

	public boolean verifyElementEnabled(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		return element.isEnabled() ? true : false;
	}

	public boolean verifyElementEnabled(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		return element.isEnabled() ? true : false;
	}

	public boolean verifyElementSelected(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		return element.isSelected() ? true : false;
	}

	public boolean verifyElementSelected(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getMultipleElementsAfterLoaded(objLocator).get(index);
		return element.isSelected() ? true : false;
	}

	public String getElementAttribute(String objLocator, String attribute) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		logger.info("The value of attribute [" + attribute + "] is : " + element.getAttribute(attribute));
		return element.getAttribute(attribute);
	}

	public void explicitWait(long milliSec) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		try {
			logger.info("Waiting for [" + milliSec + "] millisec before the next step.");
			Thread.sleep(milliSec);
		} catch (Exception e) {
			getLogger().error("Error while doing explicit wait : " + e.getMessage());
		}
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		BaseUtil.logger = logger;
	}

	public void mouseOver(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		element.click();

		Actions action = new Actions(TestBase.getWebDriver());
		// action.moveToElement(element).build().perform();
		action.moveToElement(element).moveToElement(TestBase.getWebDriver().findElement(By.xpath(objLocator))).click()
				.build().perform();
	}
	
	public boolean verifyPresenceOfText(String objLocator, String text) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement elementLocator = getElementAfterLoaded(objLocator);
		logger.info("The text present in the element is : " + elementLocator.getText());
		if (elementLocator.getText().contains(getElementText(objLocator))) {
			return true;
		}
		return false;
	}

	public int elementsSize(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		elements = getMultipleElementsAfterLoaded(objLocator);
		logger.info("Size of elements" + elements.size());
		return elements.size();
	}

	// santosh
	@SuppressWarnings("null")
	public String AllelementsNames(String objLocator) {
		String[] menus = null;
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		elements = getMultipleElementsAfterLoaded(objLocator);
		logger.info("Size of elements" + elements.size());
			for (WebElement we : elements) {
				for (int i = 0; i < menus.length; i++) {
					if (we.getText().equals(menus[i])){

				}

			}
		}

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i) != null) {
				System.out.println(elements.get(i).getText());
			}
		}
		return objLocator;

	}

	public boolean verifyCheckBoxIsSelected(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		if (element.isSelected()) {
			logger.info("Given checkbox is selected");
			return true;
		}
		return false;
	}

	public String getMouseOverText(String objLocator, String textObjectLocator) throws InterruptedException {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		Actions actions = new Actions(TestBase.getWebDriver());
		actions.clickAndHold(element).build().perform();
		return getElementText(textObjectLocator);
	}

	public String getBasePath() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		String filePath = new File("").getAbsolutePath();
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String basePath = filePath.replace(cbackslash, cforwardslash);
		logger.info("the base path is : " + basePath);
		return basePath;
	}

	public WebElement getElementAfterLoaded(final String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		By byValue = getLocator(objLocator);
		isElementLoaded(byValue);
		return TestBase.getWebDriver().findElement(byValue);
	}

//By santosh
	public WebElement getElement(final String objLocator) {
		By byValue = getLocator(objLocator);
		isElementLoaded(byValue);
		return TestBase.getWebDriver().findElement(byValue);
	}

	public WebElement waitAndgetElement(final String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		By byValue = getLocator(objLocator);
		isElementClickable(byValue);
		return TestBase.getWebDriver().findElement(byValue);
	}

	public List<WebElement> getMultipleElementsAfterLoaded(final String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		By byValue = getLocator(objLocator);
		isElementLoaded(byValue);
		return TestBase.getWebDriver().findElements(byValue);
	}

	public boolean isElementLoaded(final By byValue) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		logger.debug("Waiting for element to be loaded. Timeout:" + TestBase.getTimeout());
		Wait<WebDriver> gWait = new FluentWait<WebDriver>(TestBase.getWebDriver())
				.withTimeout(Duration.ofSeconds(TestBase.getTimeout())).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				WebElement element = d.findElement(byValue);
				return element.isDisplayed();
			}
		};
		return gWait.until(condition);
	}

	public boolean isElementClickable(By byValue) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		try {
			explicitWait(1000);
			logger.debug("Waiting for element to be clickable. Timeout:" + TestBase.getTimeout());
			return TestBase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(byValue)).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementClickable(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		try {
			explicitWait(1000);
			logger.debug("Waiting for element to be clickable. Timeout:" + TestBase.getTimeout());
			WebElement element = getElementAfterLoaded(objLocator);
			return TestBase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementEnabled(final By byValue) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

//		Wait<WebDriver> wait = new FluentWait<WebDriver>(TestBase.getWebDriver())
//				.withTimeout(TestBase.getTimeout(), TimeUnit.MILLISECONDS)
//				.pollingEvery(TestBase.getPollingFrequency(), TimeUnit.MILLISECONDS)
//				.ignoring(NoSuchElementException.class);
		Wait<WebDriver> gWait = new FluentWait<WebDriver>(TestBase.getWebDriver())
				.withTimeout(Duration.ofSeconds(TestBase.getTimeout())).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				WebElement element = d.findElement(byValue);
				return element.isEnabled();
			}
		};
		return gWait.until(condition);
	}

	public void waitForPageLoading(String element) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		String[] str = element.split("===");
		TestBase.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.xpath(str[1])));
	}

	public void overrideTimeout(String timeout) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		if (!(null == timeout || timeout.equals(""))) {
			TestBase.setTimeout(Long.parseLong(timeout));
		}
	}

	public void overridePollingfrequency(String pollingFrequency) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		if (!(null == pollingFrequency || pollingFrequency.equals(""))) {
			TestBase.setPollingFrequency(Long.parseLong(pollingFrequency));
		}
	}

	public By getLocator(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		String[] str = objLocator.split("===");
		logger.info("Object Identifier " + str[0] + "\t Object Identifier Value " + str[1]);
		By byValue = null;
		switch (str[0].toUpperCase()) {
		case "ID":
			byValue = By.id(str[1]);
			break;
		case "XPATH":
			byValue = By.xpath(str[1]);
			break;
		case "NAME":
			byValue = By.name(str[1]);
			break;
		case "LINKTEXT":
			byValue = By.linkText(str[1]);
			break;
		case "CSS":
			byValue = By.cssSelector(str[1]);
			break;
		case "CLASSNAME":
			byValue = By.className(str[1]);
			break;
		case "TAGNAME":
			byValue = By.tagName(str[1]);
			break;
		}
		return byValue;
	}

	public List<String> getMultipleElementTextAfterLoaded(final String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		By byValue = getLocator(objLocator);
		isElementLoaded(byValue);
		List<WebElement> elements = TestBase.getWebDriver().findElements(byValue);
		List<String> result = new ArrayList<>();
		for (WebElement element : elements) {
			result.add(element.getText());
		}
		return result;
	}

	public List<String> getMultipleElementColorAfterLoaded(final String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		By byValue = getLocator(objLocator);
		isElementLoaded(byValue);
		List<WebElement> elements = TestBase.getWebDriver().findElements(byValue);
		List<String> result = new ArrayList<>();
		for (WebElement element : elements) {
			result.add(element.getText());
		}
		return result;
	}

	public void waitForSpinner() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		explicitWait(1000);
		long iCount = 0;
		logger.debug("Waiting for page spinner...");
		while (iCount < TestBase.getTimeout()) {
			if (instantElementCheck("Display", By.xpath("//*[@id='pageSpinner']/div"))) {
				try {
					Thread.sleep(TestBase.getPollingFrequency());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
			iCount += TestBase.getPollingFrequency();
		}
		explicitWait(1000);
	}

	public boolean clickOperationOnTenantPage(String sButtonName, Map<String, String> ObjectRepo) {
		try {
			String label;
			switch (sButtonName.toUpperCase()) {
			case "ADD TENANT":
				clickAndWait(ObjectRepo.get("addTenantButton"));
				return true;
			case "ADD SITE":
				clickAndWait(ObjectRepo.get("addSiteButton"));
				explicitWait(3000);
				return true;
			case "ADD ENDPOINT":
				clickAndWait(ObjectRepo.get("addEndpointButton"));
				return true;
			case "SAVE:ENDPOINT":
				clickAndWait(ObjectRepo.get("addSiteSaveButton"));
				return true;
			case "SAVE":
				clickAndWait(ObjectRepo.get("addTenantPopupSaveButton"));
				explicitWait(1000);
				return true;
			case "CANCEL":
				clickAndWait(ObjectRepo.get("addTenantPopupCancelButton"));
				return true;
			case "SEARCH":
				clickAndWait(ObjectRepo.get("tenantSearchButton"));
				return true;
			case "DELETE":
				clickAndWait(ObjectRepo.get("tenantDeleteButton"));
				return true;
			case "CANCEL_DELETE":
				clickAndWait(ObjectRepo.get("DeleteTenantCancelConfirmationButton"));
				return true;
			case "X":
				clickAndWait(ObjectRepo.get("addTenantPopupXButton"));
				return true;
			case "OK_DELETE":
				clickAndWait(ObjectRepo.get("DeleteTenantOkConfirmationButton"));
				return true;
			case "HIDE INACTIVE:UNCHECKED":
				label = getElementText(ObjectRepo.get("hideInactiveCheckBox"));
				if (label.equals(sButtonName)) {
					Assert.assertTrue("The label text is given as =" + label, true);
				}
				unCheckCheckBox(ObjectRepo.get("hideInactiveCheckBox"));
				return true;
			case "HIDE INACTIVE:CHECKED":
				label = getElementText(ObjectRepo.get("hideInactiveLabel"));
				if (label.equals(sButtonName)) {
					Assert.assertTrue("The label text is given as =" + label, true);
				}
				checkCheckBox(ObjectRepo.get("hideInactiveCheckBox"));
				return true;
			case "CREATE DATAFIX":
				clickAndWait(ObjectRepo.get("createDataFixBtn"));
				waitForSpinner();
				return true;
			case "UPLOAD:TEMPLATE":
				clickAndWait(ObjectRepo.get("uploadTemplateBtn"));
				waitForSpinner();
				return true;
			default:
				logger.error("Switch Case[" + sButtonName + "] is not matched in class[" + getClass().getName()
						+ "] , Method[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
				return false;
			}
		} catch (Exception e) {
			logger.error("Failed to click on button :" + sButtonName + " , detail message: " + e.getMessage());
			return false;
		}
	}

	public void waitForSpinner(int milliSecond) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		explicitWait(milliSecond);
		long iCount = 0;
		logger.debug("Waiting for page spinner...");
		while (iCount < TestBase.getTimeout()) {
			if (instantElementCheck("Display", By.xpath("//*[@id='pageSpinner']/div"))) {
				try {
					Thread.sleep(TestBase.getPollingFrequency());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				break;
			}
			iCount += TestBase.getPollingFrequency();
		}
		explicitWait(milliSecond);
	}

	public boolean instantElementCheck(String type, By byValue) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		try {
			WebElement element = TestBase.getWebDriver().findElement(byValue);
			if (type.equalsIgnoreCase("Display")) {
				return element.isDisplayed();
			} else if (type.equalsIgnoreCase("Enable")) {
				return element.isEnabled();
			} else if (type.equalsIgnoreCase("Select")) {
				return element.isSelected();
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean instantElementCheck(String type, String locator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		By byValue = getLocator(locator);
		return instantElementCheck(type, byValue);
	}

	public void takeScreenshots(Scenario scenario, WebDriver webDriver) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		if (scenario.isFailed() && webDriver != null) {
			logger.error("Scenario " + scenario.getName() + " is failed");
			final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
	}

	public void takeScreenshots(String sFileName) throws IOException {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		if (TestBase.getWebDriver() != null) {
			File scrFile = ((TakesScreenshot) TestBase.getWebDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("./target/" + sFileName + ".png"));
		}
	}

	public void setElementAttribute(String objLocator, String value) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
	}

	public boolean verifyElementIsReadOnly(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		return element.getAttribute("readonly").equals("true") ? true : false;
	}

	public void instantClick(String objLocator) throws ElementNotFoundException, ElementNotVisibleException {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = TestBase.getWebDriver().findElement(getLocator(objLocator));
		element.click();
		logger.info("The given element is clicked instantly without wait");
	}

	// if (str1.compareTo(str2) < 0) {
	// System.out.println("str1 is greater than str2");
	// }
	public boolean isSorted(String sortingType, List<String> list) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		boolean sorted = true;
		if (sortingType.equalsIgnoreCase("Ascending")) {
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i - 1).compareTo(list.get(i)) != 0) {
					if (list.get(i - 1).compareTo(list.get(i)) < 0) {
						sorted = false;
					}
				}
			}
		} else if (sortingType.equalsIgnoreCase("Descending")) {
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i - 1).compareTo(list.get(i)) != 0) {
					if (list.get(i - 1).compareTo(list.get(i)) > 0) {
						sorted = false;
					}
				}
			}
		}
		return sorted;
	}

	public boolean checkIfClickable(String objLocator) throws InterruptedException {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		int i = 0;
		boolean flg = false;
		while (i < 2) {
			try {
				click(objLocator);
				flg = true;
				break;
			} catch (Exception e) {
				logger.error("element not clickable");
				Thread.sleep(2000);
			}
			i++;
		}
		return flg;
	}

	public void switchToNewBrowserTab(int tabNumber) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		ArrayList<String> newTab = new ArrayList<String>(TestBase.getWebDriver().getWindowHandles());
		String oldTab = TestBase.getWebDriver().getWindowHandle();
		newTab.remove(oldTab);
		TestBase.getWebDriver().switchTo().window(newTab.get(tabNumber));
		logger.info("controls are switched to new browser tab no: " + tabNumber);
	}

	public void closeResources(Scenario scenario) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		takeScreenshots(scenario, TestBase.getWebDriver());
		if (null != TestBase.getWebDriver()) {
			TestBase.getWebDriver().quit();
			TestBase.setWebDriver(null);
		}
	}

	public void selectComboBoxDropDownByValue(String objLocator, String value) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		List<String> multipleElementTextAfterLoaded = getMultipleElementTextAfterLoaded(objLocator);
		List<WebElement> multipleElementsAfterLoaded = getMultipleElementsAfterLoaded(objLocator);
		int i = 0;
		boolean flg = false;
		for (String text : multipleElementTextAfterLoaded) {
			if (text.equalsIgnoreCase(value)) {
				multipleElementsAfterLoaded.get(i).click();
				flg = true;
				break;
			}
			i++;
		}

		if (!flg) {
			Assert.fail("Fail to select the given value: " + value + " from the combo box dropdown");
		}
	}

	public String getCurrentDate() throws ParseException {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int day = localDate.getDayOfMonth();
		String currentDate = day + "/" + month + "/" + year;
		return currentDate;
	}

	public String getCurrentDDMMYY() {
		Date myDate = new Date();
		System.out.println(myDate);
		String currentDate = (new SimpleDateFormat("dd/MM/yy").format(myDate));
		System.out.println(myDate);
		// String
		// currentDate=myDate.getDay()+"/"+myDate.getMonth()+"/"+myDate.getYear();
		return currentDate;
	}

	public void selectComboBoxDropDownByValueNew(String objLocator, String value) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		click(objLocator);
		List<String> multipleElementTextAfterLoaded = getMultipleElementTextAfterLoaded(objLocator);
		List<WebElement> multipleElementsAfterLoaded = getMultipleElementsAfterLoaded(objLocator);
		int i = 1;
		boolean flg = false;
		for (String text : multipleElementTextAfterLoaded) {
			String[] text2 = text.split("logger.debug(\"Executing Test Step::\" + new Object() {\n"
					+ "			}.getClass().getEnclosingMethod().getName());\n");
			text = text2[i].trim();
			if (text.equalsIgnoreCase(value)) {
				multipleElementsAfterLoaded.get(i).click();
				flg = true;
				break;
			}
			i++;
		}

		if (!flg) {
			Assert.fail("Fail to select the given value: " + value + " from the combo box dropdown");
		}
	}

	public void selectComboBoxDropDownByIndex(String objLocator, int index) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		getMultipleElementsAfterLoaded(objLocator).get(index).click();
	}

	/**
	 * 
	 * @author grawat
	 */
	public void clickAndWaitNew(String objLocator) {

		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		List<WebElement> element = TestBase.getWebDriver().findElements(By.xpath("//*[@id='saveBtn']"));
		Iterator<WebElement> itr = element.iterator();
		while (itr.hasNext()) {

			WebElement temp = itr.next();
			if (temp.getText().equals("Save")) {
				temp.click();
			}

		}

		logger.info("After waiting, the Given Element is clicked");
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch

	}

	// By Santosh
	public boolean handleAlert(WebDriver driver) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			System.out.println("Accepted the alert successfully.");
		} catch (NoAlertPresentException e) {
			System.err.println("Error came while waiting for the alert popup. " + e.getMessage());
			return false;
		}
		return false;
	}

	public String handleAlertWithMessage(WebDriver driver) {
		String message;
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			message = alert.getText();
			alert.accept();
			System.out.println("Accepted the alert successfully.");
		} catch (NoAlertPresentException e) {
			System.err.println("Error came while waiting for the alert popup. " + e.getMessage());
			return e.getMessage();
		}
		return message;
	}

	public void confirmDialog(WebDriver driver) {
		if (driver instanceof PhantomJSDriver) {
			PhantomJSDriver phantom = (PhantomJSDriver) driver;
			phantom.executeScript("window.alert = function(){}");
			phantom.executeScript("window.confirm = function(){return true;}");
			System.out.println("Alert Shown: manager by phantom");
		} else if (driver instanceof WebDriver) {
			if (isAlertPresent(driver) == true) {
				driver.switchTo().alert().accept();
				System.out.println("Alert Shown: manager by chromedriver");
			}
		} else {
			System.out.println("No Alert Shown");
		}
	}

	public int getRandomNumber() {
		// double x = (Math.random() * ((987654321 -123456789 ) + 1)) + 100000000;
		double x = (Math.random() * ((9876543 - 1234567) + 1)) + 1000000;
		return (int) x;
	}

	public int getRandomPhoneNumber() {
		double x = (Math.random() * ((987654321 - 123456789) + 1)) + 100000000;
		return (int) x;
	}

	// ===============================Created by
	// santosh=============================
	public void mouseOverWithoutClick(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());
		WebElement element = getElementAfterLoaded(objLocator);
		Actions action = new Actions(TestBase.getWebDriver());
		action.moveToElement(element).build().perform();
	}

	public String getColor(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement colors = getElementAfterLoaded(objLocator);
		logger.info("The data to be filled in the Textbox is " + colors);
		// color.getCssValue("background-color");
		return colors.getCssValue("color");
	}

	public void enterTextWithRandomNumber(String objLocator, String text) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		logger.info("The data to be filled in the Textbox is " + text);
		element.clear();
		Random ran = new Random();
		int randon = ran.nextInt(10000);
		String s = String.valueOf(randon);
		element.sendKeys(s + text);
		logger.info("The data is entered to the Text Field");
	}

	public String getCurrentUrl() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		String currentUrl = TestBase.getWebDriver().getCurrentUrl();
		return currentUrl;

	}

	// Santosh
	public void clearTextField(String objLocator) {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		WebElement element = getElementAfterLoaded(objLocator);
		element.clear();
	}

}