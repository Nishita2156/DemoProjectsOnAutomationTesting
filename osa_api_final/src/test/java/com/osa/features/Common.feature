Feature: This feature file to setup for common steps
@Tests   
#@Tests its a kind of annotation like smoke ,regression
  Scenario: Common stesp scenarios
    Given I have completeted the authentication
    When I send a "GET" request to "/students/64a9d3d1f0dc7c9c00db86c7" endpoint
    Then I verify the response value for following fields