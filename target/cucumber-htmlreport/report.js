$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/features/GiftPage.feature");
formatter.feature({
  "line": 2,
  "name": "Gift page of Umeand Test",
  "description": "In order to test functionality of Gift page\nWe will test Giftpage feature with different combination of data to test the Giftpage functionality",
  "id": "gift-page-of-umeand-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CompanyPage"
    }
  ]
});
formatter.background({
  "line": 6,
  "name": "Initialize resources for test script",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 7,
  "name": "Initialize resources in the beginning of each scenario for Giftpage",
  "keyword": "Given "
});
formatter.match({
  "location": "GiftPageTest.Initialize_Resources()"
});
formatter.result({
  "duration": 17525817720,
  "status": "passed"
});
formatter.scenario({
  "line": 188,
  "name": "Scenario_01 Verify the Add to cart button functionality at step3",
  "description": "",
  "id": "gift-page-of-umeand-test;scenario-01-verify-the-add-to-cart-button-functionality-at-step3",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 187,
      "name": "@Test218"
    }
  ]
});
formatter.step({
  "line": 189,
  "name": "Do login with valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 190,
  "name": "Click on the sqaure menu and than click on Gift card",
  "keyword": "Then "
});
formatter.step({
  "line": 191,
  "name": "Verify the step 1 sub tab text",
  "keyword": "Then "
});
formatter.step({
  "line": 192,
  "name": "Type the receipient information on step1",
  "keyword": "Then "
});
formatter.step({
  "line": 193,
  "name": "Click on the Pick a Gift card",
  "keyword": "Then "
});
formatter.step({
  "line": 194,
  "name": "Verify the sub tab title at step 2",
  "keyword": "Then "
});
formatter.step({
  "line": 195,
  "name": "Select the image and click on How much button",
  "keyword": "Then "
});
formatter.step({
  "line": 196,
  "name": "Verify the sub tab title at step3",
  "keyword": "Then "
});
formatter.step({
  "line": 197,
  "name": "Select the amount at step3",
  "keyword": "Then "
});
formatter.step({
  "line": 198,
  "name": "CLick on the Add to card button at step3",
  "keyword": "Then "
});
formatter.match({
  "location": "GiftPageTest.type_logincredentials()"
});
formatter.result({
  "duration": 2086616808,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.click_square_menu()"
});
formatter.result({
  "duration": 9285851656,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.verify_title_step1()"
});
formatter.result({
  "duration": 352695083,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.type_receipient_information()"
});
formatter.result({
  "duration": 2676916737,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.click_on_pick_gift_card()"
});
formatter.result({
  "duration": 375969603,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Verify_the_sub_tab_title_at_step_2()"
});
formatter.result({
  "duration": 289036466,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Select_the_image_and_click_on_How_much_button()"
});
formatter.result({
  "duration": 6853241038,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Verify_the_sub_tab_title_at_step3()"
});
formatter.result({
  "duration": 5980712465,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Select_the_amount_at_step3()"
});
formatter.result({
  "duration": 424173179,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.CLick_on_the_Add_to_card_button_at_step3()"
});
formatter.result({
  "duration": 449470406,
  "status": "passed"
});
});