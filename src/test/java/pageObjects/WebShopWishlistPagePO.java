package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebShopWishlistPagePO extends Page {

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Apple')]")
    public WebElement appleCinemaItem;

    @FindBy(how = How.CSS, using = "#content > div.table-responsive > table > tbody > tr > td:nth-child(6) > a")
    public WebElement removeFirstItemFromWishListBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2")
    public List<WebElement> wishList;

    @FindBy(how = How.XPATH, using = "//div[contains (@class, \"alert\") and contains(text(),'Success')]")
    public WebElement removeSuccessMsg;



    public WebShopWishlistPagePO(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean checkWishlistIsEmpty() {
        if(wishList.isEmpty())
            return true;
        else
            return false;
    }




}
