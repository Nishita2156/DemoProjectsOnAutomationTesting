Feature: Search and place the order for Products
@PlaceOrder
Scenario Outline: Search experience for  product search in both home page and offers page

Given User is on GreenCart Landing page 
When  User searched with shortname <Name> and extracted actual name of product
And  Added "3" items of selected product to the cart
Then User proceeds to checkout page and vaidate the <Name> items in checkout page
And User has ability to enter promo code and checkout product

Examples:
|Name|
|Tom|
