@Regression
Feature: Tietoevry website testing

  @Smoke
  Scenario: Check career open positions
    Given navigate to home page
    When open "Careers" page
    Then list all open positions
    And list open positions with text "engineer"
    And verify open position list is correct in "lithuania"
      | (Senior) Full Stack Developer, Data & Analytics - Tietoevry Care (m/f/d) |
      | DevOps Engineer Data & Analytics - Tietoevry Care (m/f/d)                |
      | D365 CRM consultant                                                      |
      | Data Engineer Data & Analytics - Tietoevry Care (m/f/d)                  |
  @Smoke
  Scenario Outline: Check available pages
    Given navigate to home page
    When open "<pageName>" page
    Examples:
      | pageName   |
      | Services   |
      | About us   |
      | Careers    |
      | Software   |
      | Industries |
