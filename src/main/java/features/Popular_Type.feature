Feature: Buggy Popular car features
 	1. Verify user is able to vote the popular model car
 	2. Verify each car model & make navigations form overall rating screen
 
  Background:  
  		Given I launch the buggy application in a browser

  @Popular @Smoke @Web @Buggy @Populr_test1
  Scenario: Verify user is able to vote the popular model car
   	When I am on buggy rating screen
    Then I log into buggy application with new user every time
    
    Given I click on the item under "Popular Model"
    When I am on popular model screen
    And I vote for the model
    Then I validate the vote count updated for the model
    And I Logout from the application
    
    
  @Popular @Smoke @Web @Buggy @Populr_test2
  Scenario: Verify each car model & make navigations form overall rating screen
   	When I am on buggy rating screen
    Then I log into buggy application with valid credentials
    
    Given I click on the item under "Overall Rating"
    When I am on Overall Rating screen
   	Then I validate the user is able to navigate each model and make from rating screen
    
    
    