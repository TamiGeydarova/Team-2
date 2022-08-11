package pageObjects;
import flowWorkers.WebDriverLib;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ShopPage extends Page {

    public ShopPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1) > div > a")
    public WebElement seeAllDesktopsLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
    public WebElement desktopsMenuBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='input-email']")
    public WebElement emailInputField;

    @FindBy(how = How.XPATH, using = "//*[@id='input-password']")
    public WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    public WebElement submitLoginBtn;

    @FindBy(xpath = "//a[text()='Desktops']")
    public WebElement category;

    @FindBy(xpath = "//a[text()='Show All Desktops']")
    public WebElement subCategory;

    @FindBy(xpath = "//a[contains(text(),'iPhone')]")
    public WebElement product;

    @FindBy(id = "button-cart")
    public WebElement addToCartButton;

    @FindBy(xpath= "//div[contains(text(),'Success')]")
    public WebElement successMessage;

    @FindBy(xpath= "//a[@title='Shopping Cart']")
    public WebElement shoppingCartIcon;



    public String getLoginPageUrl() {
        return "http://www.demoshop24.com/index.php?route=account/login";
    }

    public void enterEmailToLogin(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void enterPasswordToLogin(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void clickSubmitLogin() {
        submitLoginBtn.click();
    }

    public void enterExistingUserLogin() throws InterruptedException {
        emailInputField.sendKeys("test@example.com");
        passwordInputField.sendKeys("password");
        Thread.sleep(2000);
    }
    public void clickCategory() {
        driver.waitForElementPresent(category);
        category.click();
    }

    public void clickSubCategory() {
        driver.waitForElementPresent(subCategory);
        subCategory.click();

    }

    public void clickOnProduct() {
        driver.waitForElementPresent(product);
        product.click();
    }
    public void clickAddToCart() {
        driver.waitForElementPresent(addToCartButton);
        addToCartButton.click();
    }
    public boolean checkIfTheProductIsAddedToCart() {
        driver.waitForElementPresent(successMessage);
        if(successMessage.isDisplayed())
            return true;
        else
            return false;
    }
    public void clickShoppingCart() {
        driver.waitForElementPresent(shoppingCartIcon);
        shoppingCartIcon.click();
    }

}