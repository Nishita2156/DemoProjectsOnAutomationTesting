
Feature: OSA forum testing
	Background:
		Given I am on OSAs home page
	@smoke @regression
	Scenario: Verify forum page title
		When I click on Forum Page
		Then I verify the forum page title  
		And I close the browser
	@regression
	Scenario Outline: Verify forum login is working or not
		And I click on Forum page
		And I enter username as "<username>"
		And I enter password as "<password>"
		When I click on forum login button
		Then I should be able to see the student page
		And I close the browser	
		Examples:
		|username|password|
		|username1	 |password1		|
		|username2	 |password2		|
