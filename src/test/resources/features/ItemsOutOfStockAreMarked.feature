@Team2
Feature: Items That are out of stock - should be marked with *** and there should be notice in red

  Scenario: Item that is out of stock marked with *** and red text
    Given I am logged it to registered account
    And I navigate to homepage
    And I click Tablets menu
    When I add Samsung Galaxy Tab product to wishlist
    And I see success message for Samsung Galaxy Tab
    And I open wishlist page
    Then I see previously Galaxy Tab in wishlist
    And I click move to cart button
    And I navigate to shopping cart
    Then I see out of stock message
    And I see product is marked with 3 red stars
