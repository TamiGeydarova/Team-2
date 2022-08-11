package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WebShopHomePagePO extends Page {

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
    public WebElement desktopsMenuBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]//div/a")
    public WebElement seeAllDesktopsLink;

    @FindBy(how = How.XPATH, using = "//*[@class='button-group']/button[2]")
    public WebElement addFirstItemWishlistBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[7]/a")
    public WebElement camerasMenuBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
    public WebElement seeAllLaptopsLink;

    @FindBy(how = How.XPATH, using = "//*[contains(@onclick, 'wishlist.add') and contains(@onclick, '30')]")
    public WebElement addSecondItemWishlistBtn;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Success')]")
    public WebElement successMsg;

    @FindBy(how = How.XPATH, using = "//*[contains(@id, 'wishlist-total') and contains(@title, 'Wish List')]")
    public WebElement wishlistPageLinkBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(@title, 'Shopping Cart')]")
    public WebElement cartPageLinkBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(@id, 'menu')]//*[contains(text(),'Tablets')]")
    public WebElement tabletsMenuBtn;

    @FindBy(how = How.ID, using = "button-cart")
    public WebElement pDpAddToCartBtn;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Products')]")
    public WebElement outOfStockMsg;

    @FindBy(how = How.XPATH, using = "//*[contains(@class, \"text-danger\")]")
    public WebElement threeStarsMark;


    //*[@id="checkout-cart"]/div[1]/i

    public WebShopHomePagePO(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHomePageUrl() {
        return "http://www.demoshop24.com/index.php?route=common/home";
    }

    public void clickSeeAllDesktops(){
        seeAllDesktopsLink.click();
    }

    public void clickDesktopsBtn(){
        desktopsMenuBtn.click();
    }

    public void addToWishlistDesktopsItem(){
        addFirstItemWishlistBtn.click();
    }

    public void clickWishlistTotalLinkBtn(){
        wishlistPageLinkBtn.click();
    }

    public boolean successMsgIsDisplayed() {
        if(successMsg.isDisplayed())
            return true;
        else
            return false;
    }
}
