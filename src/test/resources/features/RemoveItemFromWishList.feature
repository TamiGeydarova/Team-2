Feature: User adds 1 item to the wishlist and removes it after

  @Test
  Scenario: User adds 1 item to wishlist and removes it
    When I am logged it to registered account
    And I navigate to homepage
    And I click See all Desktops
    When I add 1 product to wishlist
    And I see success message
    And I open wishlist page
    Then I click remove item from wishlist
    And Item is removed from wishlist
    And I see remove success message



