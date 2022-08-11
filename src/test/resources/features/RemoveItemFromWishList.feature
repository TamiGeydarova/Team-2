Feature: User adds 1 item to the wishlist and removes it after


  Scenario: User adds 1 item to wishlist and removes it
    When I am logged it to registered account
    And I navigate to homepage
    And I click See all Desktops
    When I add Apple Cinema product to wishlist
    And I see success message for Apple Cinema
    And I open wishlist page
    Then I click remove Apple Cinema from wishlist
    And Apple Cinema is removed from wishlist
    And I see remove success message



