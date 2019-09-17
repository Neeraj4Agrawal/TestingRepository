@LoginPage
Feature: Login Page Test 
	In order to test functionality of Login page
	We will test login feature with different combination of credentials to test the login functionality
	
Background: Initialize resources for test script
Given Initialize resources in the beginning of each scenario for Login




@Login
Scenario: Scenario_01 Verify login with valid username and password
When user on sign in page
Then enter "NICK@HARAKIRIMAIL.COM"
Then enters "Nick@123"
Then click submit button
Then verify the successful login by checking the availability of home icon
Then click welcome link
Then Verify  welcome title
Then click settings button in menu
Then Verify the settings page and click on menu and subscription
Then Verify the subscription page and click on menu and contacts
Then Verify the Contact  page and click on menu and dashbaord
Then Verify click on Add New Team
Then enters "BRIDEMAIDXXX"
Then Verify click on create
Then Verify the dashboard  page and click on menu and share your story
Then Verify the story user page and click on menu and logout
Then Verify that user logged out successfully
Then User Scrolling at home page till the bottom
Then Verify the plan text availabiity and click on Plan
Then Verify plan page and scroll till bottom
Then Verify the platform text availabiity and click on platform
Then Verify platform title and scroll till bottom
Then Verify the Write for Us text availabiity and click on Write for Us
Then Verify Write for Us title and scroll till bottom
Then Verify the Community text availabiity and click on Community
Then Verify Community title and scroll till bottom
Then Verify the Aboutus text availabiity and click on Aboutus
Then Verify Aboutus title and scroll till bottom
Then Verify the Contactus text availabiity and click on Contactus
Then Verify Contactus title and scroll till bottom
Then Verify the Careers text availabiity and click on Careers
Then Verify Careers title and scroll till bottom
Then Verify the HelGuide text availabiity and click on HelGuide
Then Verify HelGuide title and scroll till bottom
Then Verify the PrivacyPolicy text availabiity and click on PrivacyPolicy
Then Verify PrivacyPolicy title and scroll till bottom
Then Verify the TermsOfUse text availabiity and click on TermsOfUse
Then Verify TermsOfUse title and scroll till bottom






