Feature: API test

  @DEMO002
  Scenario Outline: Verify Get API
    When I send get request to this url and validate the status <statuscode>
    Then I verify Api response parameter "data[0].id" is eqaul to <idvalue>
    And I verify Api response parameter "data[1].id" is eqaul to <idvalue1>

    Examples:
     | statuscode|idvalue|idvalue1|
     | 200       |7      |8       |

  @DEMO003
  Scenario Outline: Verify Post API
    When I send API request using following parameters for URL "<url>"
    |name|job |
    |Test |tester  |
    #Then I verify Api response status code is <statuscode>

    Examples:
      | statuscode|url|
      | 201       |https://reqres.in/api/users|