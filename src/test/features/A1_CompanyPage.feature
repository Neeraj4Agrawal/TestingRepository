@CompanyPage
Feature: CompanyPage Test 
	In order to test functionality of CompanyPage page
	We will test CompanyPage feature with different combination of data to test the CompanyPage functionality
	
Background: Initialize resources for test script
Given Initialize resources in the beginning of each scenario for company







@Test111
Scenario: Scenario_01 Do login with valid credentials and go to company page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard


@Test112
Scenario: Scenario_01 Verify that Add new Team button is clickable than title verification
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on the Add new team button after logged in sucesfully
Then Verify the title at the Add new team pop up after loggged in



@Test113
Scenario: Scenario_01 Verify that User can add the Team successfully
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on the Add new team button after logged in sucesfully
Then Verify the title at the Add new team pop up after loggged in
Then Type the team name
Then Click on Create button


@Test114
Scenario: Scenario_01 Verify the validation message while team name not filled
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on the Add new team button after logged in sucesfully
Then Verify the title at the Add new team pop up after loggged in
Then Click on Create button
Then Verify the validation message while team name not filled


@Test115
Scenario: Scenario_01 Verify that Add new team pop up removed while click on cross icon
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on the Add new team button after logged in sucesfully
Then Verify the title at the Add new team pop up after loggged in
Then Click on the cross button to remove the pop up
Then Verify the Add new team button at the company dashboard after remove pop up


@Test116
Scenario: Scenario_01 Verify the validation message while team name exist in record
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on the Add new team button after logged in sucesfully
Then Verify the title at the Add new team pop up after loggged in
Then Type the team name
Then Click on Create button
Then Verify the validation message while team name exist in record



@Test117
Scenario: Scenario_01 Click on Polls Invited to/Participated in on Dashboard
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on Polls Invited to/Participated in on Dashboard

@Test118
Scenario: Scenario_01 Verify the title Polls Invited to/Participated in on Page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on Polls Invited to/Participated in on Dashboard
Then Verify the title Polls Invited to/Participated in on Page

@Test119
Scenario: Scenario_01 Click on the Dashboard button on Polls Invited to/Participated Page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on Polls Invited to/Participated in on Dashboard
Then Verify the title Polls Invited to/Participated in on Page
Then Click on the Dashboard button on Polls Invited to/Participated Page

@Test120
Scenario: Scenario_01 Click on the Contacts button on Polls Invited to/Participated Page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on Polls Invited to/Participated in on Dashboard
Then Verify the title Polls Invited to/Participated in on Page
Then Click on the Contacts button on Polls Invited to/Participated Page


@Test121
Scenario: Scenario_01 Click on the Export to Excel button on Polls Invited to/Participated Page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on Polls Invited to/Participated in on Dashboard
Then Verify the title Polls Invited to/Participated in on Page
Then Click on the Export to Excel button on Polls Invited to/Participated Page


@Test122
Scenario: Scenario_01 Go to Team Dashboard by click on icon on Company dashboard
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard

@Test123
Scenario: Scenario_01 Click on Schedule an meeting button on Team Dashboard
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard


@Test124
Scenario: Scenario_01 Verify the title on Schedle an meeting page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard
Then Verify the title on Schedle an meeting page

@Test125
Scenario: Scenario_01 Enter data on schedule an meet up page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard
Then Verify the title on Schedle an meeting page
Then Enter data on schedule an meet up page with click on continue

@Test126
Scenario: Scenario_01 Verify validation msg while user continue without filling title
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard
Then Verify the title on Schedle an meeting page
Then Click on Continue button at Schedule an meet up page
Then Verify validation msg while user continue without filling title

@Test127
Scenario: Scenario_01 Verify that user is able to view the poll settings by clicking on It
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard
Then Verify the title on Schedle an meeting page
Then Verify that user is able to view the poll settings by clicking on It


