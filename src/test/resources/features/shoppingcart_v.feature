@regression
Feature: Shopping Cart - Add and view Cart
    @smokeTest
    Scenario: Add a product to the shopping cart, View cart and check prices
        Given Login with Registered user "viki.vconnect@gmail.com"
        Then  Choose the product "HP LP3065" from the category "Desktops" SubCategory "Show All Desktops"
        Then  Add the product to cart
        And Check if the product is added to cart
        And   View the shopping cart
        Then  Ensure the Product features and prices on the shopping cart page
        |Product Name |  Model     | Quantity | Unit Price   |   Total   |
        |HP LP3065    | Product 21 |     1    |   $122.00	|   $122.00	|

    @smokeTest
    Scenario: Product Feature page validation
        Given Login with Registered user "viki.vconnect@gmail.com"
        Then Choose the product "Apple Cinema 30" from the category "Desktops" SubCategory "Show All Desktops"
        Then Enter all the required fields on the product page
            |Product Name     |  Category | Sub Category       | Radio   |   Checkbox | Text  |Select  | Textarea   |Date      | Time  | DateTime         | Quantity |
            |Apple Cinema 30  | Desktops  | Show All Desktops  |   6	 |   10	      | Test  | 3      |  comments  |2011-02-20| 10:00 | 2011-02-20 22:25 |  1       |
        And  Add the product to cart
      #  Then Repeat Step 3 without uploading the "File" in  productpage "Apple Cinema 30"
      #  And Add the product to cart

    @smokeTest2
    Scenario:  Shopping Cart Visibility on top menu and right menu
        Given Login with Registered user "viki.vconnect@gmail.com"
        Then  Choose the product "Samsung SyncMaster 941BW" from the category "Components"
        And  Check if the "Shopping Cart" button is displayed at Top Menu and other from right top menu










