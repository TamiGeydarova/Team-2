package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ResultPage;
import pageObjects.ShoppingCartPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartStepDefinitions extends GeneralSteps{
    private MainPage mainPage = new MainPage(driver);
    private ResultPage resultPage = new ResultPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    @Given("^Login with Registered user \"([^\"]*)\"$")
    public void loginWithRegisteredUser(String email) {
        driver.openWebPage("");
        shoppingCartPage.performLogin("viki.vconnect@gmail.com");
    }


    @Then("^Choose the product \"([^\"]*)\" from the category \"([^\"]*)\"$")
    public void chooseTheProductFromTheCategory(String product, String category)  {
        shoppingCartPage.clickCategory();
        shoppingCartPage.clickSubCategory();
        shoppingCartPage.clickOnProduct();
    }

    @Then("^Add the product to cart$")
    public void addTheProductToCart() {
        shoppingCartPage.clickAddToCart();
        assertTrue(shoppingCartPage.checkIfTheProductIsAddedToCart());
    }

    @And("^View the shopping cart$")
    public void viewTheShoppingCart() {
        shoppingCartPage.clickShoppingCart();
    }

    @Then("^Ensure the Product features and prices on the shopping cart page$")
    public void ensureTheProductFeaturesOnTheShoppingCartPage(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        assertEquals(data.get(0).get("Product Name"), shoppingCartPage.getProductNameText());
        assertEquals(data.get(0).get("Model"), shoppingCartPage.getProductModelText());
        assertEquals(data.get(0).get("Quantity"),shoppingCartPage.getProductQuantityText());
        assertEquals(data.get(0).get("Unit Price"),shoppingCartPage.getProductUnitPriceText());
        assertEquals(data.get(0).get("Total"),shoppingCartPage.getProductTotalPriceText());

    }
}