@Test128
Scenario: Scenario_01 Verify continue with feeling data and select the poll settings.
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard
Then Verify the title on Schedle an meeting page
Then Enter title and notes on schedule an meet up page
Then Verify that user is able to view the poll settings by clicking on It
Then Do scroll the screen to down
Then Select the check box Edit Vote
Then Click on Continue button at Schedule an meet up page




@Test129
Scenario: Scenario_01 Enter data on schedule an meet up page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard
Then Verify the title on Schedle an meeting page
Then Enter data on schedule an meet up page with click on continue
Then Verify the title on step2 of Schedule an meet up section



@Test130
Scenario: Scenario_01 Verify the Back button functionality
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on Schedule an meeting button on Team Dashboard
Then Verify the title on Schedle an meeting page
Then Enter data on schedule an meet up page with click on continue
Then Verify the title on step2 of Schedule an meet up section
Then Click on back button




@Test131
Scenario: Scenario_01 Verify that Share poll link enable on Team Dashboard
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the share poll link at Team Dashboard


@Test132
Scenario: Scenario_01 Verify the title at share poll link pop up
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the share poll link at Team Dashboard
Then Verify the title at share poll link pop up


@Test133
Scenario: Scenario_01 Verify the functionality of send on share poll link with invalid mail id
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the share poll link at Team Dashboard
Then Verify the title at share poll link pop up
Then Enter data with invalid data on share an poll link pop up and click on send
Then Verify the Invalid email id message at share poll link popup



@Test134
Scenario: Scenario_01 Verify that user can remove the Share poll link pop up by click on Cancel
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the share poll link at Team Dashboard
Then Verify the title at share poll link pop up
Then Click on cancel button to remove the Share an poll link pop up


@Test135
Scenario: Scenario_01 Verify that user can remove the Share poll link pop up by click on Cross button
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the share poll link at Team Dashboard
Then Verify the title at share poll link pop up
Then Click on cross button to remove the Share an poll link pop up


@Test136
Scenario: Scenario_01 Verify that user can view the poll settings by click on poll settigns icon
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard


@Test137
Scenario: Scenario_01 Verify the title at the poll settings page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard
Then Verify the Title at poll setting page


@Test138
Scenario: Scenario_01 Verify that user can save the poll settings
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard
Then Verify the Title at poll setting page
Then Click on save button at the poll settings


@Test139
Scenario: Scenario_01 Verify the back button functionality on poll settings
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard
Then Verify the Title at poll setting page
Then Click on back button at the poll settings


@Test140
Scenario: Scenario_01 Verify that user can save the poll settings with some changes
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard
Then Verify the Title at poll setting page
Then Select the Edit vote permission of poll settings
Then Click on save button at the poll settings

@Test141
Scenario: Scenario_01 Verify that Privacy policy link is clickable on poll settings
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard
Then Verify the Title at poll setting page
Then Click on the Got button on cookie message on poll settings
Then Click on the privacy policy link in footer on poll settings page


@Test142
Scenario: Scenario_01 Verify that Terms of Use link is clickable on poll settings
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard
Then Verify the Title at poll setting page
Then Click on the Got button on cookie message on poll settings
Then Click on the Terms of Use link in footer on poll settings page


@Test143
Scenario: Scenario_01 Verify the text at the footer of poll settings page
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Go to Team Dashboard by click on icon on Company dashboard
Then Click on the poll settings link at Team Dashboard
Then Verify the Title at poll setting page
Then Do scroll the screen to down
Then Click on the Got button on cookie message on poll settings
Then Verify the text at the footer of poll settings page

@Test144
Scenario: Scenario_01 Click on image at Dashboard top edit the team
When user on sign in pages by check the button
Then enter the values at login page "nick@harakirimail.com"
Then enter the values at login page "Nick@123"
Then Click on the Continue button at login page page
Then click settings button in menu after the loggged in succesfully
Then click Dashboard button in menu after the user loggged in succesfully
Then Verify the title at the company dashboard
Then Click on edit team button at Dashboard top edit the team






