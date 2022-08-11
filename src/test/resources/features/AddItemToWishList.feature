Feature: User adds 1 or more items to the wishlist and sees them in the wishlist


  Scenario: User adds 1 item to wishlist
    When I am logged it to registered account
    And I navigate to homepage
    And I click See all Desktops
    When I add Apple Cinema product to wishlist
    And I see success message for Apple Cinema
    And I open wishlist page
    Then I see previously selected Apple Cinema product in wishlist
