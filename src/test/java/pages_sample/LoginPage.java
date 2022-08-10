package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

import static org.junit.Assert.assertEquals;


public class LoginPage {

    @FindBy(how = How.ID, using = "input-email")
    private WebElement emailInput;

    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    private WebElement loginButton;


    public String getPageUrl() {
        return "http://www.demoshop24.com/index.php?route=account/login";
    }

    public void enterMail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String email) {
        passwordInput.clear();
        passwordInput.sendKeys(email);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void checkLoginUrl() {

        String pageUrl="http://www.demoshop24.com/index.php?route=account/login";

        assertEquals(pageUrl, getPageUrl());
    }


}
