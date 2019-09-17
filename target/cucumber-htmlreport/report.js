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
  "duration": 19086325214,
  "status": "passed"
});
formatter.scenario({
  "line": 202,
  "name": "Scenario_01 Verify the sub tab ttile at step4",
  "description": "",
  "id": "gift-page-of-umeand-test;scenario-01-verify-the-sub-tab-ttile-at-step4",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 201,
      "name": "@Test219"
    }
  ]
});
formatter.step({
  "line": 203,
  "name": "Do login with valid credentials",
  "keyword": "When "
});
formatter.step({
  "line": 204,
  "name": "Click on the sqaure menu and than click on Gift card",
  "keyword": "Then "
});
formatter.step({
  "line": 205,
  "name": "Verify the step 1 sub tab text",
  "keyword": "Then "
});
formatter.step({
  "line": 206,
  "name": "Type the receipient information on step1",
  "keyword": "Then "
});
formatter.step({
  "line": 207,
  "name": "Click on the Pick a Gift card",
  "keyword": "Then "
});
formatter.step({
  "line": 208,
  "name": "Verify the sub tab title at step 2",
  "keyword": "Then "
});
formatter.step({
  "line": 209,
  "name": "Select the image and click on How much button",
  "keyword": "Then "
});
formatter.step({
  "line": 210,
  "name": "Verify the sub tab title at step3",
  "keyword": "Then "
});
formatter.step({
  "line": 211,
  "name": "Select the amount at step3",
  "keyword": "Then "
});
formatter.step({
  "line": 212,
  "name": "CLick on the Add to card button at step3",
  "keyword": "Then "
});
formatter.step({
  "line": 213,
  "name": "Verify the sub tab title at step4",
  "keyword": "Then "
});
formatter.match({
  "location": "GiftPageTest.type_logincredentials()"
});
formatter.result({
  "duration": 2204243631,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.click_square_menu()"
});
formatter.result({
  "duration": 9487420955,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.verify_title_step1()"
});
formatter.result({
  "duration": 410668252,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.type_receipient_information()"
});
formatter.result({
  "duration": 2642886998,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.click_on_pick_gift_card()"
});
formatter.result({
  "duration": 307951040,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Verify_the_sub_tab_title_at_step_2()"
});
formatter.result({
  "duration": 267109455,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Select_the_image_and_click_on_How_much_button()"
});
formatter.result({
  "duration": 7456476706,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Verify_the_sub_tab_title_at_step3()"
});
formatter.result({
  "duration": 6637502036,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Select_the_amount_at_step3()"
});
formatter.result({
  "duration": 492837066,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.CLick_on_the_Add_to_card_button_at_step3()"
});
formatter.result({
  "duration": 533591052,
  "status": "passed"
});
formatter.match({
  "location": "GiftPageTest.Verify_the_sub_tab_title_at_step4()"
});
formatter.result({
  "duration": 360014985,
  "status": "passed"
});
});