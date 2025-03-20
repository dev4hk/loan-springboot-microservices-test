@Customer @Repayment
Feature: Customer repayment

  Background:
    Given user is on login page
    When customer types customer credentials and click on sign in button
    Then customer is routed to customer summary page

  Scenario: Customer submits monthly repayment
    Given customer is on repayment page
    When customer types monthly repayment amount
    And customer clicks on repayment Submit button
    Then repayment successful message pops up
