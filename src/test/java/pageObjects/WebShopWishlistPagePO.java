package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebShopWishlistPagePO extends Page {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Apple Cinema')]")
    public WebElement appleCinemaItem;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Canon EOS')]")
    public WebElement canonItem;

    @FindBy(how = How.XPATH, using = "//*[@class='table-responsive']//*[contains(text(),'Samsung')]")
    public WebElement samsungTabletItem;

    @FindBy(how = How.CSS, using = "#content > div.table-responsive > table > tbody > tr > td:nth-child(6) > a")
    public WebElement removeFirstItemFromWishListBtn;

    @FindBy(how = How.XPATH, using = "//*[@type='button' and @class='btn btn-primary']")
    public WebElement moveToCartFirstItemFromWishListBtn;


    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/h2")
    public List<WebElement> wishList;




    public WebShopWishlistPagePO(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean checkAppleCinemaItemIsRemoved() {
        try{
            appleCinemaItem.getText();
            return true;
        }catch (NoSuchElementException noSuchElementException){
            return false;
        }

    }


}
