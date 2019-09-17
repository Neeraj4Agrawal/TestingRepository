package com.matellio.brideside.signup;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.matellio.brideside.base.TestBase;
import com.matellio.brideside.util.BaseUtil;
import com.matellio.brideside.util.XlsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignupTest {
	private SignupPage SignupPage;
	private XlsReader datatable;
	private Map<String, String> loginPageObjectRepo;
	private Logger logger = Logger.getLogger(SignupPage.class);
	BaseUtil btl =  new BaseUtil();
	
	@Given("^Initialize resources in the beginning of each scenario for Signup$")
	public void Initialize_Resources() throws IOException, InterruptedException {
		TestBase.getInstance();
		TestBase.initializeGlobalVariables();
		TestBase.loadExcelFiles();
		loginPageObjectRepo = TestBase.getReadResources().getValuesFromXml("LoginPage.xml", "SingUpRepository");
// loginPageObjectText = TestBase.getReadResources().getValuesFromXml(
// "LoginPage.xml", "loginObjectText");
		this.SignupPage = new SignupPage();
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
	
	

	@When("^user on sign in pages$")
	public void user_on_sign_in_pages() throws Throwable {
		
		
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("loginButton"));
	}
	
	
	@Then("^Verify the sing up link availability and click on signup$")
	public void verify_singup_thanclick() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("loginSignUPlink"));
		SignupPage.click(loginPageObjectRepo.get("loginSignUPlink"));
		SignupPage.explicitWait(5000);
		
	}
	
	@Then("^Verify the plan title availability and click on schedule for 30 days for social user$")
	public void verify_plan_thanclicknosingup() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("plantitle"));
		SignupPage.click(loginPageObjectRepo.get("ScheduleFor30days_social"));
		SignupPage.explicitWait(5000);
		
	}
	
	@Then("^Verify the availability of Sub tab Your Order Summary$")
	public void verify_OrdrsummarySubtab() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("YourOrderSummary_SubTab"));
		SignupPage.explicitWait(5000);
		btl.getElementText(loginPageObjectRepo.get("YourOrderSummary_SubTab"));
		
	}
	
	@Then("^verify the message on Summary page for social use$")
	public void Verify_Login_On_Portal_With_Non_Admin_credentials() {
		String message = "30-Days Free Trial, Umeand Socials";
		SignupPage.assertElementDisplayed(loginPageObjectRepo.get("YourOrderSummary_text"), message);
		btl.getElementText(loginPageObjectRepo.get("YourOrderSummary_text"));
	}
	

	@Then("^Click on the Next button at Order summary page$")
	public void click_next() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("YourOrderSummary_next"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("YourOrderSummary_next"));
		
	}
	
	@Then("^Verify the availability of Sub tab Create Account$")
	public void verify_availabiltiu_createaccountsubtab() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("createAccount_SubTab"));
		SignupPage.explicitWait(5000);
		btl.getElementText(loginPageObjectRepo.get("createAccount_SubTab"));
		
	}
	
	
	@Then("^Select the gender$")
	public void select_gender() throws Throwable {
		String value="Male";
		btl.selectDropDownByValue(loginPageObjectRepo.get("createAccount_Gender"), value);
		
	}
	

	@Then("^Click on the Continue button at Create Account page$")
	public void click_continue() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("createAccount_ContinueButton"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("createAccount_ContinueButton"));
		
	}
	
	@Then("^Verify the Select Payment method title$")
	public void verify_paymentMethod() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_title"));
		SignupPage.explicitWait(5000);
		
	}
	
	
	
