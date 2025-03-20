Feature: User Authentication

  Scenario: customer is able to go to register page
    Given user is on login page
    When customer clicks on Register link
    Then customer is routed to register page

  @Registration
  Scenario: customer is able to register
    Given customer is on register page
    When customer type all the customer information in the register form
    And customer clicks on Register button
    Then customer is routed to customer summary page

  Scenario: customer is able to go to login
    Given user is on login page
    When customer types customer credentials and click on sign in button
    Then customer is routed to customer summary page

  Scenario: manager is able to go to login
    Given user is on login page
    When manager types manager credentials and click on sign in button
    Then manager is routed to manager summary page
