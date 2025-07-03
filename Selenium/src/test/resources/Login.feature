Feature: Login/Logout to Swag app


  @test1
  Scenario: Log out From App
    Given I am on swag app
    When I enter standard_user and secret_sauce
    And I click on Login button
    Then I am on the main Page
    And I Select the product pan
    Then I click on Logout button
    Then Verify the Logout successfully



