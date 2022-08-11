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
    public void iAmLoggedIntoRegisteredAccount() {
        driver.get(webShopLoginPagePO.getLoginPageUrl());
        webShopLoginPagePO.enterExistingUserLogin();
        webShopLoginPagePO.submitLoginBtn.click();
    }

    @And("^I navigate to homepage$")
    public void iNavigateToHomePage() {
        webShopHomePagePO.getHomePageUrl();

    }


    @And("^I click See all Desktops$")
    public void iClickSeeAllDesktops() {
        webShopHomePagePO.desktopsMenuBtn.click();
        webShopHomePagePO.seeAllDesktopsLink.click();
    }

    @When("^I add Apple Cinema product to wishlist$")
    public void iAddAppleCinemaItemToWishlist() {
        webShopHomePagePO.addFirstItemWishlistBtn.click();
    }

    @And("^I see success message for Apple Cinema$")
    public void iSeeSuccessMsgAppleCinema() {
        assertTrue(webShopHomePagePO.successMsg.isDisplayed());
        assertEquals("Success: You have added Apple Cinema 30\" to your wish list!\n×", webShopHomePagePO.successMsg.getText());
    }

    @And("^I open wishlist page$")
    public void iOpenWishlistPage() {
        webShopHomePagePO.wishlistPageLinkBtn.click();
        assertEquals("http://www.demoshop24.com/index.php?route=account/wishlist",driver.getCurrentUrl());

    }

    @Then("^I see previously selected Apple Cinema product in wishlist$")
    public void iSeeAppleCinemaProductInWishlist() {
        assertTrue(webShopWishlistPagePO.appleCinemaItem.isDisplayed());
    }


    @Then("^I click remove Apple Cinema from wishlist$")
    public void iClickRemoveAppleCinemaWishlist() {
        webShopWishlistPagePO.removeFirstItemFromWishListBtn.click();
    }

    @And("^Apple Cinema is removed from wishlist$")
    public void iRemoveAppleCinemaFromWishlist() {
        assertFalse(webShopWishlistPagePO.checkAppleCinemaItemIsRemoved());
    }

    @And("^I see remove success message$")
    public void iSeeRemoveSuccessMsg() {
        assertTrue(webShopHomePagePO.successMsg.isDisplayed());
        assertEquals("Success: You have modified your wish list!\n" +
                "×", webShopHomePagePO.successMsg.getText());
    }

    @And("^I click move to cart button$")
    public void iClickMoveToCartFromWishlist() {
        webShopWishlistPagePO.moveToCartFirstItemFromWishListBtn.click();
    }

    @And("^I navigate to shopping cart$")
    public void iNavigateToCartPage() {
        webShopHomePagePO.cartPageLinkBtn.click();
    }


    @And("^I click Cameras menu$")
    public void iClickCamerasMenu() {
        webShopHomePagePO.camerasMenuBtn.click();
    }

    @When("^I add Canon EOS product to wishlist$")
    public void iAddCanonItemToWishlist() {
        webShopHomePagePO.addSecondItemWishlistBtn.click();
    }

    @Then("^I see previously selected Canon EOS in wishlist$")
    public void iSeeCanonInWishlist() {
        assertTrue(webShopWishlistPagePO.canonItem.isDisplayed());

    }

    @Then("^I see previously selected Canon EOS in cart$")
    public void iSeeMacBookInCart() {
        assertTrue(webShopWishlistPagePO.canonItem.isDisplayed());
    }

    @And("^I see success message for Canon EOS$")
    public void iSeeSuccessMsg() {
        assertTrue(webShopHomePagePO.successMsg.isDisplayed());
        assertEquals("Success: You have added Canon EOS 5D to your wish list!\n×", webShopHomePagePO.successMsg.getText());
    }
}
