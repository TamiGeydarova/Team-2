package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MyWishListPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"wishlist-total\"]//*[@class=\"hidden-xs hidden-sm hidden-md\"]")
    private WebElement removeButton;


    public void iAmRemoveMyWishList() {
        removeButton.click();
    }
}
