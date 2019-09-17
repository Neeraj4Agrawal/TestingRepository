@SignupPage
Feature: Signup Page Test 
	In order to test functionality of Signup page
	We will test Signup feature with different combination of credentials to test the Signup functionality
	
Background: Initialize resources for test script
Given Initialize resources in the beginning of each scenario for Signup

@Test1
Scenario: Scenario_01 Verify Sign up with valid username and password
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then enterss "Neeraj"
Then enterss "Agrawal"
Then enterss "neeraj67@gmail.com"
Then enterss "Neeraj4@"
Then entersss "Neeraj4@"
Then Select the gender
Then Click on the Continue button at Create Account page
Then Verify the Select Payment method title
Then Enter Payment method "5555555555554444"
Then Enter Payment method "12"
Then Enter Payment method "2021"
Then Enter Payment method "012"
Then Enter Payment method "Neeraj"
Then Enter Payment method "BRIDEXXX"
Then Enter Payment method "BRIDEMAIDXXX"
Then Enter Payment method "123456"
Then Enter Payment method "112 Jai Hind Nagar"
Then Select the country
Then Click on the Proceed to checkout button at Create Account page
Then Verify the checkout subtab and click on checkout button
Then Verify the Verify your Account SubTab and click on send verifcation link again


@Test2
Scenario: Scenario_01 Verify that Terms of use link clickable
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Verify the Terms of user availability and click on Terms of user link

@Test3
Scenario: Scenario_01 Verify that Privacy policy link clickable
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Verify the Privacy policyss of user availability and click on Privacy policy link

@Test4
Scenario: Scenario_01 Verify that facebook is clickable
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then Verify the availability of facebook and click

@Test5
Scenario: Scenario_01 Verify that Google is clickable
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then Verify the availability of google and click


@Test6
Scenario: Scenario_01 Verify that Login at create account is clickable
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then Verify that login button at create account is clickable


@Test7
Scenario: Scenario_01 Verify validation message if first name left blank
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then Click on the Continue button at Create Account page
Then Verify the validation message if user not filled the first name

@Test8
Scenario: Scenario_01 Verify that continue button is displayed
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then verify the continue button availability


@Test9
Scenario: Scenario_01 Verify validation message if last name left blank
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then verify the continue button availability
Then Click on the Continue button at Create Account page
Then Verify the validation message if user not filled the last name

@Test10
Scenario: Scenario_01 Verify the validation message if user not filled the Email Address
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then verify the continue button availability
Then Click on the Continue button at Create Account page
Then Verify the validation message if user not filled the Email Address

@Test11
Scenario: Scenario_01 Verify the validation message if user not filled the password
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then verify the continue button availability
Then Click on the Continue button at Create Account page
Then Verify the validation message if user not filled the password


@Test12
Scenario: Scenario_01 Verify the validation message if user not filled the confirm password
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then verify the continue button availability
Then Click on the Continue button at Create Account page
Then Verify the validation message if user not filled the confirm password

@Test13
Scenario: Scenario_01 Verify the validation message Password and Confirm password does not match
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then Create Account enter the password
Then Create Account enter the confirm password
Then Click on the Continue button at Create Account page
Then Verify the validation message Password and Confirm password does not match

@Test14
Scenario: Scenario_01 Verify the validation message if password typed is invalid
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then Create Account enter the invalid  password
Then Click on the Continue button at Create Account page
Then Verify the validation message if password typed is invalid


@Test15
Scenario: Scenario_01 verify the validation message if any field left blank at payment
When user on sign in pages
Then Verify the sing up link availability and click on signup
Then Verify the plan title availability and click on schedule for 30 days for social user
Then Verify the availability of Sub tab Your Order Summary
Then verify the message on Summary page for social use
Then Click on the Next button at Order summary page
Then Verify the availability of Sub tab Create Account
Then enterss "Neeraj"
Then enterss "Agrawal"
Then enterss "neeraj88@gmail.com"
Then enterss "Neeraj4@"
Then entersss "Neeraj4@"
Then Select the gender
Then Click on the Continue button at Create Account page
Then Verify the Select Payment method title
Then Click on the Proceed to checkout button at Create Account page
Then verify the validation message if any field left blank at payment 


@Test16
Scenario: Scenario_01 verify the validation message email address field left as blank
When user on sign in pages
Then Click on the Login button button at login page
Then verify the validation message if email address left blank at login


@Test17
Scenario: Scenario_01 verify the validation message password field left as blank
When user on sign in pages
Then Click on the Login button button at login page
Then verify the validation message if password left blank at login

@Test18
Scenario: Scenario_01 verify the validation message email address field left as blank
When user on sign in pages
Then Click on the Login button button at login page
Then verify the validation message if password left blank at login



@Test19
Scenario: Scenario_01 verify the validation message if email is invalid
When user on sign in pages
Then enters login "Neeraj4@"
Then Click on the Login button button at login page
Then verify the validation message if email is invalid


@Test20
Scenario: Scenario_01 verify the validation message if credential are wrong or user is unregistered
When user on sign in pages
Then enters login "neeraj@yopmail.com"
Then enters login "BRIDEXXX4@"
Then Click on the Login button button at login page
Then verify the validation message if credential are wrong or user is unregistered


@Test21
Scenario: Scenario_01 Verify the login with Remember me
When user on sign in pages
Then enters login "neeraj@yopmail.com"
Then enters login "BRIDEXXX4@"
Then select the remember me check box
Then Click on the Login button button at login page



@Test22
Scenario: Scenario_01 Verify the Color of Continue button
When user on sign in pages
Then Verify the Color of Continue button


@Test23
Scenario: Scenario_01 Verify Click on forgot password link on login page
When user on sign in pages
Then Verify Click on forgot password link on login page


@Test24
Scenario: Scenario_01 verify the validation message if user click on send verfication link without fill email at forgot psw
When user on sign in pages
Then Verify Click on forgot password link on login page
Then Click on send verfication button without fill the email at forgot password
Then verify the validation message if user click on send verfication link without fill email at forgot psw


@Test25
Scenario: Scenario_01 verify the validation message if user click on send verfication link with invalid email at forgot psw
When user on sign in pages
Then Verify Click on forgot password link on login page
Then Type the invalid email id at forgot password page
Then Click on send verfication button without fill the email at forgot password
Then verify the validation message if user click on send verfication link with invalid email at forgot psw



@Test26
Scenario: Scenario_01 verify the validation message if user click on send verfication link with unregistered email at forgot psw
When user on sign in pages
Then Verify Click on forgot password link on login page
Then Type the unregistered email id at forgot password page
Then Click on send verfication button without fill the email at forgot password
Then verify the validation message if user click on send verfication link with unregistered email at forgot psw

@Test27
Scenario: Scenario_01 verify the text Send Verification Email at forgot password page
When user on sign in pages
Then Verify Click on forgot password link on login page
Then verify the text Send Verification Email at forgot password page












