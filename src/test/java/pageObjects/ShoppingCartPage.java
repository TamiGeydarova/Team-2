package pageObjects;

import core.config.YamlConfig;
import core.config.YamlFileManager;
import flowWorkers.WebDriverLib;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    @FindBy(xpath = "//button[@id='button-cart']")
    public WebElement addTocCartButton;

    @FindBy(xpath = "//div[contains(text(),'Success')]")
    public WebElement successMessage;

    @FindBy(xpath = "//a[@title='Shopping Cart']")
    public WebElement shoppingCartIcon;

    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[2]/a")
    public WebElement productName;

    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input")
    public WebElement productQuantity;

    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[3]")
    public WebElement productModel;

    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[5]")
    public WebElement productUnitPrice;

    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[6]")
    public WebElement productTotalPrice;

    @FindBy(xpath = "//div[@id='input-option218']//input")
    public List<WebElement> sizeRadio;

    @FindBy(xpath = "//div[@id='input-option223']//input")
    public List<WebElement> checkBox;

    @FindBy(xpath = "//input[@id='input-option208']")
    public WebElement textBox;

    @FindBy(xpath = "//select[@id='input-option217']")
    public WebElement colorSelectBox;

    @FindBy(xpath = "//textarea[@id='input-option209']")
    public WebElement textArea;

    @FindBy(xpath = "//input[@id='input-option219']")
    public WebElement datePicker;

    @FindBy(xpath = "//input[@id='input-option221']")
    public WebElement timePicker;

    @FindBy(xpath = "//input[@id='input-option220']")
    public WebElement dateAndTime;

    @FindBy(xpath = "//input[@id='input-quantity']")
    public WebElement quantity;

    @FindBy(xpath = "//button[@id='button-upload222']")
    public WebElement uploadFileButton;


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


    public void clickAddToCart() {
        driver.waitForElementPresent(addTocCartButton);
        addTocCartButton.click();
    }

    public boolean checkIfTheProductIsAddedToCart() {
        driver.waitForElementPresent(successMessage);
        if (successMessage.isDisplayed())
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

    public boolean chooseCategory(String Category) {
        String categoryXpath = "//a[text()='" + Category + "']";
        driver.findElement(By.xpath(categoryXpath)).click();
        return true;
    }

    public boolean clickSubCategory(String subCategory) {
        String subCategoryPath = "//a[text()='" + subCategory + "']";
        driver.findElement(By.xpath(subCategoryPath)).click();
        return true;
    }

    public boolean clickProduct(String product) {
        String productPath = "//a[contains(text(),'" + product + "')]";
        WebElement productElement = driver.findElement(By.xpath(productPath));
        driver.clickUsingJavaScriptExecutor(productElement);
        return true;

    }

    public void selectRadioButton(String value) {
        for (int i = 0; i < sizeRadio.size(); i++) {
            if (sizeRadio.get(i).getAttribute("value") == value) {
                sizeRadio.get(i).click();
            }
        }
    }

    public void selectCheckBox(String value) {
        for (int i = 0; i < checkBox.size(); i++) {
            if (checkBox.get(i).getAttribute("value") == value) {
                checkBox.get(i).click();
            }
        }
    }

    public void selectColor(String value) {
        Select select = new Select(colorSelectBox);
        select.selectByValue(value);

    }

    public void enterText(String value) {
        textBox.sendKeys(value);
    }

    public void Textarea(String value) {
        textArea.sendKeys(value);
    }

    public void dateSelector(String value) {
        datePicker.sendKeys(value);
    }
    public void timeSelector(String value) {
        timePicker.sendKeys(value);
    }

    public void dateTimeSelector(String value) {
        dateAndTime.sendKeys(value);
    }

    public void setQuantity(String value) {
        quantity.sendKeys(value);
    }

    public void uploadFile() {
        uploadFileButton.sendKeys("src/test/resources/SamplePictures/picture.png");
        //Alert alert = new Alert();
//        driver.switchTo().alert().accept();
    }
}