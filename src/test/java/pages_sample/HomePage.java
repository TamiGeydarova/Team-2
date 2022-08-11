package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;


public class HomePage {


    @FindBy(how = How.ID, using = "wishlist-total")
    private WebElement wishList;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Tablets')]")
    private WebElement tabletsCategory;


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Phones & PDAs')]")
    private WebElement phonesPDACategory;


    @FindBy(how = How.ID, using = "wishlist-total")
    private WebElement onWistList;

    @FindBy(how = How.XPATH, using = "//a[@title='Checkout']")
    private WebElement checkout;


    public String getHomePageUrl() {
        return "http://www.demoshop24.com/index.php?route=common/home";
    }


    public void checkWishListCount(String wishListCount) {
        String wishListText = wishList.getAttribute("title");
        assertEquals(wishListText, wishListCount);
    }

    public void selectTabletCategory() {
        tabletsCategory.click();
    }


    public void selectPhonesPDACategory() {
        phonesPDACategory.click();
    }


    public void iAmOnWistList() {
        onWistList.click();
    }


}
