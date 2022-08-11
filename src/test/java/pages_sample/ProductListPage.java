package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ProductListPage {

    @FindBy(how = How.XPATH, using = "//img[@title='Samsung Galaxy Tab 10.1']")
    private WebElement clickSamsungProduct;
    @FindBy(how = How.XPATH, using = "//img[@title='iPhone']")
    private WebElement clickIphoneProduct;
    @FindBy(how = How.XPATH, using = "//button[@data-original-title='Add to Wish List']")
    private WebElement wishListButton;
    @FindBy(how = How.CLASS_NAME, using = "alert-success")
    private WebElement addWishListAlertMessage;

    public void clickSamsungProduct() {
        clickSamsungProduct.click();
    }

    public void clickIphoneProduct() {
        clickIphoneProduct.click();
    }

    public void clickAddWishListButton() {
        wishListButton.click();
    }

    public void checkSuccessMessage(String productName) {
        String alertMessage = addWishListAlertMessage.getText();
        assertTrue(alertMessage.contains(productName));
    }
}





