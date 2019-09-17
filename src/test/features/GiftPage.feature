@CompanyPage
Feature: Gift page of Umeand Test 
	In order to test functionality of Gift page
	We will test Giftpage feature with different combination of data to test the Giftpage functionality
	
Background: Initialize resources for test script
Given Initialize resources in the beginning of each scenario for Giftpage


@Test201
Scenario: Scenario_01 Verify the title at first step of Gift card
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text

@Test202
Scenario: Scenario_01 Verify that user is able to type inside the fields
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1


@Test203
Scenario: Scenario_01 Verify that user is able to submit data and proced to step 2.
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card


@Test204
Scenario: Scenario_01 Verify the alert message while receipient name left as blank
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1 without recepient name at step1
Then Click on the Pick a Gift card
Then Verify the alert message while receipient name left as blank

@Test205
Scenario: Scenario_01 Verify the alert message while receipient email left as blank
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1 without recepient email at step1
Then Click on the Pick a Gift card
Then Verify the alert message while receipient email left as blank


@Test206
Scenario: Scenario_01 Verify the alert message while receipient message left as blank
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1 without recepient message at step1
Then Click on the Pick a Gift card
Then Verify the alert message while receipient message left as blank


@Test207
Scenario: Scenario_01 Verify the alert message while receipient email is invalid
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1 with invalid recepient email at step1
Then Click on the Pick a Gift card
Then Verify the alert message while receipient email is invalid


@Test208
Scenario: Scenario_01 Verify that Email To Me sub tab is clickable
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Click on the Email to me sub tab



@Test209
Scenario: Scenario_01 Verify that User is able to submit data at email to me page
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Click on the Email to me sub tab
Then Fill the username and useremail at Email to me Sub tab



@Test210
Scenario: Scenario_01 Verify the sub tab title at step 2
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2


@Test211
Scenario: Scenario_01 Verify the alert message while user click on How Much without select image at step 2
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Click on the How much button at step 2
Then Verify the alert message while image ot selected at step 2


@Test212
Scenario: Scenario_01 Verify that user is able to step 1 from step2 by clicking on back button
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then user is able to step 1 from step2 by clicking on back button



@Test213
Scenario: Scenario_01 Verify that user is able to step 1 from step2 by clicking on back button
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then user is able to step 1 from step2 by clicking on back button


@Test214
Scenario: Scenario_01 Verify that user is able to proceed to step 3 by submit the data
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Select the image and click on How much button


@Test215
Scenario: Scenario_01 Verify the title at the step 3
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Select the image and click on How much button
Then Verify the sub tab title at step3



@Test216
Scenario: Scenario_01 Verify the Back button functionality at step 3
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Select the image and click on How much button
Then Verify the sub tab title at step3
Then CLick on the back to go back to step2

@Test217
Scenario: Scenario_01 Verify the alert message while click Add to card without Price at step3
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Select the image and click on How much button
Then Verify the sub tab title at step3
Then CLick on the Add to card button at step3
Then Verify the alert message while click to add cart without price at step3



@Test218
Scenario: Scenario_01 Verify the Add to cart button functionality at step3
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Select the image and click on How much button
Then Verify the sub tab title at step3
Then Select the amount at step3
Then CLick on the Add to card button at step3


@Test219
Scenario: Scenario_01 Verify the sub tab ttile at step4
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Select the image and click on How much button
Then Verify the sub tab title at step3
Then Select the amount at step3
Then CLick on the Add to card button at step3
Then Verify the sub tab title at step4



@Test220
Scenario: Scenario_01 Verify the sub tab ttile at step4
When Do login with valid credentials
Then Click on the sqaure menu and than click on Gift card
Then Verify the step 1 sub tab text
Then Type the receipient information on step1
Then Click on the Pick a Gift card
Then Verify the sub tab title at step 2
Then Select the image and click on How much button
Then Verify the sub tab title at step3
Then Select the amount at step3
Then CLick on the Add to card button at step3
Then Verify the sub tab title at step4






