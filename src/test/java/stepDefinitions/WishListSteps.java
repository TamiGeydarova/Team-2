
package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Objects;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WishListSteps extends GeneralSteps {
    private LoginPageShop loginPageShop = new LoginPageShop(driver);
    private ProductListPage productListPage = new ProductListPage(driver);
    private ProductPage productPage = new ProductPage(driver);
    private HomePage homePage = new HomePage(driver);
    private MyWishListPage myWishListPage = new MyWishListPage(driver);



    @Given("^I am on login page$")
    public void iAmOnLoginPage() {
        driver.get(loginPageShop.getPageUrl());
    }

    @When("^I login with the below user$")
    public void iLoginWithTheBelowUser(Map<String, String> valuesToEnter) {
        loginPageShop.enterMail(valuesToEnter.get("email"));
        loginPageShop.enterPassword(valuesToEnter.get("password"));
        loginPageShop.clickLoginButton();
    }

    @Then("^I assert Wish List count is \"([^\"]*)\"$")
    public void iAssertWishListCountIs(String wishListCount) throws Throwable {
        homePage.checkWishListCount(wishListCount);
    }


    @Then("^I click to \"([^\"]*)\" category$")
    public void iClickToCategory(String categoryName) throws Throwable {
        if (Objects.equals(categoryName, "Tablets")) {
            homePage.selectTabletCategory();
        } else if (Objects.equals(categoryName, "Phones & PDAs")) {
            homePage.selectPhonesPDACategory();
        }

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

    @Then("^I click to \"([^\"]*)\" product$")
    public void iClickToProduct(String clickToProduct) throws Throwable {
        if (Objects.equals(clickToProduct, "Samsung")) {
            productListPage.clickSamsungProduct();
        } else if (Objects.equals(clickToProduct, "iPhone")) {
            productListPage.clickIphoneProduct();
        }

    }

    @Then("^I check \"([^\"]*)\" should be in success message$")
    public void iCheckShouldBeInSuccessMessage(String productName) throws Throwable {
        productListPage.checkSuccessMessage(productName);
    }

    @Then("^I click to Add to Wish List heart icon on \"([^\"]*)\" page$")
    public void iClickToAddToWishListHeartIconOnPage(String pageName) throws Throwable {
        if (Objects.equals(pageName, "product list")) {
            productListPage.clickAddWishListButton();
        } else if (Objects.equals(pageName, "product")) {
            productPage.clickAddWishListButtonOnProduct();
        }
    }

    @Then("^I assert that page title is \"([^\"]*)\"$")
    public void iAssertThatPageTitleIs(String pageTitle) throws Throwable {
        assertEquals(driver.getTitle(), pageTitle);
    }

    @Then("^i close to driver$")
    public void iCloseToDriver() {
        driver.close();
    }



}
