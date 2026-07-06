Feature: Search and place the order for 
@OffersPage
Scenario Outline: Search experience for  product search in both home page and offers page

Given User is on GreenCart Landing page 
When  User searched with shortname <Name> and extracted actual name of product
Then  User searched for <Name> shortname in offers page to check if product exists

Examples:
|Name|
|Tom|
|Beet|