@Application @Manager
Feature: Application

  Background:
    Given user is on login page
    When manager types manager credentials and click on sign in button
    Then manager is routed to manager summary page

  Scenario: Counts number of applications
    Then number of applications is not zero

  Scenario: Manager views application table
    Given manager is on application page
    When application data table is displayed
    Then application count in table is not zero
    And application from customer email "aaaa@aaaa.aaaa" exists

  Scenario: Manager views application detail
    Given manager is on application page
    When manager clicks on details button of application by customer with email "aaaa@aaaa.aaaa"
    Then manager is routed to application detail page by customer with email "aaaa@aaaa.aaaa"

    @EntrySubmission
  Scenario: Manager submit entry
    Given manager is on application page
    When manager clicks on details button of application by customer with email "aaaa@aaaa.aaaa"
    Then manager is routed to application detail page by customer with email "aaaa@aaaa.aaaa"
    When manager type entry amount "5000"
    And manager clicks on Payout button
    Then entry amount of "$5,000,00" is displayed