Feature: Buggy Cars Registration
 	1. Verify new user is able to complete the registration process
  
  @Register @Smoke @Web @Buggy @Reg_test1
  Scenario: Verify new user is able to complete the registration process
    Given I launch the buggy application in a browser
    When I am on buggy rating screen
    Then I click "Register" from the buggy rating screen
    
    When I am on buggy rating registration screen
    And I enter the valid details and complete the sign up
    Then I validate the registration success message for new user