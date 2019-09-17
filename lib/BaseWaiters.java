package com.codexa.util;
/*package com.gridpoint.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gridpoint.automation.constants.PathConstants;

*//***
 * 
 * @author Rishi Singhal
 *
 *//*

public class BaseWaiters {

	private static Logger logger = Logger.getLogger(BaseWaiters.class);

	private WebDriver webDriver;
	private WebDriverWait webDriverWait;

	private long timeout = PathConstants.defaultTimeout;
	private long pollingFrequency = PathConstants.defaultPollingFrequency;

	private int i = 1;

	public BaseWaiters(WebDriver driver, WebDriverWait driverWait) {
		this.webDriver = driver;
		this.webDriverWait = driverWait;
	}

	public boolean waitForElementPresentVisible(By locator) {
		boolean flag = false;
		int poolFlag = 10;
		try {
			while (flag == false && this.i <= poolFlag) {
				logger.info("Inside While Loop" + i);
				if (webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()) {
					logger.info("The Element is Found on the Page");
					flag = true;
					break;
				}
				this.i = 1;
				break;
			}
		} catch (Exception e) {
			logger.info("In the Catch Block");
			i = i + 1;
			logger.info("The Control to Catch block--" + i);
			if (i <= poolFlag) {
				waitForElementPresentVisible(locator);
			} else {
				return flag;
			}
		}
		return flag;
	}

	public boolean waitForElementEnabled(By locator) {
		boolean flag = false;
		int poolFlag = 10;
		try {
			while (flag == false && this.i <= poolFlag) {
				logger.info("Inside While Loop" + i);
				if (webDriverWait.until(ExpectedConditions.elementToBeClickable(locator)).isEnabled()) {
					logger.info("The Element is Found on the Page");
					flag = true;
					break;
				}
				this.i = 1;
				break;
			}
		} catch (Exception e) {
			logger.info("In the Catch Block");
			i = i + 1;
			logger.info("The Control to Catch block--" + i);
			if (i <= poolFlag) {
				waitForElementEnabled(locator);
			} else {
				return flag;
			}
		}
		return flag;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriverWait getWebDriverWait() {
		return webDriverWait;
	}

	public void setWebDriverWait(WebDriverWait webDriverWait) {
		this.webDriverWait = webDriverWait;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public long getPollingFrequency() {
		return pollingFrequency;
	}

	public void setPollingFrequency(long pollingFrequency) {
		this.pollingFrequency = pollingFrequency;
	}

	public static Logger getLogger() {
		return logger;
	}
}
*/