Feature: User adds 1 or more items to the wishlist and sees them in the wishlist

  @Test
  Scenario: User adds 1 item to wishlist
    When I am logged it to registered account
    And I navigate to homepage
    And I click See all Desktops
    When I add 1 product to wishlist
    And I see success message
    And I open wishlist page
    Then I see previously selected product in wishlist



