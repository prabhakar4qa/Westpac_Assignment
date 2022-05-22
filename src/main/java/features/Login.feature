Feature: Buggy cars users login
 	1. Verify user is able to login with valid & in valid credentials
  
  @Login @Smoke @Web @Buggy @Log_test1
  Scenario Outline: Verify user is able to login with valid & in valid credentials
    Given I launch the buggy application in a browser
    When I am on buggy rating screen
    And I enter the "<user_name>" and "<password>"
    And I click "Login" from the buggy rating screen
    Then I validate that the user "<result>" able to login
    
    Examples:
    |user_name          |password     |result   |
    |Buggy_User_1LcADE  |Testtest123! |is       | 
    |Buggy_User_xxxxx   |xxxxx        |is_not   |
    