Feature: Buggy cars users profile
 	1. Verify user is able to update the profile settings
  
  @Profile @Smoke @Web @Buggy @Prof_test1
  Scenario: Verify user is able to update the profile settings
    Given I launch the buggy application in a browser
    When I am on buggy rating screen
    Then I log into buggy application with valid credentials
    
    Given I Click on "Profile" from menu screen
    When I am on the edit profile page
    Then I update additional info fields gender, age, address, phone and hobby
    And I validate changes are saved or not