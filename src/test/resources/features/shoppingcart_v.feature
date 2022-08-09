@regression
Feature: Shopping Cart - Add and view Cart

    @Tag1
    Scenario: Add a product cart and View cart and check prices

        Given Login with Registered user "viki.vconnect@gmail.com"
        #When  The user is logged In Successfully
        Then  Choose the product "HP LP3065" from the category "Desktops"
        Then  Add the product to cart
        And   View the shopping cart
        #Then  Ensure the Product/ model/Qty on the shopping cart page
        #And   Ensure the Prices on the shopping cart page








