$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/com/osa/features/ForumLogin.feature");
formatter.feature({
  "name": "OSA forum testing",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify forum page title",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@smoke"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I click on Forum Page",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_Forum_Page()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException: Cannot invoke \"com.osa.pages.ForumPage.clickOnLoginButton()\" because \"this.fp\" is null\r\n\tat com.osa.steps.FoumLogin.i_click_on_Forum_Page(FoumLogin.java:100)\r\n\tat ✽.I click on Forum Page(file:///C:/Users/Nishita%20Jannat%20Alam/Desktop/NewWorkspace/BDD_Cucumber/src/main/java/com/osa/features/ForumLogin.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I verify the forum page title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_verify_the_forum_page_title()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verify forum login is working or not",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I click on Forum page",
  "keyword": "And "
});
formatter.step({
  "name": "I enter username as \"\u003cusername\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I enter password as \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I click on forum login button",
  "keyword": "When "
});
formatter.step({
  "name": "I should be able to see the student page",
  "keyword": "Then "
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "username1",
        "password1"
      ]
    },
    {
      "cells": [
        "username2",
        "password2"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify forum login is working or not",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I click on Forum page",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_Forum_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter username as \"username1\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_username_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter password as \"password1\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_password_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on forum login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_forum_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to see the student page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_should_be_able_to_see_the_student_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify forum login is working or not",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "I click on Forum page",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_Forum_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter username as \"username2\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_username_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter password as \"password2\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_password_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on forum login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_forum_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to see the student page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_should_be_able_to_see_the_student_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/main/java/com/osa/features/HomePage.feature");
formatter.feature({
  "name": "Home Page feature",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "name": "Verify home page title",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get the home page title",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_get_the_home_page_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the title",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_verify_the_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/main/java/com/osa/features/Service.feature");
formatter.feature({
  "name": "Verify the title of the service page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on service button",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.user_clicks_on_service_button()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException: Cannot invoke \"com.osa.pages.ServicePage.clickOnServicesButton()\" because \"this.sep\" is null\r\n\tat com.osa.steps.FoumLogin.user_clicks_on_service_button(FoumLogin.java:38)\r\n\tat ✽.user clicks on service button(file:///C:/Users/Nishita%20Jannat%20Alam/Desktop/NewWorkspace/BDD_Cucumber/src/main/java/com/osa/features/Service.feature:5)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "verify the title of the service page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.verify_the_title_of_the_service_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/main/java/com/osa/features/StudentPage.feature");
formatter.feature({
  "name": "OSA forum login validation",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "name": "Verify forum login is working or not",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Forum page",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_Forum_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter username as \"user1\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_username_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter password as \"pass1\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_password_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on forum login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_forum_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to see the student page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_should_be_able_to_see_the_student_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify forum login is working or not",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    },
    {
      "name": "@mytest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Forum page",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_Forum_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter username as \"user2\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_username_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter password as \"pass2\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_password_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on forum login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_forum_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to see the student page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_should_be_able_to_see_the_student_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify forum login is working or not",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on OSAs home page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_am_on_OSAs_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Forum page",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_Forum_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter username as \"user3\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_username_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter password as \"pass3\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_enter_password_as(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on forum login button",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_click_on_forum_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to see the student page",
  "keyword": "Then "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_should_be_able_to_see_the_student_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I close the browser",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.FoumLogin.i_close_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});