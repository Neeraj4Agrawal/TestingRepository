package com.matellio.brideside.gift;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.matellio.brideside.base.TestBase;
import com.matellio.brideside.company.CompanyPage;
import com.matellio.brideside.util.BaseUtil;
import com.matellio.brideside.util.XlsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GiftPageTest {
	
	
	
	
	private GiftPage giftPage;
//	private XlsReader datatable;
	private Map<String, String> GiftPageObjectelements;
	private Logger logger = Logger.getLogger(CompanyPage.class);
	BaseUtil btl =  new BaseUtil();

	@Given("^Initialize resources in the beginning of each scenario for Giftpage$")
	public void Initialize_Resources() throws IOException, InterruptedException {
		TestBase.getInstance();
		TestBase.initializeGlobalVariables();
	//	TestBase.loadExcelFiles();
		GiftPageObjectelements = TestBase.getReadResources().getValuesFromXml("GiftPage.xml","GiftPageObjectRepository");

		this.giftPage = new GiftPage();
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
    @When("^Do login with valid credentials$")
	public void type_logincredentials()
	{
		giftPage.entertextIntextbox(GiftPageObjectelements.get("loginEmail"), "nick@harakirimail.com");
		giftPage.entertextIntextbox(GiftPageObjectelements.get("loginPassword"), "Nick@123");
		giftPage.clickonElement(GiftPageObjectelements.get("loginButton"));
	}
	
    @Then("^Click on the sqaure menu and than click on Gift card$")
  	public void click_square_menu()
  	{
  		
  		giftPage.clickonElement(GiftPageObjectelements.get("squareMenu"));
  		giftPage.clickonElement(GiftPageObjectelements.get("squareMenu_GiftCard"));
  	}

	
    @Then("^Verify the step 1 sub tab text$")
  	public void verify_title_step1()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("Step1_submenutitle"));
    	
  		giftPage.verifytext("Choose Recipient", actual);
  	}
	
	
    @Then("^Type the receipient information on step1$")
  	public void type_receipient_information()
  	{
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientName"), "Neeraj");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientEmail"), "neeraj4@gmail.com");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientMessage"), "Just only for testing");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_SenderName"),"Snehas");
  	}

    @Then("^Click on the Pick a Gift card$")
  	public void click_on_pick_gift_card()
  	{
  		
    	giftPage.clickonElement(GiftPageObjectelements.get("Step1_PickaGiftCard"));
  	}
	
    @Then("^Type the receipient information on step1 without recepient name at step1$")
  	public void type_receipient_information_without_receipietName()
  	{
  	//	giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientName"), "Neeraj");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientEmail"), "neeraj4@gmail.com");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientMessage"), "Just only for testing");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_SenderName"),"Snehas");
  	}
    
    @Then("^Verify the alert message while receipient name left as blank$")
  	public void verify_alertmessage_text_availability_step1()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("Step1_alertmessage_Recepientname"));
    	
  		giftPage.verifytext("To User Name cannot be blank.", actual);
  	}
    
    @Then("^Type the receipient information on step1 without recepient email at step1$")
  	public void type_receipient_information_without_receipietEmail()
  	{
  	    giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientName"), "Neeraj");
  	//	giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientEmail"), "neeraj4@gmail.com");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientMessage"), "Just only for testing");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_SenderName"),"Snehas");
  	}
    @Then("^Verify the alert message while receipient email left as blank$")
  	public void verify_alertmessageemail_text_availability_step1()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("Step1_alertmessage_RecepientEmail"));
    	
  		giftPage.verifytext("To User Email cannot be blank.", actual);
  	}
    
    @Then("^Type the receipient information on step1 without recepient message at step1$")
  	public void type_receipient_information_without_receipietMessage()
  	{
  	    giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientName"), "Neeraj");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientEmail"), "neeraj4@gmail.com");
  	//	giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientMessage"), "Just only for testing");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_SenderName"),"Snehas");
  	}
    @Then("^Verify the alert message while receipient message left as blank$")
  	public void verify_alertmessageMessage_text_availability_step1()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("Step1_alertmessage_RecepientMessage"));
    	
  		giftPage.verifytext("Message cannot be blank.", actual);
  	}
    
    
    @Then("^Type the receipient information on step1 with invalid recepient email at step1$")
  	public void type_receipientInformation_Invlaidemail()
  	{
  	    giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientName"), "Neeraj");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientEmail"), "neeraj4");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_ReceipientMessage"), "Just only for testing");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_SenderName"),"Snehas");
  	}
    
    @Then("^Verify the alert message while receipient email is invalid$")
  	public void verify_alertmessageMessage_InvalidEmail_step1()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("Step1_alertmessage_InvlaidEmail"));
    	
  		giftPage.verifytext("To User Email is not a valid email address.", actual);
  	}
    
    
    @Then("^Click on the Email to me sub tab$")
  	public void Click_onthe_Email_to_me_sub_tab()

  	{
  		
    	giftPage.clickonElement(GiftPageObjectelements.get("Step1_EmailTome_Subtab"));
  	}
    
    @Then("^Fill the username and useremail at Email to me Sub tab$")
  	public void Fill_the_username_and_useremail_at_Email_to_me_Sub_tab()
  	{
  	    giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_EmailTome_Username"), "Neeraj");
  		giftPage.entertextIntextbox(GiftPageObjectelements.get("Step1_EmailTome_Email"), "neeraj4@gmail.com");
 
  	}
    
    @Then("^Verify the sub tab title at step 2$")
  	public void Verify_the_sub_tab_title_at_step_2()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("Step2_SubTabTitle"));
    	
  		giftPage.verifytext("Choose Design", actual);
  	}
    
    @Then("^Click on the How much button at step 2$")
  	public void Click_on_the_How_much_button_at_step_2()

  	{
    	
    	giftPage.clickonElement(GiftPageObjectelements.get("GetButton"));
  		giftPage.scrollPageUptoBottom(TestBase.webDriver);
    	giftPage.clickonElement(GiftPageObjectelements.get("Step2_HowMuchButton"));
  	}
    
    @Then("^Verify the alert message while image ot selected at step 2$")
  	public void Verify_the_alert_message_while_image_ot_selected_at_step_2()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("image_step2"));
    	
  		giftPage.verifytext("Card Image cannot be blank.", actual);
  	}
    
    @Then("^user is able to step 1 from step2 by clicking on back button$")
  	public void user_is_able_to_step_1_from_step2_by_clicking_on_back_button()

  	{
    	giftPage.clickonElement(GiftPageObjectelements.get("GetButton"));
  		giftPage.scrollPageUptoBottom(TestBase.webDriver);
    	giftPage.clickonElement(GiftPageObjectelements.get("step2_backbutton"));
  		
  	}
    
    @Then("^Select the image and click on How much button$")
  	public void Select_the_image_and_click_on_How_much_button()

  	{
    	giftPage.clickonElement(GiftPageObjectelements.get("step2_image"));
  		giftPage.scrollPageUptoBottom(TestBase.webDriver);
    	giftPage.clickonElement(GiftPageObjectelements.get("Step2_HowMuchButton"));
  		
  	}
    
    @Then("^Verify the sub tab title at step3$")
  	public void Verify_the_sub_tab_title_at_step3()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("step3_subtabTitle"));
    	
  		giftPage.verifytext("Select Price", actual);
  	}
    
    
    
    
    @Then("^CLick on the back to go back to step2$")
  	public void CLick_on_the_back_to_go_back_to_step2()

  	{
    	giftPage.clickonElement(GiftPageObjectelements.get("step3_Back"));
  	
  		
  	}
    
    
    
    @Then("^CLick on the Add to card button at step3$")
  	public void CLick_on_the_Add_to_card_button_at_step3()

  	{
    	giftPage.clickonElement(GiftPageObjectelements.get("step3_AddTocart"));
  	
  		
  	}
    
    @Then("^Select the amount at step3$")
  	public void Select_the_amount_at_step3()

  	{
    	giftPage.clickonElement(GiftPageObjectelements.get("step3_Amount"));
  	
  		
  	}
     
    
    
    
    
    
    @Then("^Verify the alert message while click to add cart without price at step3$")
  	public void Verify_the_alert_message_while_click_to_add_cart_without_price_at_step3()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("step3_AlertMessage"));
    	
  		giftPage.verifytext("Please select any one amount!", actual);
  	}
    
    
    
    @Then("^Verify the sub tab title at step4$")
  	public void Verify_the_sub_tab_title_at_step4()
  	{
  		
    	String actual=giftPage.getElementText(GiftPageObjectelements.get("step4_title"));
    	
  		giftPage.verifytext("Review Cart", actual);
  	}
    
    
    
    
    
    
}
