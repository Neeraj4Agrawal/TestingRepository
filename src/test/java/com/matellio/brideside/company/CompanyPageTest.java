package com.matellio.brideside.company;

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
import cucumber.api.Scenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompanyPageTest {
	
	
	private CompanyPage companyPage;
	private XlsReader datatable;
	private Map<String, String> companyPageObjectRepo;
	private Logger logger = Logger.getLogger(CompanyPage.class);
	BaseUtil btl =  new BaseUtil();

	@Given("^Initialize resources in the beginning of each scenario for company$")
	public void Initialize_Resources() throws IOException, InterruptedException {
		TestBase.getInstance();
		TestBase.initializeGlobalVariables();
		TestBase.loadExcelFiles();
		companyPageObjectRepo = TestBase.getReadResources().getValuesFromXml("CompanyPage.xml","CompanyObjectRepository");

		this.companyPage = new CompanyPage();
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

    @When("^user on sign in pages by check the button$")
	public void user_on_sign_in_pagess() throws Throwable {
		String messages="Continue";
		System.out.print("User on the sing in pagess printting");
		companyPage.assertElementDisplayed(companyPageObjectRepo.get("loginButton"), messages);
	}
	
	
	
	@Then("^enter the values at login page \"(.*?)\"$")
	public void entertheLoginCredentils(String arg1) throws Throwable {
		switch(arg1.toUpperCase()) {
		
		case "ASAD@EMAIL.COM":
			companyPage.enterText(companyPageObjectRepo.get("loginEmail"), arg1);
			break;
		
		case "NICK@123":
			companyPage.enterText(companyPageObjectRepo.get("loginPassword"), arg1);
			break;
		case "NICK@HARAKIRIMAIL.COM":
			companyPage.enterText(companyPageObjectRepo.get("loginEmail"), arg1);
			break;
		case "BRIDEXXX":
			companyPage.enterText(companyPageObjectRepo.get("signupFirstName"), arg1);
			break;
		case "BRIDEMAIDXXX":
			companyPage.enterText(companyPageObjectRepo.get("DashboardNameTeam"), arg1);
			break;
		case "KUMAR":
			companyPage.enterText(companyPageObjectRepo.get("signupLastName"), arg1);
			break;
		case "1112223334":
			companyPage.enterText(companyPageObjectRepo.get("signupPhone"), arg1);
			break;
		case "AZ, USA":
			companyPage.enterText(companyPageObjectRepo.get("signupZip"), arg1);
			break;
		case "ADMIN@123":
			companyPage.enterText(companyPageObjectRepo.get("signupPassword"), arg1);
			companyPage.enterText(companyPageObjectRepo.get("signupConfirmPassword"), arg1);
			break;
		case "BRIDENAME":
			companyPage.enterText(companyPageObjectRepo.get("brideMaidFirstName"), arg1);
			break;
		case "LASTNAMEXXX":
			companyPage.enterText(companyPageObjectRepo.get("brideMaidLastName"), arg1);
			break;
		case "REF123":
			companyPage.enterText(companyPageObjectRepo.get("signupReferralCode"), arg1);
			break;
		case "A":
			companyPage.enterText(companyPageObjectRepo.get("signupZip"), arg1);
			break;
		default:
			System.out.println("Option is not shown");
	}

}
	@Then("^Click on the Continue button at login page page$")
	public void click_continue() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("loginButton"));
		companyPage.explicitWait(5000);
		companyPage.click(companyPageObjectRepo.get("loginButton"));
		
	}
	
	@Then("^click settings button in menu after the loggged in succesfully$")
	public void click_settinga_button() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("welcomemenus"));
		companyPage.click(companyPageObjectRepo.get("welcomemenus"));
		companyPage.explicitWait(5000);
		
	}
	
	@Then("^click Dashboard button in menu after the user loggged in succesfully$")
	public void click_Company_button() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("Settings_dashboard"));
		companyPage.click(companyPageObjectRepo.get("Settings_dashboard"));
		companyPage.explicitWait(5000);
		
	}

	@Then("^Verify the title at the company dashboard$")
	public void verify_dashboard_title() throws Throwable {
		String company_title =companyPage.getElementText(companyPageObjectRepo.get("Coampanydashbaord1_title"));
		companyPage.assertTitleMatch("Company Dashboard", company_title);
		
	}
	
	@Then("^Click on the Add new team button after logged in sucesfully$")
	public void click_addnewteam_button() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("Coampany_AddTeam"));
		companyPage.click(companyPageObjectRepo.get("Coampany_AddTeam"));
		companyPage.explicitWait(5000);
		
	}
	@Then("^Verify the title at the Add new team pop up after loggged in$")
	public void verify_Team_title() throws Throwable {
		String team_title =companyPage.getElementText(companyPageObjectRepo.get("AddNewTeam_Title"));
		companyPage.assertTitleMatch("Add New Team", team_title);
		
	}
	
	
	@Then("^Type the team name$")
	public void type_teamName() throws Throwable {
		
		companyPage.enterText(companyPageObjectRepo.get("Team_AddTeam"), "Test");
	}
	
	@Then("^Click on Create button$")
	public void click_onCreate_button() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("Team_createButton"));
		companyPage.click(companyPageObjectRepo.get("Team_createButton"));
		companyPage.explicitWait(5000);
		
	}
	
	@Then("^Verify the validation message while team name not filled$")
	public void validation_teamblank() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("Team_validationmsg_teamblank"));
		companyPage.assertTitleMatch("Name of Team cannot be blank.", validation_teamblank);
		
	}
	
	@Then("^Click on the cross button to remove the pop up$")
	public void click_crossButton() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("cross_icon"));
		companyPage.click(companyPageObjectRepo.get("cross_icon"));
		companyPage.explicitWait(10000);
		
	}
	@Then("^Verify the Add new team button at the company dashboard after remove pop up$")
	public void verify_dashboard_title_popupclosed() throws Throwable {
		String company_title =companyPage.getElementText(companyPageObjectRepo.get("Coampany_AddTeam"));
		companyPage.assertTitleMatch("Add New Team", company_title);
		
	}
	@Then("^Verify the validation message while team name exist in record$")
	public void validation_teamexist() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("Team_validationExistmsg"));
		companyPage.assertTitleMatch("Team with this name already exists.", validation_teamblank);
		
	}
	
	@Then("^Click on Polls Invited to/Participated in on Dashboard$")
	public void click_pollInvited() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollInvited_buton"));
		companyPage.click(companyPageObjectRepo.get("pollInvited_buton"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Verify the title Polls Invited to/Participated in on Page$")
	public void pollinvited_title() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("pollInvited_Title"));
		companyPage.assertTitleMatch("Polls Invited To/Participated In", validation_teamblank);
		
	}
	
	

	@Then("^Click on the Dashboard button on Polls Invited to/Participated Page$")
	public void click_pollInviteDashboard() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollInvited_dashboard"));
		companyPage.click(companyPageObjectRepo.get("pollInvited_dashboard"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Click on the Contacts button on Polls Invited to/Participated Page$")
	public void click_pollInviteContacts() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollInvited_Contacts"));
		companyPage.click(companyPageObjectRepo.get("pollInvited_Contacts"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Click on the Export to Excel button on Polls Invited to/Participated Page$")
	public void click_pollInviteExport() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollInvited_Export"));
		companyPage.click(companyPageObjectRepo.get("pollInvited_Export"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Go to Team Dashboard by click on icon on Company dashboard$")
	public void click_TeamDashboard() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pCompany_TeamDashboard"));
		companyPage.click(companyPageObjectRepo.get("pCompany_TeamDashboard"));
		companyPage.explicitWait(10000);
		
	}
	
	
	@Then("^Click on Schedule an meeting button on Team Dashboard$")
	public void click_TeamDashboard_ScheduleMeetbtn() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("CDashboard_ScheuleMeetbtn"));
		companyPage.click(companyPageObjectRepo.get("CDashboard_ScheuleMeetbtn"));
		companyPage.explicitWait(10000);
		
	}
	@Then("^Verify the title on Schedle an meeting page$")
	public void ScheduleMeetUp_Tiles() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("ScheduleMeetUp_Tille"));
		companyPage.assertTitleMatch("Schedule a Meeting", validation_teamblank);
		
	}
	
	@Then("^Enter data on schedule an meet up page with click on continue$")
	public void enterdata_ScheduleMeetUp_Tiles_Click() throws Throwable {
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_TilleName"), "Test");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_Notes"), "Test");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_location"), "Test Lane, Southampton, UK");
		companyPage.click(companyPageObjectRepo.get("ScheduleMeetUp_Continue"));
		companyPage.explicitWait(10000);
	}
	@Then("^Enter data on schedule an meet up page$")
	public void enterdata_ScheduleMeetUp_Tiles() throws Throwable {
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_TilleName"), "Test");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_Notes"), "Test");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_location"), "Test Lane, Southampton, UK");
		companyPage.explicitWait(10000);
	}
	
	@Then("^Enter title and notes on schedule an meet up page$")
	public void enterdataTileandNotes_ScheduleMeetUp_Tiles() throws Throwable {
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_TilleName"), "Test");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUp_Notes"), "Test");
		companyPage.explicitWait(10000);
	}
	
	@Then("^Click on Continue button at Schedule an meet up page$")
	public void click_ScheduleMeet_Continue_btn() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("ScheduleMeetUp_Continue"));
		companyPage.click(companyPageObjectRepo.get("ScheduleMeetUp_Continue"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Verify validation msg while user continue without filling title$")
	public void blankTitle_validationMessage() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("ScheduleMeetUp_blankTitleMessage"));
		companyPage.assertTitleMatch("Title cannot be blank.", validation_teamblank);
		
	}
	
	@Then("^Verify that user is able to view the poll settings by clicking on It$")
	public void click_ScheduleMeet_PollSettings() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("ScheduleMeetUp_pollSettings"));
		companyPage.click(companyPageObjectRepo.get("ScheduleMeetUp_pollSettings"));
		companyPage.explicitWait(10000);
		
	}

	@Then("^Select the check box Edit Vote$")
	public void click_PollSettingsEditVote() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("ScheduleMeetUp_pollSettingsEditVote"));
		companyPage.click(companyPageObjectRepo.get("ScheduleMeetUp_pollSettingsEditVote"));
		companyPage.explicitWait(10000);
		
	}
	

	@Then("^Do scroll the screen to down$")
	public void scroll_scehduleMeetup_screen() throws Throwable {
		btl.scrollPageUptoBottom(TestBase.webDriver);
		
	}
	
	@Then("^Verify the title on step2 of Schedule an meet up section$")
	public void scehduleMeetupStep2_title() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("ScheduleMeetUpStep2_title"));
		companyPage.assertTitleMatch("Select Date and Time", validation_teamblank);
		
	}
	
	
	@Then("^Enter the start date$")
	public void enterdata_ScduleMeetup_Step2() throws Throwable {
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUpStep2_startDAATE"), "20082019");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUpStep2_startTime"), "1230");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUpStep2_EndDAATE"), "21082019");
	//	companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUpStep2_startTime"), "1230");
		companyPage.enterText(companyPageObjectRepo.get("ScheduleMeetUpStep2_EndTime"), "1245");
		companyPage.click(companyPageObjectRepo.get("ScheduleMeetUpStep2_AddButtonn"));
		
		
		companyPage.explicitWait(10000);
	}
	
	@Then("^Click on back button$")
	public void click_ScheduleMeet_Backbtn() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("ScheduleMeetUpStep2_BackButtonn"));
		companyPage.click(companyPageObjectRepo.get("ScheduleMeetUpStep2_BackButtonn"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Click on the share poll link at Team Dashboard$")
	public void click_SharePollLink() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("TeamDashboard_sharepolllink"));
		companyPage.click(companyPageObjectRepo.get("TeamDashboard_sharepolllink"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Verify the title at share poll link pop up$")
	public void sharepolllink_title() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("TeamDashboard_sharepolllinkTitle"));
		companyPage.assertTitleMatch("Share Poll Link", validation_teamblank);
		
	}
	
	
	
	@Then("^Enter data with invalid data on share an poll link pop up and click on send$")
	public void enterdata_SharePollLink() throws Throwable {
		btl.clearTextField(companyPageObjectRepo.get("SharePollLink_from"));
		companyPage.enterText(companyPageObjectRepo.get("SharePollLink_from"), "Test");
		companyPage.enterText(companyPageObjectRepo.get("SharePollLink_SendTO"), "neeraj");
		companyPage.explicitWait(10000);
		companyPage.enterText(companyPageObjectRepo.get("SharePollLink_Message"), "Message");
		companyPage.explicitWait(10000);
		companyPage.click(companyPageObjectRepo.get("SharePollLink_Send"));
		companyPage.explicitWait(10000);
	}
	
	
	@Then("^Verify the Invalid email id message at share poll link popup$")
	public void sharepolllink_Invlaidmsg() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("SharePollLink_invalidemailMSG"));
		System.out.print(validation_teamblank);
		companyPage.assertTitleMatch("Email Ids (comma seperated) cannot be blank.", validation_teamblank);
		
	}
	
	
	@Then("^Click on cancel button to remove the Share an poll link pop up$")
	public void clickCancel_SharePollLink() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("SharePollLink_Cancel"));
		companyPage.click(companyPageObjectRepo.get("SharePollLink_Cancel"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Click on cross button to remove the Share an poll link pop up$")
	public void clickCross_SharePollLink() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("SharePollLink_Cross"));
		companyPage.click(companyPageObjectRepo.get("SharePollLink_Cross"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Click on the poll settings link at Team Dashboard$")
	public void clickpollsettings() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("TeamDashboard_pollsettings"));
		companyPage.click(companyPageObjectRepo.get("TeamDashboard_pollsettings"));
		companyPage.explicitWait(10000);
		
	}
	
	
	@Then("^Verify the Title at poll setting page$")
	public void pollSettings_titleVerify() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("pollsettings_title"));
		System.out.print(validation_teamblank);
		companyPage.assertTitleMatch("Poll Settings", validation_teamblank);
		
	}
	

	@Then("^Click on save button at the poll settings$")
	public void pollSettings_clickSave() throws Throwable {
		btl.scrollPageUptoBottom(TestBase.webDriver);
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollsettings_Savebutton"));
		companyPage.click(companyPageObjectRepo.get("pollsettings_Savebutton"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Click on back button at the poll settings$")
	public void pollSettings_clickBack() throws Throwable {
	
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollsettings_BackButton"));
		companyPage.click(companyPageObjectRepo.get("pollsettings_BackButton"));
		companyPage.explicitWait(10000);
		
	}
	@Then("^Select the Edit vote permission of poll settings$")
	public void pollSettings_clickEditPOll() throws Throwable {
	
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollsettings_EditVoteButton"));
		companyPage.click(companyPageObjectRepo.get("pollsettings_EditVoteButton"));
		companyPage.explicitWait(10000);
		
	}
	@Then("^Click on the Got button on cookie message on poll settings$")
	public void pollSettings_clickCookieGotbtn() throws Throwable {
		btl.scrollPageUptoBottom(TestBase.webDriver);
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollsettings_cookieGot"));
		companyPage.click(companyPageObjectRepo.get("pollsettings_cookieGot"));
		companyPage.explicitWait(10000);
		
	}
	
	
	
	
	
	@Then("^Click on the privacy policy link in footer on poll settings page$")
	public void pollSettings_clickPrivacyPolicy() throws Throwable {
		btl.scrollPageUptoBottom(TestBase.webDriver);
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollsettings_pp"));
		companyPage.click(companyPageObjectRepo.get("pollsettings_pp"));
		companyPage.explicitWait(10000);
		
	}
	
	
	@Then("^Click on the Terms of Use link in footer on poll settings page$")
	public void pollSettings_clickTermsOfUse() throws Throwable {
		btl.scrollPageUptoBottom(TestBase.webDriver);
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("pollsettings_Terms"));
		companyPage.click(companyPageObjectRepo.get("pollsettings_Terms"));
		companyPage.explicitWait(10000);
		
	}
	
	@Then("^Verify the text at the footer of poll settings page$")
	public void pollSettings_footertextVerify() throws Throwable {
		String validation_teamblank =companyPage.getElementText(companyPageObjectRepo.get("pollsettings_footertext"));
		System.out.print(validation_teamblank);
		companyPage.assertTitleMatch("2019 © Umeand. All rights reserved.", validation_teamblank);
		
	}
	@Then("^Click on edit team button at Dashboard top edit the team$")
	public void companyDashboard_clcikimage_editteam() throws Throwable {
		companyPage.verifyElementDisplayed(companyPageObjectRepo.get("CompanyDashobard_EditTeam"));
		companyPage.click(companyPageObjectRepo.get("CompanyDashobard_EditTeam"));
		companyPage.explicitWait(10000);
		
		
	}
	
	
	
	
	
	
}
