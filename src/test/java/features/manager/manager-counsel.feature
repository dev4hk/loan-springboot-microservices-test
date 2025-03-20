@ManagerCounsel
Feature: Manager checks counsel request

  Background:
    Given user is on login page
    When manager types manager credentials and click on sign in button
    Then manager is routed to manager summary page

  Scenario: Manager views counsel request detail
    Given manager is on counsel page
    When manager clicks on open details button of counsel request by user with email "aaaa@aaaa.aaaa"
    Then counsel request detail by user with email "aaaa@aaaa.aaaa" is displayed


  Scenario: Manager completes counsel request
    Given manager is on counsel page
    When manager clicks on open details button of counsel request by user with email "aaaa@aaaa.aaaa"
    And manager clicks on Mark as Complete button
    Then request is marked as Complete