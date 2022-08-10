package pageObjects;

import core.config.YamlConfig;
import core.config.YamlFileManager;
import flowWorkers.WebDriverLib;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends Page {
    private YamlConfig config = YamlFileManager.getProjectConfigurations();
    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountDropdown;
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement emailInputField;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Desktops']")
    public WebElement category;

    @FindBy(xpath = "//a[text()='Show All Desktops']")
    public WebElement subCategory;

    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    public WebElement product;

    @FindBy(id = "button-cart")
    public WebElement addTocCartButton;

    @FindBy(xpath= "//div[contains(text(),'Success')]")
    public WebElement successMessage;

    @FindBy(xpath= "//a[@title='Shopping Cart']")
    public WebElement shoppingCartIcon;

    @FindBy(xpath= "//*[@id='content']/form/div/table/tbody/tr/td[2]/a")
    public WebElement productName;

    @FindBy(xpath= "//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input")
    public WebElement productQuantity;

    @FindBy(xpath= "//*[@id='content']/form/div/table/tbody/tr/td[3]")
    public WebElement productModel;

    @FindBy(xpath= "//*[@id='content']/form/div/table/tbody/tr/td[5]")
    public WebElement productUnitPrice;

    @FindBy(xpath= "//*[@id='content']/form/div/table/tbody/tr/td[6]")
    public WebElement productTotalPrice;



    public ShoppingCartPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddAccountButton() {
        driver.waitForElementPresent(myAccountDropdown);
        myAccountDropdown.click();
    }

    public void clickOnLoginLink() {
        driver.waitForElementPresent(loginLink);
        loginLink.click();
    }

    public void clickOnLoginButton() {
        driver.waitForElementPresent(loginButton);
        loginButton.click();
    }

    public void setEmail(String email) {
        driver.waitForElementPresent(emailInputField);
        emailInputField.sendKeys(email);
    }

    public void setPassword(String password) {
        driver.waitForElementPresent(passwordInputField);
        passwordInputField.sendKeys(password);
    }

    public void performLogin(String email) {
        clickOnAddAccountButton();
        clickOnLoginLink();
        setEmail(email);
        setPassword(config.getConfiguration("credentials.password") + "");
        clickOnLoginButton();
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
        driver.waitForElementPresent(addTocCartButton);
        addTocCartButton.click();
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

    public String getProductTotalPriceText() {
        driver.waitForElementPresent(productTotalPrice);
        return productTotalPrice.getText();
    }
    public String getProductNameText() {
        driver.waitForElementPresent(productName);
        return productName.getText();
    }
    public String getProductModelText() {
        driver.waitForElementPresent(productModel);
        return productModel.getText();
    }
    public String getProductQuantityText() {
        driver.waitForElementPresent(productQuantity);
        return productQuantity.getAttribute("value");
    }
    public String getProductUnitPriceText() {
        driver.waitForElementPresent(productUnitPrice);
        return productUnitPrice.getText();
    }

    public String getSubCategoryText() {
        driver.waitForElementPresent(subCategory);
        return subCategory.getText();
    }




}