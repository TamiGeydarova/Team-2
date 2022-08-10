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

    public WebShopWishlistPagePO(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isFirstItemDisplayed() {
        if(wishList.isEmpty())
            return true;
        else
            return false;
    }

//    public boolean isElementPresent() {
//        if (driver.findElements(By.xpath("//a[contains(text(),'Apple')]")).size() > 0) {
//            driver.findElements(By.xpath("//a[contains(text(),'Apple')]"));
//            if (driver.findElements(By.xpath("//a[contains(text(),'Apple')]")).isDisplayed()) {
//                if (driver.findElements(By.xpath("//a[contains(text(),'Apple')]")).isEnabled()) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


}
