
@smoke @sanity
Feature: Etsy Product search
Scenario Outline: user should be able to search for multiple products and view relevant results
  Given user launches the etsy website
  When user searches for "<Product>" using search bar
  Then search results page should display relevant items for "<Product>"
  And the page title should reflect the searched "<Product>"
  And the browser url should include the search term "<Product>"
  And filtering options should be available on the left side
  And a list of product results should be visible to the user
  
  Examples:
  |Product|
  ||
  ||
  ||
  || 
  
   
  