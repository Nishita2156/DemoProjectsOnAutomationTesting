
@ExcelSearch
Feature: Etsy search with excel data
Scenario: Search for multiple products from excel
    Given user launches etsy website
    Then  user searches all products from excel sheets and validates result
