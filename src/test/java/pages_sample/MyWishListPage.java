package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MyWishListPage {

    @FindBy(how = How.XPATH, using = "//a[@data-original-title='Remove']")
    private WebElement removeButton;


    public void iAmRemoveMyWishList() {
        removeButton.click();
    }
}
