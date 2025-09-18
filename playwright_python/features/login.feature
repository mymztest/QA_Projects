Feature: Login functionality

  Scenario Outline: Login with multiple credentials
    Given I open the login page
    When I login with username "<username>" and password "<password>"
    Then I should see "<result>"

    Examples:
      | username       | password      | result  |
      | standard_user  | secret_sauce  | Swag Labs |
      | locked_user    | secret_sauce  | Epic sadface: Username and password do not match any user in this service |
