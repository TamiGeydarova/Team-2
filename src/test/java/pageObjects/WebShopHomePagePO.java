package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WebShopHomePagePO extends Page {

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]//div/a")
    public WebElement seeAllDesktopsLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
    public WebElement desktopsMenuBtn;

    @FindBy(how = How.XPATH, using = "//*[@class='button-group']/button[2]")
    public WebElement desktopsFirstItemWishlistBtn;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Success')]")
    public WebElement successMsg;

    @FindBy(how = How.XPATH, using = "//*[contains(@id, 'wishlist-total') and contains(@title, 'Wish List')]")
    public WebElement wishlistPageLinkBtn;

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
        desktopsFirstItemWishlistBtn.click();
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
