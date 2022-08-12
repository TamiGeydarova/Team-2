package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyWishListPage extends Page {

    @FindBy(how = How.XPATH, using = "//a[@data-original-title='Remove']")
    private WebElement removeButton;


    public MyWishListPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void iAmRemoveMyWishList() {
        removeButton.click();
    }




}
