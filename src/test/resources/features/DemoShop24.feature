Feature: DemoShop24 feature

  Background:
    Given I am on Account login webpage
    Then I am logged in to registered account

  @Test1
  Scenario: Item count and prices should be displayed correctly on shopping cart button / link
    Given Choose the product "iPhone"
    Then  Add the product to cart
    And View the shopping cart
  #  Then Ensure count and price are correct
  #  Then Add multiple items to the cart



  @Test2
  Scenario: Should be possibility increase / decrease product count in shopping cart
    Given Choose the product "iPhone"
    Then Increase the quantity of the item from the cart
    And Add the same item multiple times
    Then Add multiple items to the cart
    And Remove some items from the cart
    When Remove all items from the cart

  @Test3
  Scenario: Prices should be calculated correctly on item list changes
    Given