/*
	@Then("^verify the availability of username, password field and login button$")
	public void Verify_The_Availability_Of_Username_Field() throws Throwable {
		boolean flag1 = SignupPage.verifyElementEnabled(TestBase.getReadConfigData().get("loginEmail"));
		boolean flag2 = SignupPage.verifyElementEnabled(TestBase.getReadConfigData().get("loginPassword"));
		boolean flag4 = SignupPage.verifyElementEnabled(TestBase.getReadConfigData().get("loginButton"));
		if (!(flag1 && flag2 && flag4)) {
			Assert.fail("Login Page not loaded Successfully");
		}
	}
	*/
	
	
	/*
	@When("^user on sign in page$")
	public void user_on_sign_in_page() throws Throwable {
		String message="Url not opened..";
		
		
//loginPage.assertElementDisplayed(loginPageObjectRepo.get("logo"), message);
	}


*/
	@Then("^enterss \"(.*?)\"$")
	public void enterthevalue(String arg1) throws Throwable {
		switch(arg1) {
			case "Neeraj":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_firstName"), arg1);
				break;
			case "Agrawal":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_LastName"), arg1);
				break;
			case "neeraj88@gmail.com":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_emailAddress"), arg1);
				break;
			case "Neeraj4@":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_Pasword"), arg1);
				break;
			case "Neeraj4@1":
				SignupPage.enterText(loginPageObjectRepo.get("signupFirstName"), arg1);
				break;
			case "BRIDEXXX":
				SignupPage.enterText(loginPageObjectRepo.get("signupFirstName"), arg1);
				break;
			case "BRIDEMAIDXXX":
				SignupPage.enterText(loginPageObjectRepo.get("DashboardNameTeam"), arg1);
				break;
			case "KUMAR":
				SignupPage.enterText(loginPageObjectRepo.get("signupLastName"), arg1);
				break;
			case "1112223334":
				SignupPage.enterText(loginPageObjectRepo.get("signupPhone"), arg1);
				break;
			case "AZ, USA":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "ADMIN@123":
				SignupPage.enterText(loginPageObjectRepo.get("signupPassword"), arg1);
				SignupPage.enterText(loginPageObjectRepo.get("signupConfirmPassword"), arg1);
				break;
			case "BRIDENAME":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidFirstName"), arg1);
				break;
			case "LASTNAMEXXX":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidLastName"), arg1);
				break;
			case "REF123":
				SignupPage.enterText(loginPageObjectRepo.get("signupReferralCode"), arg1);
				break;
			case "A":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "NICK@123":
				SignupPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;

			default:
				System.out.println("Option is not shown");
		}

	}

	@Then("^entersss \"(.*?)\"$")
	public void enterthevalues(String arg1) throws Throwable {
		switch(arg1) {
			case "Neeraj":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_firstName"), arg1);
				break;
			case "Agrawal":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_LastName"), arg1);
				break;
			case "neeraj88@gmail.com":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_emailAddress"), arg1);
				break;
			case "Neeraj4@1":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_Paswords"), arg1);
				break;
			case "Neeraj4@":
				SignupPage.enterText(loginPageObjectRepo.get("createAccount_CPassword"), arg1);
				break;
			case "BRIDEXXX":
				SignupPage.enterText(loginPageObjectRepo.get("signupFirstName"), arg1);
				break;
			case "BRIDEMAIDXXX":
				SignupPage.enterText(loginPageObjectRepo.get("DashboardNameTeam"), arg1);
				break;
			case "KUMAR":
				SignupPage.enterText(loginPageObjectRepo.get("signupLastName"), arg1);
				break;
			case "1112223334":
				SignupPage.enterText(loginPageObjectRepo.get("signupPhone"), arg1);
				break;
			case "AZ, USA":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "ADMIN@123":
				SignupPage.enterText(loginPageObjectRepo.get("signupPassword"), arg1);
				SignupPage.enterText(loginPageObjectRepo.get("signupConfirmPassword"), arg1);
				break;
			case "BRIDENAME":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidFirstName"), arg1);
				break;
			case "LASTNAMEXXX":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidLastName"), arg1);
				break;
			case "REF123":
				SignupPage.enterText(loginPageObjectRepo.get("signupReferralCode"), arg1);
				break;
			case "A":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "NICK@123":
				SignupPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;

			default:
				System.out.println("Option is not shown");
		}

	}

	@Then("^Enter Payment method \"(.*?)\"$")
	public void selectPayment(String arg1) throws Throwable {
		switch(arg1) {
			case "5555555555554444":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_cardNumber"), arg1);
				break;
			case "12":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_month"), arg1);
				break;
			case "2021":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_year"), arg1);
				break;
			case "012":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_cvcode"), arg1);
				break;
			case "Neeraj":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_firstname"), arg1);
				break;
			case "BRIDEXXX":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_Lastname"), arg1);
				break;
			case "BRIDEMAIDXXX":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_city"), arg1);
				break;
			case "123456":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_postcode"), arg1);
				break;
			case "112 Jai Hind Nagar":
				SignupPage.enterText(loginPageObjectRepo.get("PaymentMethod_address"), arg1);
				break;
			case "AZ, USA":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "ADMIN@123":
				SignupPage.enterText(loginPageObjectRepo.get("signupPassword"), arg1);
				SignupPage.enterText(loginPageObjectRepo.get("signupConfirmPassword"), arg1);
				break;
			case "BRIDENAME":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidFirstName"), arg1);
				break;
			case "LASTNAMEXXX":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidLastName"), arg1);
				break;
			case "REF123":
				SignupPage.enterText(loginPageObjectRepo.get("signupReferralCode"), arg1);
				break;
			case "A":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "NICK@123":
				SignupPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;

			default:
				System.out.println("Option is not shown");
		}

	}
	

	@Then("^enters login \"(.*?)\"$")
	public void enterthelogindata(String arg1) throws Throwable {
		switch(arg1) {
			case "neeraj.agarwal123@gmail.com":
				SignupPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "Agrawal4@":
				SignupPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;
			case "Agrawal":
				SignupPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;
			case "Neeraj4@":
				SignupPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "neeraj@yopmail.com":
				SignupPage.enterText(loginPageObjectRepo.get("loginEmail"), arg1);
				break;
			case "BRIDEXXX4@":
				SignupPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;
			case "BRIDEMAIDXXX":
				SignupPage.enterText(loginPageObjectRepo.get("DashboardNameTeam"), arg1);
				break;
			case "KUMAR":
				SignupPage.enterText(loginPageObjectRepo.get("signupLastName"), arg1);
				break;
			case "1112223334":
				SignupPage.enterText(loginPageObjectRepo.get("signupPhone"), arg1);
				break;
			case "AZ, USA":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "ADMIN@123":
				SignupPage.enterText(loginPageObjectRepo.get("signupPassword"), arg1);
				SignupPage.enterText(loginPageObjectRepo.get("signupConfirmPassword"), arg1);
				break;
			case "BRIDENAME":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidFirstName"), arg1);
				break;
			case "LASTNAMEXXX":
				SignupPage.enterText(loginPageObjectRepo.get("brideMaidLastName"), arg1);
				break;
			case "REF123":
				SignupPage.enterText(loginPageObjectRepo.get("signupReferralCode"), arg1);
				break;
			case "A":
				SignupPage.enterText(loginPageObjectRepo.get("signupZip"), arg1);
				break;
			case "NICK@123":
				SignupPage.enterText(loginPageObjectRepo.get("loginPassword"), arg1);
				break;

			default:
				System.out.println("Option is not shown");
		}

	}
	
	
	
	
	
	
	@Then("^Select the country$")
	public void select_country() throws Throwable {
		String value="Albania";
		btl.selectDropDownByValue(loginPageObjectRepo.get("PaymentMethod_country"), value);
		
	}
	
	
	
	@Then("^Click on the Proceed to checkout button at Create Account page$")
	public void click_checkout() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_proceedCheckout"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_proceedCheckout"));
		
	}
	
	@Then("^Verify the checkout subtab and click on checkout button$")
	public void click_checkoutbutton() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_checkoutTitle"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_checkoutButton"));
	
	}	
	
	
	@Then("^Verify the Verify your Account SubTab and click on send verifcation link again$")
	public void verify_youraccount() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_verifyAccountSubtab"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_sendagain"));
	
	}	
	
	@Then("^Verify the Terms of user availability and click on Terms of user link$")
	public void click_termsOfUse() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_TermOfUse"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_TermOfUse"));
	
	}	
	
	@Then("^Verify the Privacy policyss of user availability and click on Privacy policy link$")
	public void click_privacypolicyss() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_privacy"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_privacy"));
	
	}
	
	@Then("^Verify the availability of facebook and click$")
	public void click_facebook() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_facebook"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_facebook"));
	
	}
	
	
	@Then("^Verify the availability of google and click$")
	public void click_google() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_google"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_google"));
	
	}
	
	@Then("^Verify that login button at create account is clickable$")
	public void click_loginCreateAccount() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("PaymentMethod_calogin"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("PaymentMethod_calogin"));
	
	}
   
	@Then("^Verify the validation message if user not filled the first name$")
	public void verifyValidationMsgFirstName() {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("PaymentMethod_firstnameAMessage"));
		SignupPage.assertTextMatchwithMessage("First Name cannot be blank.", validationMsg);
	}
	

	@Then("^Verify the validation message if user not filled the last name$")
	public void verifyValidationMsgLastName() {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("PaymentMethod_LastnameAMessage"));
		SignupPage.assertTextMatchwithMessage("Last Name cannot be blank.", validationMsg);
	}
	@Then("^Verify the validation message if user not filled the Email Address$")
	public void verifyValidationMsgEmailAddess() {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("PaymentMethod_emailaddressAMessage"));
		SignupPage.assertTextMatchwithMessage("Email Address cannot be blank.", validationMsg);
	}
	@Then("^Verify the validation message if user not filled the password$")
	public void verifyValidationMsgPassword() {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("PaymentMethod_passwordAMessage"));
		SignupPage.assertTextMatchwithMessage("Password cannot be blank.", validationMsg);
	}
	
	@Then("^Verify the validation message if user not filled the confirm password$")
	public void verifyValidationMsgConfirmPassword() {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("PaymentMethod_ConpasswordAMessage"));
		SignupPage.assertTextMatchwithMessage("Confirm Password cannot be blank.", validationMsg);
	}
	

	
	@Then("^Verify the validation message Password and Confirm password does not match$")
	public void verify_messagePasswordMismatch() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("PaymentMethod_passwordmissmatchMessage"));
		SignupPage.assertTextMatchwithMessage("Password does not match", validationMsg);
	}
	
	@Then("^Verify the validation message if password typed is invalid$")
	public void verify_messagePasswordInvalid() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("createaccount_invalidMessage"));
		SignupPage.assertTextMatchwithMessage("Password must contain at least one capital letter, one small letter, one number and one special characters (!, @, #, $, %).", validationMsg);
	}
	
	@Then("^verify the validation message if any field left blank at payment$")
	public void verify_validationPayment() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("payment_alertmessage"));
		SignupPage.assertTextMatchwithMessage("Please fill the input box showing error.", validationMsg);
	}
	
	

	@Then("^Click on the Login button button at login page$")
	public void click_loginBTN() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("loginButton"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("loginButton"));
		
	}
	

	@Then("^verify the validation message if email address left blank at login$")
	public void verify_validationEmail() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("loginemail_message"));
		SignupPage.assertTextMatchwithMessage("Email cannot be blank.", validationMsg);
	}
	
	@Then("^verify the validation message if password left blank at login$")
	public void verify_validationPassword() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("loginPasword_message"));
		SignupPage.assertTextMatchwithMessage("Password cannot be blank.", validationMsg);
	}
	
	@Then("^verify the validation message if email is invalid$")
	public void verify_validationEmailInvalid() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("loginInvalidEmail_message"));
		SignupPage.assertTextMatchwithMessage("Email is not a valid email address.", validationMsg);
	}
	
	@Then("^verify the validation message if credential are wrong or user is unregistered$")
	public void verify_validationNoExitOrDeleted() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("loginInvalidCredential_message"));
		SignupPage.assertTextMatchwithMessage("This user does not exist or deleted.", validationMsg);
	}
	@Then("^select the remember me check box$")
	public void selelctrememberme()
	{
		btl.checkCheckBox(loginPageObjectRepo.get("login_Rememberme"));
	}
	
	@Then("^Verify the Color of Continue button$")
	public void continuebutton_colors()
	{
		SignupPage.continuebutton_color(loginPageObjectRepo.get("loginButton"));
	}
	
	
	@Then("^Verify Click on forgot password link on login page$")
	public void click_forgotpsw() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("login_forgotpsw"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("login_forgotpsw"));
		
	}
	
	@Then("^Click on send verfication button without fill the email at forgot password$")
	public void click_forgotVerficationlink() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("forgot_verifcationBTN"));
		SignupPage.explicitWait(5000);
		SignupPage.click(loginPageObjectRepo.get("forgot_verifcationBTN"));
		
	}
	
	
	
	
	
	@Then("^verify the validation message if user click on send verfication link without fill email at forgot psw$")
	public void verify_validationMSGfpBlankemail() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("forgot_blankemaimessage"));
		SignupPage.assertTextMatchwithMessage("Email cannot be blank.", validationMsg);
	}
	
	@Then("^Type the invalid email id at forgot password page$")
	public void enterthe_invalidemailatFP() {
		SignupPage.enterText(loginPageObjectRepo.get("forgot_EmailField"), "Neeraj4@11");
	}
	
	@Then("^Type the unregistered email id at forgot password page$")
	public void enterthe_unregisteredemailatFP() {
		SignupPage.enterText(loginPageObjectRepo.get("forgot_EmailField"), "neeraj@gmail.com");
	}
	
	@Then("^verify the validation message if user click on send verfication link with invalid email at forgot psw$")
	public void verify_validationMSGfpInvalidmail() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("forgot_invalidemaimessage"));
		SignupPage.assertTextMatchwithMessage("Email is not a valid email address.", validationMsg);
	}
	
	@Then("^verify the validation message if user click on send verfication link with unregistered email at forgot psw$")
	public void verify_validationMSGfpUnregisterdmail() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("forgot_Registeredemaimessage"));
		SignupPage.assertTextMatchwithMessage("There is no user with such email.", validationMsg);
	}
	
	
	
	@Then("^verify the instruction message at forgot password page$")
	public void verify_availability_fpInstruction() throws Throwable {
		SignupPage.verifyElementDisplayed(loginPageObjectRepo.get("forgot_instruction"));
		SignupPage.explicitWait(5000);
		btl.getElementText(loginPageObjectRepo.get("forgot_instruction"));
		
	}
	
	
	@Then("^verify the text Send Verification Email at forgot password page$")
	public void verify_forgotpswbuttontext() throws Throwable {
		String validationMsg=SignupPage.getElementText(loginPageObjectRepo.get("forgot_verifcationBTN"));
		SignupPage.assertTextMatchwithMessage("Send Verification Email", validationMsg);
	}
	
	
	
	
	
	
	
	
	
	
	
	@Then("^Create Account enter the password$")
	public void enterthe_password() {
		SignupPage.enterText(loginPageObjectRepo.get("createaccount_password"), "Neeraj4@");
	}
	
	
	@Then("^Create Account enter the invalid  password$")
	public void enterthe_Invalidpassword() {
		SignupPage.enterText(loginPageObjectRepo.get("createaccount_password"), "Neeraj");
	}
	
	
	
	
	
	
	
	@Then("^Create Account enter the confirm password$")
	public void enterthe_Cpassword() {
		SignupPage.enterText(loginPageObjectRepo.get("createaccount_Cpassword"), "Neeraj4@11");
	}
	
	
	
	@Then("^clear sign up email fields$")
	public void clearSignupEmailFields() {
		SignupPage.clearTextField(loginPageObjectRepo.get("signupEmail"));
	}
	
	
	@Then("^clear sign up email fieldsssss$")
	public void clearSignupEmailField() {
		SignupPage.clearTextField(loginPageObjectRepo.get("signupEmail"));
	}

	@Then("^verify the continue button availability$")
	public void verify_continue_button() throws Throwable {
		String message="Continue button is not available..";
		SignupPage.assertElementDisplayed(loginPageObjectRepo.get("createAccount_ContinueButton"), message);
	}
    
	
	
	
	
	
	
}
