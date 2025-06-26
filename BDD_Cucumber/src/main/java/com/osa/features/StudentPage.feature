@regression
Feature: OSA forum login validation    

	Scenario: Verify forum login is working or not
		Given I am on OSAs home page
		And I click on Forum page
		And I enter username as "user1"
		And I enter password as "pass1"
		When I click on forum login button
		Then I should be able to see the student page
		And I close the browser
	@mytest
	Scenario: Verify forum login is working or not
		Given I am on OSAs home page
		And I click on Forum page
		And I enter username as "user2"
		And I enter password as "pass2"
		When I click on forum login button
		Then I should be able to see the student page
		And I close the browser
		
	Scenario: Verify forum login is working or not
		Given I am on OSAs home page
		And I click on Forum page
		And I enter username as "user3"
		And I enter password as "pass3"
		When I click on forum login button
		Then I should be able to see the student page
		And I close the browser	
    