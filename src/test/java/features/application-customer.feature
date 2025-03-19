@Application @Customer
Feature: Application

  Background:
    Given user is on login page
    When customer types customer credentials and click on sign in button
    Then customer is routed to customer summary page

  Scenario: Customer views FAQ information
    Given customer is on application page
    When application FAQ question is clicked
    Then application FAQ answer is displayed

  Scenario: Customer views application form
    Given customer is on application page
    Then customer is able to see application form

  Scenario: Customer submits application form
    Given customer is on application page
    When customer fills out application form with data
      | 1234567890 |
      | 5000.00    |
    And customer clicks on application Submit button
    And customer agrees terms and submit
    Then successful application creation message pops up
    And application information is displayed with data
      | 1234567890 |
      | 5000.00    |
