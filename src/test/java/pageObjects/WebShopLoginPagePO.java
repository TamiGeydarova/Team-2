package pageObjects;

import flowWorkers.WebDriverLib;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WebShopLoginPagePO extends Page{

    @FindBy(how = How.XPATH, using = "//*[@id='input-email']")
    public WebElement emailInputField;

    @FindBy(how = How.XPATH, using = "//*[@id='input-password']")
    public WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//*[@type='submit']")
    public WebElement submitLoginBtn;

    public WebShopLoginPagePO(WebDriverLib driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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

    }
}
