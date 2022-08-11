package pageObjects;

import core.config.YamlConfig;
import core.config.YamlFileManager;
import flowWorkers.WebDriverLib;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class ShoppingCartPage extends Page {


    @FindBy(xpath = "//button[@id='button-cart']")
    public WebElement addTocCartButton;

    @FindBy(xpath = "//div[contains(text(),'Success')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'Text required!')]")
    public WebElement errorMessage;

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

    @FindBy(xpath = "//input[@id='input-option222']")
    public WebElement uploadFileButton;

    @FindBy(xpath = "//div[@id='cart']")
    public WebElement shoppingCartButton1;

    @FindBy(xpath = "//span[@id='cart-total']")
    public WebElement cartTotal;

    @FindBy(xpath = "//button[@title='Remove']")
    public List<WebElement> removeAllItemsFromCart;

    public ShoppingCartPage(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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

    public boolean checkIfTheErrorMessageIsDisplayed(){
        driver.waitForElementPresent(errorMessage);
        if(errorMessage.isDisplayed())
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
        //sizeRadio.get(0).click();
        for (int i = 0; i < sizeRadio.size(); i++) {
            if (sizeRadio.get(i).getAttribute("value").equals(value)) {
                sizeRadio.get(i).click();
            }
        }
    }

    public void selectCheckBox(String value) {
       // checkBox.get(0).click();
        for (int i = 0; i < checkBox.size(); i++) {
            if (checkBox.get(i).getAttribute("value").equals(value)) {
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

    public void clearTextBox() {
        textBox.clear();
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
        quantity.clear();
        quantity.sendKeys(value);
    }

    public void uploadFile() {
        driver.uploadFileUsingJavaScript(uploadFileButton);
    }

    public boolean isAddToCartButton1Displayed() {
        return shoppingCartButton1.isDisplayed();
    }

    public boolean isShoppingCartButtonDisplayed() {
        return shoppingCartIcon.isDisplayed();

    }

    public void clickCartTotal() {
        cartTotal.click();
    }

    public void removeAllItemsFromCart() {
        for(int i = 0; i < removeAllItemsFromCart.size(); i++) {
            removeAllItemsFromCart.get(i).click();
        }
    }
}