@regression
Feature: Shopping Cart - Add and view Cart


    @Tag1
    Scenario: Add a product to the shopping cart, View cart and check prices
        Given Login with Registered user "viki.vconnect@gmail.com"
        Then  Choose the product "HP LP3065" from the category "Desktops"
        Then  Add the product to cart
        And   View the shopping cart
        Then  Ensure the Product features and prices on the shopping cart page
        |Product Name |  Model     | Quantity | Unit Price   |   Total   |
        |HP LP3065    | Product 21 |     1    |   $122.00	|   $122.00	|









