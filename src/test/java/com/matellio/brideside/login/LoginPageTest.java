package com.matellio.brideside.login;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.matellio.brideside.base.TestBase;
import com.matellio.brideside.util.BaseUtil;
import com.matellio.brideside.util.XlsReader;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageTest {
	private LoginPage loginPage;
	private XlsReader datatable;
	private Map<String, String> loginPageObjectRepo;
	private Logger logger = Logger.getLogger(LoginPage.class);
	BaseUtil btl =  new BaseUtil();


// private Map<String, String> loginPageObjectText;

	//Phone Number is invalid or already taken.
//Email Already Existing
//
	@Given("^Initialize resources in the beginning of each scenario for Login$")
	public void Initialize_Resources() throws IOException, InterruptedException {
		TestBase.getInstance();
		TestBase.initializeGlobalVariables();
		TestBase.loadExcelFiles();
		loginPageObjectRepo = TestBase.getReadResources().getValuesFromXml("LoginPage.xml", "loginObjectRepository");
// loginPageObjectText = TestBase.getReadResources().getValuesFromXml(
// "LoginPage.xml", "loginObjectText");
		this.loginPage = new LoginPage();
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

	@Then("^verify the availability of username, password field and login button$")
	public void Verify_The_Availability_Of_Username_Field() throws Throwable {
		boolean flag1 = loginPage.verifyElementEnabled(TestBase.getReadConfigData().get("loginEmail"));
		boolean flag2 = loginPage.verifyElementEnabled(TestBase.getReadConfigData().get("loginPassword"));
		boolean flag4 = loginPage.verifyElementEnabled(TestBase.getReadConfigData().get("loginButton"));
		if (!(flag1 && flag2 && flag4)) {
			Assert.fail("Login Page not loaded Successfully");
		}
	}

	@Given("^we are on login page and we use valid username and password$")
	public void Insert_Credentials(DataTable table) {
		List<Map<String, String>> lstData = table.asMaps(String.class, String.class);
		loginPage.enterTextInTextBox(TestBase.getReadConfigData().get("loginEmail"),
				lstData.get(0).get("username").trim());
		loginPage.enterTextInTextBox(TestBase.getReadConfigData().get("loginPassword"),
				lstData.get(0).get("password").trim());
		loginPage.clickElement(TestBase.getReadConfigData().get("loginButton"));		
	}

	@Then("^verify the successful login by checking the availability of home icon$")
	public void Verify_Login_On_Portal_With_Non_Admin_credentials() {
		String message = "Messages";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("welcome"), message);
	}

	@When("^user on sign in page$")
	public void user_on_sign_in_page() throws Throwable {
		String message="Url not opened..";
		
		
//loginPage.assertElementDisplayed(loginPageObjectRepo.get("logo"), message);
	}

	@Then("^enter \"(.*?)\"$")
	public void enter(String arg1) throws Throwable {
		switch(arg1.toUpperCase()) {
			case "dimple.vyas@cgt.co.in":
				loginPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "ASAD@EMAIL.COM":
				loginPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "Nick@1234":
				loginPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;
			case "Nick@0123":
				loginPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;
			case "NICK@HARAKIRIMAIL.COM":
				loginPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "BRIDEXXX":
				loginPage.enterText(loginPageObjectRepo.get("signupFirstName"), arg1);
				break;
			case "BRIDEMAIDXXX":
				loginPage.enterText(loginPageObjectRepo.get("signupFirstName"), arg1);
				break;
			case "KUMAR":
				loginPage.enterText(loginPageObjectRepo.get("signupLastName"), arg1);
				break;
			case "1112223334":
				loginPage.enterText(loginPageObjectRepo.get("signupPhone"), arg1);
				break;
			case "AZ, USA":
				loginPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "ADMIN@123":
				loginPage.enterText(loginPageObjectRepo.get("signupPassword"), arg1);
				loginPage.enterText(loginPageObjectRepo.get("signupConfirmPassword"), arg1);
				break;
			case "BRIDENAME":
				loginPage.enterText(loginPageObjectRepo.get("brideMaidFirstName"), arg1);
				break;
			case "LASTNAMEXXX":
				loginPage.enterText(loginPageObjectRepo.get("brideMaidLastName"), arg1);
				break;
			case "REF123":
				loginPage.enterText(loginPageObjectRepo.get("signupReferralCode"), arg1);
				break;
			case "A":
				loginPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "NICK@123":
				loginPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;

			default:
				System.out.println("Option is not shown");
		}

	}

	@Then("^enters \"(.*?)\"$")
	public void enterthe(String arg1) throws Throwable {
		switch(arg1) {
			case "dimple.vyas@cgt.co.in":
				loginPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "ASAD@EMAIL.COM":
				loginPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "Nick@123":
				loginPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;
			case "Nick@0123":
				loginPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;
			case "NICK@HARAKIRIMAIL.COM":
				loginPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "BRIDEXXX":
				loginPage.enterText(loginPageObjectRepo.get("signupFirstName"), arg1);
				break;
			case "BRIDEMAIDXXX":
				loginPage.enterText(loginPageObjectRepo.get("DashboardNameTeam"), arg1);
				break;
			case "KUMAR":
				loginPage.enterText(loginPageObjectRepo.get("signupLastName"), arg1);
				break;
			case "1112223334":
				loginPage.enterText(loginPageObjectRepo.get("signupPhone"), arg1);
				break;
			case "AZ, USA":
				loginPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "ADMIN@123":
				loginPage.enterText(loginPageObjectRepo.get("signupPassword"), arg1);
				loginPage.enterText(loginPageObjectRepo.get("signupConfirmPassword"), arg1);
				break;
			case "BRIDENAME":
				loginPage.enterText(loginPageObjectRepo.get("brideMaidFirstName"), arg1);
				break;
			case "LASTNAMEXXX":
				loginPage.enterText(loginPageObjectRepo.get("brideMaidLastName"), arg1);
				break;
			case "REF123":
				loginPage.enterText(loginPageObjectRepo.get("signupReferralCode"), arg1);
				break;
			case "A":
				loginPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "NICK@123":
				loginPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;

			default:
				System.out.println("Option is not shown");
		}

	}

	
	
	
	
	
	@Then("^click submit button$")
	public void click_submit_button() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("loginButton"));
		loginPage.click(loginPageObjectRepo.get("loginButton"));
		loginPage.explicitWait(5000);
		
	}

	@Then("^click welcome link$")
	public void click_welcome_text() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("welcome"));
		loginPage.click(loginPageObjectRepo.get("welcome"));
		loginPage.explicitWait(5000);
		
	}


	@Then("^Verify  welcome title$")
	public void verify_welcomepage_title() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("welcometitle"));
		loginPage.click(loginPageObjectRepo.get("welcomemenus"));
		loginPage.explicitWait(5000);
		
	}
	

	@Then("^click settings button in menu$")
	public void click_settinga_button() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("menusettings"));
		loginPage.click(loginPageObjectRepo.get("menusettings"));
		loginPage.explicitWait(5000);
		
	}
	
	@Then("^Verify the settings page and click on menu and subscription$")
	public void verify_settings_page() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("settingsaccount"));
		loginPage.click(loginPageObjectRepo.get("welcomemenus"));
		loginPage.explicitWait(5000);
		loginPage.click(loginPageObjectRepo.get("menusubscription"));
		loginPage.explicitWait(5000);
	}

	@Then("^Verify the subscription page and click on menu and contacts$")
	public void verify_subscriptio_page() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("subscriptionPaymentmethod"));
		loginPage.click(loginPageObjectRepo.get("subscriptionmenu"));
		loginPage.explicitWait(5000);
		loginPage.click(loginPageObjectRepo.get("menuContacts"));
		loginPage.explicitWait(5000);
	}
	
	@Then("^Verify the Contact  page and click on menu and dashbaord$")
	public void verify_contact_page() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("contacttitle"));
		loginPage.click(loginPageObjectRepo.get("contactmenu"));
		loginPage.explicitWait(5000);
		loginPage.click(loginPageObjectRepo.get("menuDashboard"));
		loginPage.explicitWait(5000);
	}
	
	@Then("^Verify click on Add New Team$")
	public void click_addnewteam() throws Throwable {
		
		loginPage.click(loginPageObjectRepo.get("DashboardAddNewTeam"));
		loginPage.explicitWait(10000);
	}
	
	@Then("^Verify click on create$")
	public void click_create() throws Throwable {
		
		loginPage.click(loginPageObjectRepo.get("DashboardCreateButton"));
		loginPage.explicitWait(10000);
	}
	
	
	@Then("^Verify the dashboard  page and click on menu and share your story$")
	public void verify_dashbaord_page() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("DashboardTitle"));
		loginPage.click(loginPageObjectRepo.get("Dashboardmenu"));
		loginPage.explicitWait(5000);
		loginPage.click(loginPageObjectRepo.get("menuShareyourstory"));
		loginPage.explicitWait(5000);
	}
	
	
	@Then("^Verify the story user page and click on menu and logout$")
	public void verify_story_page() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("StoryTitle"));
		loginPage.click(loginPageObjectRepo.get("Storymenu"));
		loginPage.explicitWait(5000);
		loginPage.click(loginPageObjectRepo.get("menulogout"));
		loginPage.explicitWait(5000);
	}
	
	@Then("^Verify that user logged out successfully$")
	public void verify_user_logout() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("HomeLogin"));
		
		loginPage.explicitWait(5000);
	}
	
	@Then("^User Scrolling at home page till the bottom$")
	public void verify_scrolltobottom() throws Throwable {
		
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	

	@Then("^Verify the plan text availabiity and click on Plan$")
	public void verify_user_comesbottom() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("HomePlan"));
		loginPage.click(loginPageObjectRepo.get("HomePlan"));
		loginPage.explicitWait(5000);
		
	}
	

	@Then("^Verify plan page and scroll till bottom$")
	public void user_scrollatPlanpage() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("PlanTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	

	@Then("^Verify the platform text availabiity and click on platform$")
	public void click_platform() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("PlanPlatform"));
		loginPage.click(loginPageObjectRepo.get("PlanPlatform"));
		loginPage.explicitWait(5000);
		
	}
	@Then("^Verify platform title and scroll till bottom$")
	public void user_scrollatPlatformpage() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("PlatFormTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	
	@Then("^Verify the Write for Us text availabiity and click on Write for Us$")
	public void click_Write_for_Us() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("PlatFormWriteForUs"));
		loginPage.click(loginPageObjectRepo.get("PlatFormWriteForUs"));
		loginPage.explicitWait(5000);
		
	}
	
	@Then("^Verify Write for Us title and scroll till bottom$")
	public void user_scrollatWriteForUs() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("PlatFormTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	@Then("^Verify the Community text availabiity and click on Community$")
	public void click_Community() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("WriteForUs_Community"));
		loginPage.click(loginPageObjectRepo.get("WriteForUs_Community"));
		loginPage.explicitWait(5000);
		
	}
	
	@Then("^Verify Community title and scroll till bottom$")
	public void user_scrollatCommunity() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("CommunityTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	@Then("^Verify the Aboutus text availabiity and click on Aboutus$")
	public void click_Aboutus() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("CommunityAboutUs"));
		loginPage.click(loginPageObjectRepo.get("CommunityAboutUs"));
		loginPage.explicitWait(5000);
		}
	@Then("^Verify Aboutus title and scroll till bottom$")
	public void user_scrollatAboutus() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("AboutUsTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	@Then("^Verify the Contactus text availabiity and click on Contactus$")
	public void click_Contactus() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("AboutUsContactus"));
		loginPage.click(loginPageObjectRepo.get("AboutUsContactus"));
		loginPage.explicitWait(5000);
		}
	
	@Then("^Verify Contactus title and scroll till bottom$")
	public void user_scrollatContactus() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("ContactUsTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	@Then("^Verify the Careers text availabiity and click on Careers$")
	public void click_Careers() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("ContactUsCareers"));
		loginPage.click(loginPageObjectRepo.get("ContactUsCareers"));
		loginPage.explicitWait(5000);
		}
	
	@Then("^Verify Careers title and scroll till bottom$")
	public void user_scrollatCareers() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("CareersTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	
	
	@Then("^Verify the HelGuide text availabiity and click on HelGuide$")
	public void click_HelGuide() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("CareersHelpGuide"));
		loginPage.click(loginPageObjectRepo.get("CareersHelpGuide"));
		loginPage.explicitWait(5000);
		}
	
	@Then("^Verify HelGuide title and scroll till bottom$")
	public void user_scrollatHelGuide() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("HelpGuideTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	@Then("^Verify the PrivacyPolicy text availabiity and click on PrivacyPolicy$")
	public void click_PrivacyPolicy() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("HelpGuidePrivacyPolicy"));
		loginPage.click(loginPageObjectRepo.get("HelpGuidePrivacyPolicy"));
		loginPage.explicitWait(5000);
		}
	
	@Then("^Verify PrivacyPolicy title and scroll till bottom$")
	public void user_scrollatPrivacyPolicy() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("PrivacypolicyTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	@Then("^Verify the TermsOfUse text availabiity and click on TermsOfUse$")
	public void click_TermsOfUse() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("PrivacypolicyTermsOfUse"));
		loginPage.click(loginPageObjectRepo.get("PrivacypolicyTermsOfUse"));
		loginPage.explicitWait(5000);
		}
	@Then("^Verify TermsOfUse title and scroll till bottom$")
	public void user_scrollatTermsOfUse() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("TermsOfUseTilte"));
		btl.scrollPageUptoBottom(TestBase.webDriver);
		loginPage.explicitWait(5000);
		
	}
	
	@Then("^verify user successfully in the secure page$")
	public void verify_user_successfully_in_the_secure_page() throws Throwable {
		String message="login failed...";
		//loginPage.assertElementDisplayed(loginPageObjectRepo.get("invalidLoginCred"), message);
		loginPage.verifyUrlLastPath("account");

	}
	@Then("^logout$")
	public void logout() {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("accountLink"));
		loginPage.click(loginPageObjectRepo.get("accountLink"));
		loginPage.click(loginPageObjectRepo.get("logoutButton"));
	}
	@Then("^verify error message$")
	public void VerifyInvalidLogin() {
		String message="login failed...";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("invalidLoginCred"), message);
	}
	@When("^user on the sign up page$")
	public void user_on_the_sign_up_page() throws Throwable {

		String message="Page not loaded...";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("create_account"), message);
	}

	@Then("^click create an account$")
	public void click_create_an_account() throws Throwable {
		loginPage.click(loginPageObjectRepo.get("create_account"));
	}

	@Then("^select \"(.*?)\"$")
	public void select(String arg1) throws Throwable {
		//loginPage.click(loginPageObjectRepo.get("signupHowDidYouHearAboutDD"));
		loginPage.selectDropDownByValue(loginPageObjectRepo.get("signupHowDidYouHearAboutDD"), "Facebook");

	}
	@Then("^click submit$")
	public void click_submit() throws Throwable {
		//loginPage.clickAndWait(loginPageObjectRepo.get("signupSubmitButton"));

	}

	@Then("^select wedding date$")
	public void select_wedding_date() throws Throwable {
		loginPage.click(loginPageObjectRepo.get("signupWeddingDate"));
		loginPage.click(loginPageObjectRepo.get("signUpWeddingDateNextMonth"));
		loginPage.click(loginPageObjectRepo.get("signupWeddingCalendarDate"), 5);


	}

	@Then("^select how many in the party$")
	public void select_how_many_in_the_party() throws Throwable {
		loginPage.selectDropDownByValue(loginPageObjectRepo.get("signupHowManyPartyDD"), "5");

	}

	@Then("^select i am a$")
	public void select_i_am_a() throws Throwable {
		loginPage.click(loginPageObjectRepo.get("signUpIamBride"));
	}
	@Then("^select i am a maid$")
	public void select_i_am_a_maid() throws Throwable {
		loginPage.click(loginPageObjectRepo.get("signUpIamBridemaid"));
	}
	@Then("^enter email$")
	public void enter_email() throws Throwable {
		loginPage.enterTextWithRandomNumber(loginPageObjectRepo.get("signupEmail"), "auto_email@test.com");

	}
	@Then("^enter brideEmail$")
	public void brideEmail() throws Throwable {
		loginPage.enterTextWithRandomNumber(loginPageObjectRepo.get("brideMaidEmail"), "bride_email@test.com");

	}

	@Then("^enter mobile number$")
	public void enter_mobile_number() throws Throwable	{

//loginPage.enterTextWithRandomNumber(loginPageObjectRepo.get("signupPhone"), "1235214");
		int random=loginPage.getRandomNumber();
//loginPage.enterText(loginPageObjectRepo.get("signupPhone"), "+11"+random);
		loginPage.enterText(loginPageObjectRepo.get("signupPhone"), "(541)"+random);
//System.out.println("+910"+random);
	}
	@Then("^Verify cofirmation page$")
	public void Verify_confirmation_page() {
		loginPage.selectTabByIndex(0);
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("signupConfirmationMessage"));
	}
	@Then("^verify confirmation page$")
	public void verify_confirmation_page() throws Throwable {
//loginPage.waitAndgetElement(loginPageObjectRepo.get("signupThankuPage"));
//String message="Signup Not done successfully..";
//loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupThankuPage"), message);
//loginPage.getBrowserTitle();
//loginPage.assertTextMatch("Thank You From Sign Up", loginPage.getBrowserTitle());
	}

	@Given("^user on the signup page$")
	public void user_on_the_signup_pBridemaidSignupage() throws Throwable {

		loginPage.click(loginPageObjectRepo.get("signuplink"));
		loginPage.click(loginPageObjectRepo.get("create_account"));
	}
	@Then("^click login$")
	public void clickSignIn() {
		loginPage.click(loginPageObjectRepo.get("signuplink"));
	}
	@Then("^verify the availability of wedding date$")
	public void verify_the_availability_of_wedding_date() throws Throwable {
		String message="Wedding date is not available";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupWeddingDate"), message);

	}

	@Then("^verify how many in the party$")
	public void verify_how_many_in_the_party() throws Throwable {
		String message="How many in the party dropdown is not available";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupHowManyPartyDD"), message);
	}

	@Then("^verify bridemaid button$")
	public void verify_bridemaid_button() throws Throwable {
		String message="Bridemaid button is not available";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signUpIamBridemaid"), message);
	}

	@Then("^verify bride button$")
	public void verify_bride_button() throws Throwable {
		String message="Bride button is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signUpIamBride"), message);
	}

	@Then("^verify email address$")
	public void verify_email_address() throws Throwable {
		String message="Email fields is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupEmail"), message);
	}

	@Then("^verify firstname$")
	public void verify_firstname() throws Throwable {
		String message="Firstname is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupFirstName"), message);
	}

	@Then("^verify lastname$")
	public void verify_lastname() throws Throwable {
		String message="Last name is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupLastName"), message);
	}

	@Then("^verify phonenumber$")
	public void verify_phonenumber() throws Throwable {
		String message="Phone number is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupPhone"), message);
	}

	@Then("^verify zipcode$")
	public void verify_zipcode() throws Throwable {
		String message="Zip code is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupZip"), message);
	}

	@Then("^verify password$")
	public void verify_email_password() throws Throwable {
		String message="Password is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupPassword"), message);
	}

	@Then("^verify confirmpassword$")
	public void verify_confirmpassword() throws Throwable {
		String message="Confirm password is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupConfirmPassword"), message);
