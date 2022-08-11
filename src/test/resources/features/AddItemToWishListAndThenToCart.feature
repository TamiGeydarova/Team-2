Feature: User adds 1 or more items to the wishlist and then adds them to cart


  Scenario: User adds 1 item to wishlist and from wishlist to cart
    When I am logged it to registered account
    And I navigate to homepage
    And I click Cameras menu
    When I add Canon EOS product to wishlist
    And I see success message for Canon EOS
    And I open wishlist page
    Then I see previously selected Canon EOS in wishlist
    And I click move to cart button
    And I click add item to cart on PDP page
    And I navigate to shopping cart
    Then I see previously selected Canon EOS in cart