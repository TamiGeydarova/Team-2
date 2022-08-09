package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ResultPage;
import pageObjects.ShoppingCartPage;

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
}
