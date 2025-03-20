@Terms
Feature: Terms Management

  Background:
    Given user is on login page
    When manager types manager credentials and click on sign in button
    Then manager is routed to manager summary page

  Scenario Outline: create terms
    Given manager is on terms page
    When manager open terms form
    And manager types terms name "<name>" and detail "<detail>"
    And manager clicks on submit button
    Then successful create message pops up
    Examples:
      | name  | detail  |
      | term1 | detail1 |
      | term2 | detail2 |
      | term3 | detail3 |

  Scenario: update term
    Given manager is on terms page
    When manager clicks on update button of name "term1"
    And manager types terms name "updated name" and detail "updated detail"
    And manager clicks on submit button
    Then successful update message pops up
    Then term name "updated name" is displayed in table

  Scenario: delete term
    Given manager is on terms page
    When manager deletes term "updated name"
    Then term "updated name" is deleted


