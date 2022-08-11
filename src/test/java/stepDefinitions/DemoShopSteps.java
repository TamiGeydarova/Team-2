package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.ShopPage;
import pageObjects.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DemoShopSteps extends GeneralSteps {
    private MainPage mainPage = new MainPage(driver);
    private ResultPage resultPage = new ResultPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private ShopPage shopPage = new ShopPage(driver);


    @Given("^I am on Account login webpage$")
    public void iAmOnMainWebpage() {
        driver.get("http://www.demoshop24.com/index.php?route=account/address");
    }

    @When("^I am logged in to registered account$")
    public void iAmLoggedIntoRegisteredAccount() throws InterruptedException {

        driver.get(shopPage.getLoginPageUrl());
        shopPage.enterExistingUserLogin();
        shopPage.clickSubmitLogin();
    }

    @Then("^Choose the product \"([^\"]*)\"$")
    public void chooseFirstProduct(String product) {
        shopPage.clickCategory();
        shopPage.clickSubCategory();
        shopPage.clickOnProduct();
    }

    @Then("^Add the product to cart$")
    public void addTheProductToCart() {
        shopPage.clickAddToCart();
        assertTrue(shopPage.checkIfTheProductIsAddedToCart());
    }

    @And("^View the shopping cart$")
    public void viewTheShoppingCart() {
        shopPage.clickShoppingCart();
    }

}
