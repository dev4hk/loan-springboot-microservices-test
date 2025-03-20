@ApplicationDetail
Feature:

  Background:
    Given user is on login page
    When manager types manager credentials and click on sign in button
    Then manager is routed to manager summary page

  Scenario: Judge application
    Given manager is on application page
    When manager clicks on details button of application by customer with email "aaaa@aaaa.aaaa"
    And manager is routed to application detail page by customer with email "aaaa@aaaa.aaaa"
    And manager types judgement information
      | Key              | Value      |
      | Judgement Amount | 5000.00    |
      | Start Date       | 03/19/2025 |
      | End Date         | 03/19/2026 |
      | Pay Day          | 25         |
      | Interest         | 10         |
    And manager clicks on Submit Judgement button
    Then submit success message pops up
    And judgement information is updated with data
      | Key              | Value      |
      | Judgement Amount | 5,000.00   |
      | Start Date       | 2025-03-19 |
      | End Date         | 2026-03-19 |
      | Pay Day          | 25         |
      | Interest         | 10         |

  Scenario: Update application judgement
    Given manager is on application page
    When manager clicks on details button of application by customer with email "aaaa@aaaa.aaaa"
    And manager is routed to application detail page by customer with email "aaaa@aaaa.aaaa"
    And manager types judgement information
      | Key              | Value      |
      | Judgement Amount | 5000.00    |
      | Start Date       | 03/20/2025 |
      | End Date         | 03/20/2026 |
      | Pay Day          | 25         |
      | Interest         | 15         |
    And manager clicks on Update button
    Then submit success message pops up
    And judgement information is updated with data
      | Key              | Value      |
      | Judgement Amount | 5,000.00   |
      | Start Date       | 2025-03-20 |
      | End Date         | 2026-03-20 |
      | Pay Day          | 25         |
      | Interest         | 15         |
