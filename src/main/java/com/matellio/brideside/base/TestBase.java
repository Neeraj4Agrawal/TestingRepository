package com.matellio.brideside.base;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.matellio.brideside.util.BaseUtil;
import com.matellio.brideside.util.ReadResources;
import com.matellio.brideside.util.XlsReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private static Logger logger = Logger.getLogger(TestBase.class);

	private static ReadResources readResources;
	private static Map<String, String> readConfigData;
	private static Map<String, String> readEnvironmentUrls;
	// private static Map<String, String> readUserLoginCredentials;
	// private static Map<String, String> readDataBaseUrls;
	// private static Map<String, String> readDataBaseCredentials;

	private static String env;
	private static String userName;
	private static String password;
	private static String envUrl;
	private static String dbUrl;
	private static String dbUserName;
	private static String dbPassword;
	private static XlsReader datatable;
	private static TestBase instance;
	private static long timeout = PathConstants.defaultTimeout;
	private static long pollingFrequency = PathConstants.defaultPollingFrequency;
	private static String TEST_XLS_PATH=PathConstants.TEST_XLS_PATH;
	private static WebDriverWait webDriverWait;
	public static WebDriver webDriver;
	private int i = 1;

	
	
	/**
	 * to load excel file , this will be used to load the excel file to get the run mode for a test case 
	 */
	public static void loadExcelFiles()
	{
		datatable = new XlsReader(System.getProperty("user.dir") + TEST_XLS_PATH);
		datatable.setCellData("MyContactInfo", "FirstName", 2, "Gajendra");
		datatable.setCellData("MyContactInfo", "LastName", 2, "Rawat");
	}

	private TestBase() {
		readResources = new ReadResources();
		readConfigData = readResources.getValuesFromXml("Configuration.xml", "brideside");
		readEnvironmentUrls = readResources.getValuesFromXml("Configuration.xml", "environment_url");
		try {
			if (null == webDriver)
				if (System.getProperty("browser") == null || System.getProperty("browser").trim().isEmpty()) {
					webDriver = initializeWebDriver(readConfigData.get("browser"));
				} else {
					webDriver = initializeWebDriver(System.getProperty("browser").trim());
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webDriverWait = new WebDriverWait(webDriver, TimeUnit.SECONDS.toSeconds(timeout));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean isAlertPresent() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		try {
			getWebDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public static Alert moveToAlert() {
		logger.debug("Executing Test Step::" + new Object() {
		}.getClass().getEnclosingMethod().getName());

		return getWebDriver().switchTo().alert();
	}

	public static TestBase getInstance() {
		if (null == instance || getWebDriver() == null) {
			return new TestBase();
		} else {
			return instance;
		}
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

	public static void userLogin() {
		initializeGlobalVariables();
		BaseUtil baseUtil = new BaseUtil();
		webDriverWait = new WebDriverWait(webDriver, TimeUnit.MILLISECONDS.toSeconds(timeout));
		webDriver.get(envUrl);
		logger.info("The Url is Launched with the Value" + envUrl);
		baseUtil.explicitWait(3000);
		baseUtil.enterText(readConfigData.get("adminUserName_Locator"), userName);
		baseUtil.enterText(readConfigData.get("adminPassword_Locator"), password);
		baseUtil.clickAndWait(readConfigData.get("adminLoginbutton_Locator"));
		baseUtil.clickAndWait(readConfigData.get("logo"));
	}

	public static void initializeGlobalVariables() {
		getWebDriver().manage().deleteAllCookies();
		env = System.getProperty("env");
		if (env == null || env.trim().isEmpty()) {
			env = readConfigData.get("env");
		}

		envUrl = System.getProperty("url");
		if (envUrl == null || envUrl.trim().isEmpty()) {
			envUrl = readEnvironmentUrls.get(env);
		}

		String eol = System.getProperty("line.separator");
		logger.info("System will initialized with following values :" + eol + "Environment : " + env + eol
				+ "Environment URL : " + envUrl + eol + "Username : " + userName + eol + "Password : " + password + eol
				+ "Database URL : " + dbUrl + eol + "DataBase Username : " + dbUserName + eol + "Database Password : "
				+ dbPassword);
	}

	public static WebDriver initializeWebDriver(String browser) throws InterruptedException {
		String filePath = new File("").getAbsolutePath();
		String browserValue = browser.trim();
		char cforwardslash = (char) 47;
		char cbackslash = (char) 92;
		String basePath = filePath.replace(cbackslash, cforwardslash);
		logger.info(basePath);
		if (browserValue.equalsIgnoreCase("firefox")) {
			FirefoxProfile fxProfile = new FirefoxProfile();
			fxProfile.setPreference("browser.download.manager.showWhenStarting", false);
			fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text" + File.separator + "plain");
			fxProfile.setPreference("security.mixed_content.block_active_content", false);
			fxProfile.setPreference("security.mixed_content.block_display_content", true);
			fxProfile.setPreference("browser.download.folderList", 2);
			fxProfile.setPreference("browser.download.dir", basePath + "" + File.separator + "downloadDir");
			fxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"image" + File.separator + "jpg,text" + File.separator + "csv,text" + File.separator + "xml,text"
							+ File.separator + "plain,application" + File.separator + "xml,application" + File.separator
							+ "json," + "application" + File.separator + "vnd.ms-excel,application" + File.separator
							+ "octet-stream, application" + File.separator + "x-excel," + "application" + File.separator
							+ "x-msexcel,application" + File.separator + "excel,application" + File.separator + "pdf");
			webDriver = new FirefoxDriver();
			logger.info("Initializing firefox webDriver");
		} else if (browserValue.equalsIgnoreCase("chrome")) {
			WebDriverManager.getInstance(CHROME).setup();
			List<String> optionList = new ArrayList<String>();
			optionList.add("start-maximized");
			optionList.add("disable-infobars");
			optionList.add("--disable-extensions");
			optionList.add("--disable-dev-shm-usage"); 
			//optionList.add("--headless");
			optionList.add("--no-sandbox");
			optionList.add("--disable-dev-shm-usage");
			ChromeOptions options = new ChromeOptions();
			options.addArguments(optionList);
			webDriver = new ChromeDriver(options);
			//webDriver.manage().window().maximize();
			logger.info("Initializing linlinux_chrome webDriver");
		}
		return webDriver;
	}

	public DesiredCapabilities getFirefoxCapabilities() {
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		return dc;
	}

	public DesiredCapabilities getChromeCapabilities() {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		return dc;
	}

	public DesiredCapabilities getInternetExplorerCapabilities() {
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		return dc;
	}

	public static WebDriver getWebDriver() {
		return webDriver;
	}

	public static void setWebDriver(WebDriver webDriver) {
		TestBase.webDriver = webDriver;
	}

	public static ReadResources getReadResources() {
		return readResources;
	}

	public void setReadResources(ReadResources readResources) {
		TestBase.readResources = readResources;
	}

	public static Map<String, String> getReadConfigData() {
		return readConfigData;
	}

	public static WebDriverWait getWebDriverWait() {
		return webDriverWait;
	}

	public static void setWebDriverWait(WebDriverWait webDriverWait) {
		TestBase.webDriverWait = webDriverWait;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		TestBase.env = env;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		TestBase.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		TestBase.password = password;
	}

	public String getEnvUrl() {
		return envUrl;
	}

	public void setEnvUrl(String envUrl) {
		TestBase.envUrl = envUrl;
	}

	public static String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		TestBase.dbUrl = dbUrl;
	}

	public static String getDbUsername() {
		return dbUserName;
	}

	public void setDbUsername(String dbUserName) {
		TestBase.dbUserName = dbUserName;
	}

	public static String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		TestBase.dbPassword = dbPassword;
	}

	public static Map<String, String> getReadEnvironmentUrls() {
		return readEnvironmentUrls;
	}

	public static void getLoginPage() {
		webDriver.get(envUrl);
	}

	public static long getTimeout() {
		return timeout;
	}

	public static void setTimeout(long timeout) {
		TestBase.timeout = timeout;
	}

	public static long getPollingFrequency() {
		return pollingFrequency;
	}

	public static void setPollingFrequency(long pollingFrequency) {
		TestBase.pollingFrequency = pollingFrequency;
	}

	public static Logger getLogger() {
		return logger;
	}

}