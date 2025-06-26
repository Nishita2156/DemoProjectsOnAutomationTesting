@regression
Feature: Home Page feature
  @smoke
  Scenario: Verify home page title
    Given I am on OSAs home page
    When I get the home page title
    Then I verify the title
    And I close the browser
