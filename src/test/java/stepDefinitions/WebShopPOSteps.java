package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pageObjects.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class WebShopPOSteps extends GeneralSteps {
    private WebShopHomePagePO webShopHomePagePO = new WebShopHomePagePO(driver);
    private WebShopLoginPagePO webShopLoginPagePO = new WebShopLoginPagePO(driver);
    private WebShopWishlistPagePO webShopWishlistPagePO = new WebShopWishlistPagePO(driver);



    @Given("^I am logged it to registered account$")
    public void iAmLoggedIntoRegisteredAccount() throws InterruptedException {
        driver.get(webShopLoginPagePO.getLoginPageUrl());
        webShopLoginPagePO.enterExistingUserLogin();
        webShopLoginPagePO.submitLoginBtn.click();
    }

    @And("^I navigate to homepage$")
    public void iNavigateToHomePage() throws InterruptedException {
        webShopHomePagePO.getHomePageUrl();

    }


    @And("^I click See all Desktops$")
    public void iClickSeeAllDesktops() {
        webShopHomePagePO.desktopsMenuBtn.click();
        webShopHomePagePO.seeAllDesktopsLink.click();
    }

    @When("^I add 1 product to wishlist$")
    public void iAddDesktopsItemToWishlist() {
        webShopHomePagePO.desktopsFirstItemWishlistBtn.click();
    }

    @And("^I see success message$")
    public void iSeeSuccessMsg() {
        assertTrue(webShopHomePagePO.successMsg.isDisplayed());
        assertEquals("Success: You have added Apple Cinema 30\" to your wish list!\n×", webShopHomePagePO.successMsg.getText());
    }

    @And("^I open wishlist page$")
    public void iOpenWishlistPage() {
        webShopHomePagePO.wishlistPageLinkBtn.click();
        assertEquals("http://www.demoshop24.com/index.php?route=account/wishlist",driver.getCurrentUrl());

    }

    @Then("^I see previously selected product in wishlist$")
    public void iSeeSelectedProductInWishlist() {
        assertTrue(webShopWishlistPagePO.appleCinemaItem.isDisplayed());
    }


    @Then("^I click remove item from wishlist$")
    public void iClickRemoveItemWishlist() {
        webShopWishlistPagePO.removeFirstItemFromWishListBtn.click();
    }

    @And("^Item is removed from wishlist$")
    public void firstItemRemovedFromWishlist() {
        assertTrue(webShopWishlistPagePO.checkWishlistIsEmpty());
    }

    @And("^I see remove success message$")
    public void iSeeRemoveSuccessMsg() {
        assertTrue(webShopHomePagePO.successMsg.isDisplayed());
        assertEquals("Success: You have modified your wish list!\n" +
                "×", webShopHomePagePO.successMsg.getText());
    }






}
