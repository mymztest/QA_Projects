Feature: Invalid Login Verification

  Background:Logged in to app
    Given I am on swag app

  @test2
  Scenario Outline: Verify negative scenario for login
    When I enter <username> and <password>
    And I click on Login button
    Then Verify the error massage <errormessage>
    Examples:
      | username     |password      | errormessage|
      |              |              |Epic sadface: Username and password do not match any user in this service|
      |              |secret_sauce  |Epic sadface: Username is required                                       |
      |standard_user |              |Epic sadface: Password is required                                       |
      |              |              |Epic sadface: Username is required                                       |