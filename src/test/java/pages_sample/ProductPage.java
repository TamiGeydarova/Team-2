package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

import static org.junit.Assert.assertEquals;


public class ProductPage {
    @FindBy(how = How.XPATH, using = "//button[@data-original-title='Add to Wish List']")
    private WebElement wishListButtonOnProduct;

    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    private WebElement addWishListAlertMessageOnProduct;

    public void clickAddWishListButtonOnProduct() {
        wishListButtonOnProduct.click();
    }

    public void checkWishListSuccessMessageOnProduct() {
        String successMessageTextOnProduct = "Success: You have added Samsung Galaxy Tab 10.1 to your wish list!\n" +
                "×";
        assertEquals(successMessageTextOnProduct, addWishListAlertMessageOnProduct.getText());
    }

}