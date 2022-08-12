@Team2
Feature: Wish List Tests

  Scenario: Wish List link should be present on the Top menu and show the count of items in the Wish List
    Given I am on login page
    When I login with the below user
      | email    | gizem@gizem.com |
      | password | 1234            |
    Then I assert Wish List count is "Wish List (0)"


  Scenario: From Products List page there should be a link "Add to Wish List" with heart icon which add item to the Wish List
    Given I am on login page
    When I login with the below user
      | email    | gizem@gizem.com |
      | password | 1234             |
    Then I assert Wish List count is "Wish List (0)"
    Then I click to "Tablets" category
    Then I click to Add to Wish List heart icon on "product list" page
    Then I check "Samsung Galaxy Tab" should be in success message
    Then I assert Wish List count is "Wish List (1)"
    Then I click to my Wish List
    Then I remove my Wish List



  Scenario:From Product page there should be a link "Add to Wish List" with heart icon to add item to the Wish list
    Given I am on login page
    When I login with the below user
      | email    | gizem@gizem.com |
      | password | 1234            |
    Then I assert Wish List count is "Wish List (0)"
    Then I click to "Tablets" category
    Then I click to "Samsung" product
    Then I click to Add to Wish List heart icon on "product" page
    Then I check "Samsung Galaxy Tab" should be in success message
    Then I assert Wish List count is "Wish List (1)"
    Then I click to my Wish List
    Then I remove my Wish List



  Scenario: Without user registered
    Given I am on homepage without registered
    Then I click to "Phones & PDAs" category
    Then I click to "iPhone" product
    Then I click to Add to Wish List heart icon on "product" page
    Then I check "iPhone" should be in success message
    Then I click to my Wish List
    Then I assert that page title is "Account Login"



  Scenario: Double click Wish List on same product
    Given I am on login page
    When I login with the below user
      | email    | gizem@gizem.com |
      | password | 1234            |
    Then I assert Wish List count is "Wish List (0)"
    Then I click to "Tablets" category
    Then I click to "Samsung" product
    Then I click to Add to Wish List heart icon on "product" page
    Then I click to Add to Wish List heart icon on "product" page
    Then I check "Samsung Galaxy Tab" should be in success message
    Then I assert Wish List count is "Wish List (1)"
    Then I click to my Wish List
    Then I remove my Wish List

  Scenario:click Wish List on different product
    Given I am on login page
    When I login with the below user
      | email    | gizem@gizem.com |
      | password | 1234            |
    Then I assert Wish List count is "Wish List (0)"
    Then I click to "Tablets" category
    Then I click to "Samsung" product
    Then I click to Add to Wish List heart icon on "product" page
    Then I check "Samsung Galaxy Tab" should be in success message
    Then I assert Wish List count is "Wish List (1)"
    Then I click to "Phones & PDAs" category
    Then I click to "iPhone" product
    Then I click to Add to Wish List heart icon on "product" page
    Then I check "iPhone" should be in success message
    Then I assert Wish List count is "Wish List (2)"
    Then I click to my Wish List
    Then I remove my Wish List
