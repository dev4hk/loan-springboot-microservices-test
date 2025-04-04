@CustomerCounsel
Feature: Customer Counsel
  Background:
    Given user is on login page
    When customer types customer credentials and click on sign in button
    Then customer is routed to customer summary page

  Scenario: Customer submit counsel
    Given customer is on counsel page
    When customer types counsel information
      | 1111111111 |
      | address1   |
      | address2   |
      | city       |
      | state      |
      | 11111      |
      | memo       |
    And customer clicks on counsel Submit button
    Then customer sees counsel information

  Scenario: Customer views counsel information
    Given customer is on counsel page
    When customer clicks to open memo
    Then customer is able to see the counsel memo

  Scenario: Customer views FAQ information
    Given customer is on counsel page
    When counsel FAQ question is clicked
    Then counsel FAQ answer is displayed


  Scenario: Customer updates counsel form
    Given customer is on counsel page
    When customer clicks update button
    And customer updates memo as "updated memo"
    And customer clicks on counsel Submit button
    And customer clicks to open memo
    Then counsel memo is updated as "updated memo"
