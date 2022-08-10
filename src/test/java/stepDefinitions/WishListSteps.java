package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.Map;
import java.util.Objects;


public class WishListSteps {
    private WebDriver driver;

    static LoginPage loginPage;
    static ProductListPage productListPage;
    static ProductPage productPage;

    static HomePage homePage;

    static MyWishListPage myWishListPage;


    public WishListSteps() {
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(Hooks.driver, LoginPage.class);
        productListPage = PageFactory.initElements(Hooks.driver, ProductListPage.class);
        productPage = PageFactory.initElements(Hooks.driver, ProductPage.class);
        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
        myWishListPage = PageFactory.initElements(Hooks.driver, MyWishListPage.class);
    }


    @Given("^I am on login page$")
    public void iAmOnLoginPage() {
        driver.get(loginPage.getPageUrl());
    }

    @When("^I login with the below user$")
    public void iLoginWithTheBelowUser(Map<String, String> valuesToEnter) {
        loginPage.enterMail(valuesToEnter.get("email"));
        loginPage.enterPassword(valuesToEnter.get("password"));
        loginPage.clickLoginButton();
    }

    @Then("^I assert Wish List count is \"([^\"]*)\"$")
    public void iAssertWishListCountIs(String wishListCount) throws Throwable {
        homePage.checkWishListCount(wishListCount);
    }


    @Then("^I click to \"([^\"]*)\" category$")
    public void iClickToCategory(String categoryName) throws Throwable {
        if (Objects.equals(categoryName, "Tablets")) {
            homePage.selectTabletCategory();
        } else if (Objects.equals(categoryName, "Cameras")) {
            homePage.selectCamerasCategory();
        } else if (Objects.equals(categoryName, "PhonesPDA")) {
            homePage.selectPhonesPDACategory();
        }
    }
    @Then("^I click to Add to Wish List heart icon on product list page$")
    public void iClickToAddToWishList() throws Throwable {
        productListPage.clickAddWishListButton();

    }

    @Then("^I check success message$")
    public void iCheckSuccessMessage() throws Throwable {
        productListPage.checkWishListSuccessMessage();
    }


    @Then("^I should see success message$")
    public void iShouldSeeSuccessMessage() throws Throwable {
        productPage.checkWishListSuccessMessageOnProduct();

    }

    @Then("^I click to Add to Wish List heart icon on product  page$")
    public void iClickToAddToWishListHeartIconOnProductPage() throws Throwable {
        productPage.clickAddWishListButtonOnProduct();
    }


    @Then("^I click to my Wish List$")
    public void iClickToMyWishList() throws Throwable {
        homePage.iAmOnWistList();

    }

    @Then("^I remove my Wish List$")
    public void iRemoveMyWishList() throws Throwable {
        myWishListPage.iAmRemoveMyWishList();
    }


    @Given("^I am on homepage without registered$")
    public void iAmOnHomepageWithoutRegistered() {

        driver.get(homePage.getHomePageUrl());
    }

    @Then("^I should direct login page$")
    public void iShouldDirectLoginPage() {
        loginPage.checkLoginUrl();
    }

    @Then("^I click to \"([^\"]*)\" product$")
    public void iClickToProduct(String clickToProduct) throws Throwable {

        if (Objects.equals(clickToProduct, "Samsung")) {
            productListPage.clickSamsungProduct();
        } else if (Objects.equals(clickToProduct, "Canon")) {
            productListPage.clickCanonProduct();
        } else if (Objects.equals(clickToProduct, "iPhone")) {
            productListPage.clickIphoneProduct();
        }

    }



}

