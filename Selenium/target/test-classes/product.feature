Feature: Select Product

  @test3
  Scenario: Select the Product
    Given I am on swag app
    When I enter standard_user and secret_sauce
    And I click on Login button
    Then I am on the main Page
    And Add following products into cart and Verify the total items in cart
      | Sauce Labs Fleece Jacket|Test.allTheThings() T-Shirt (Red)|Sauce Labs Onesie| Sauce Labs Backpack|