//assertTrue(message, loginPage.verifyElementDisplayed(loginPageObjectRepo.get("signupConfirmPassword")));
	}

	@Then("^verify referralcode$")
	public void verify_referralcode() throws Throwable {
		String message="Referral code is not available..";
		loginPage.assertElementDisplayed	(loginPageObjectRepo.get("signupReferralCode"), message);

	}

	@Then("^verify instagram$")
	public void verify_instagram() throws Throwable {
		String message="Instagram is not available..";
		loginPage.assertElementDisplayed	(loginPageObjectRepo.get("signupInstagram"), message);
	}

	@Then("^verify howhearaboutus$")
	public void verify_howhearaboutus() throws Throwable {
		String message="How to hear about us is not available..";
		loginPage.assertElementDisplayed	(loginPageObjectRepo.get("signupHowDidYouHearAboutDD"), message);
	}

	@Then("^verify submitbutton$")
	public void verify_submitbutton() throws Throwable {
		String message="Submit button is not available..";
		loginPage.assertElementDisplayed(loginPageObjectRepo.get("signupSubmitButton"), message);
	}

	@Given("^user in login page$")
	public void user_in_login_page() throws Throwable {
		loginPage.click(loginPageObjectRepo.get("signuplink"));
	}

	@Then("^click forgot password link$")
	public void click_forgot_password_link() throws Throwable {
		loginPage.click(loginPageObjectRepo.get("ForgotPassword"));
	}

	@Then("^verify forgot password error message for invalid email$")
	public void verify_forgot_password_error_messageForInvalidEmail() throws Throwable {
		String forgotpasswordMsg=loginPage.getElementText(loginPageObjectRepo.get("PleaseEnterValidEmailForForgotpassword"));
		System.out.println("Error message for invalid email address: "+forgotpasswordMsg);
	}

	@Then("^verify email sent$")
	public void verify_email_sent() throws Throwable {

	}

	@Then("^click forgot password submit button$")
	public void clickSubmitButton() throws InterruptedException {
		loginPage.click(loginPageObjectRepo.get("ForgotPasswordButton"));
		Thread.sleep(1000);
	}

	@Then("^enter forgot email \"(.*?)\"$")
	public void enter_forgot_email(String arg1) throws Throwable {
		switch(arg1.toUpperCase()) {
			case "ABC123":
				loginPage.enterText(loginPageObjectRepo.get("ForgotPasswordEmail"), arg1);
				break;
			case "santosh.kumar@cgt.co.in":
				loginPage.enterText(loginPageObjectRepo.get("ForgotPasswordEmail"), arg1);
				break;
			case "abc@abc.com":
				loginPage.enterText(loginPageObjectRepo.get("ForgotPasswordEmail"), arg1);
				break;
		}
	}

	@Then("^clear email field$")
	public void clearEamilField() {
		loginPage.clearTextField(loginPageObjectRepo.get("ForgotPasswordEmail"));
	}

	@Then("^verify forgot password error message$")
	public void verify_forgot_password_error_message() throws Throwable {
		String errormMsgForUnregisterUser=loginPage.getElementText(loginPageObjectRepo.get("NoAccountFoundErrorForForgotpassword"));
		System.out.println("Error message for unregistered account: "+errormMsgForUnregisterUser);
	}

	@Then("^click cart icon button$")
	public void click_cart_icon_button() throws Throwable {
		loginPage.click(loginPageObjectRepo.get("CartIconButtonInHome"));
	}

	@Then("^verify cart url$")
	public void verifyCartInUrl() {
		loginPage.AssertCurrentUrl("cart");
	}

	@Then("^verify cart page$")
	public void verify_cart_page() throws Throwable {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("StartShoppingButton"));
	}

	@Then("^enter email address$")
	public void enterEmailAddress() {
		loginPage.enterText(loginPageObjectRepo.get("signupEmail"), "santosh.kumar@cgt.co.in");
	}

	@Then("^email address for existing$")
	public void verifyExistingEmail() {
		String validationMsg=loginPage.getElementText(loginPageObjectRepo.get("EmailValidation"));
		loginPage.assertTextMatch("User already exists with this email-id.", validationMsg);
	}

	@Then("^clear sign up email field$")
	public void clearSignupEmailField() {
		loginPage.clearTextField(loginPageObjectRepo.get("signupEmail"));
	}

	@Then("^enter invalid email address$")
	public void enterInvalidEmailAddress() {
		loginPage.enterText(loginPageObjectRepo.get("signupEmail"), "abc.abc");
	}

	@Then("^email address for invalid$")
	public void verifyInvalidEmail() {
		String validationMsg=loginPage.getElementText(loginPageObjectRepo.get("EmailValidation"));
		System.out.println("Validation error message for invalid email: "+validationMsg);
	}

	@Then("^verify zip list$")
	public void verifyZipList() {
		loginPage.verifyElementDisplayed(loginPageObjectRepo.get("ZipcodeAutoSuggest"));

	}

	@Then("^enter invalid zip$")
	public void enterInvalidZip() {
		loginPage.enterText(loginPageObjectRepo.get("signupZip"), "al1269asad");
	}

	@Then("^verify validation error message for invalid zipcode$")
	public void verifyValidationForInvalidZip() {
		String validationMsg=loginPage.getElementText(loginPageObjectRepo.get("ZipValidation"));
		loginPage.assertTextMatch("Please select a valid city or address.", validationMsg);
	}

	@After("@LoginPage")
	public void afterClass(Scenario scenario) {
		loginPage.closeResources(scenario);
	}
}