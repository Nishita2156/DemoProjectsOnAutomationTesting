Feature: Automation Practice App Testing

  Scenario: User Registration and Login
    Given the user launches the automation app
    When the user registers with username "testuser" and password "testpass"
    And the user logs in with username "testuser" and password "testpass"
    Then the user should see the dashboard

  Scenario: Modal and Popup Test
    Given the user is logged in
    When the user opens the modal
    Then the modal should display correct content

  Scenario: Hover and List Update
    Given the user is logged in
    When the user hovers over the menu
    Then the hover menu should appear
    When the user adds a new list item
    Then the item count should increase
