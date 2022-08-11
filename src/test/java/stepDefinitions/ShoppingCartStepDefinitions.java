package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.ResultPage;
import pageObjects.ShoppingCartPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartStepDefinitions extends GeneralSteps{
    private MainPage mainPage = new MainPage(driver);
    private ResultPage resultPage = new ResultPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    @Given("^Login with Registered user \"([^\"]*)\"$")
    public void loginWithRegisteredUser(String email) {
        driver.openWebPage("");
        loginPage.performLogin("viki.vconnect@gmail.com");
    }


    @Then("^Choose the product \"([^\"]*)\" from the category \"([^\"]*)\" SubCategory \"([^\"]*)\"$")
    public void chooseTheProductFromTheCategorySubCategory(String product, String category, String subcategory) throws Throwable {
        shoppingCartPage.chooseCategory(category);
        shoppingCartPage.clickSubCategory(subcategory);
        shoppingCartPage.clickProduct(product);
    }
    @Then("^Add the product to cart$")
    public void addTheProductToCart() {
        shoppingCartPage.clickAddToCart();
    }

    @And("^View the shopping cart$")
    public void viewTheShoppingCart() {
        shoppingCartPage.clickShoppingCart();
    }

    @Then("^Ensure the Product features and prices on the shopping cart page$")
    public void ensureTheProductFeaturesOnTheShoppingCartPage(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        assertEquals(data.get(0).get("Product Name"), shoppingCartPage.getProductNameText());
        assertEquals(data.get(0).get("Model"), shoppingCartPage.getProductModelText());
        assertEquals(data.get(0).get("Quantity"),shoppingCartPage.getProductQuantityText());
        assertEquals(data.get(0).get("Unit Price"),shoppingCartPage.getProductUnitPriceText());
        assertEquals(data.get(0).get("Total"),shoppingCartPage.getProductTotalPriceText());

    }

    @And("^Check if the product is added to cart$")
    public void checkIfTheProductIsAddedToCart() {
        assertTrue(shoppingCartPage.checkIfTheProductIsAddedToCart());
    }

    @Then("^Enter all the required fields on the product page$")
    public void enterAllTheRequiredFieldsOnTheProductPage(DataTable table) {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        shoppingCartPage.uploadFile();
        shoppingCartPage.selectRadioButton(data.get(0).get("Radio"));
        shoppingCartPage.selectCheckBox(data.get(0).get("Checkbox"));
        shoppingCartPage.enterText(data.get(0).get("Text"));
        shoppingCartPage.selectColor(data.get(0).get("Select"));
        shoppingCartPage.Textarea(data.get(0).get("Textarea"));
        shoppingCartPage.dateSelector(data.get(0).get("Date"));
        shoppingCartPage.timeSelector(data.get(0).get("Time"));
        shoppingCartPage.dateTimeSelector(data.get(0).get("DateTime"));
        shoppingCartPage.setQuantity(data.get(0).get("Quantity"));

    }



    @Then("^Choose the product \"([^\"]*)\" from the category \"([^\"]*)\" and subcategory \"([^\"]*)\"$")
    public void chooseTheProductFromTheCategory(String product, String category, String SubCategory) {
        shoppingCartPage.chooseCategory(category);
        shoppingCartPage.clickSubCategory(SubCategory);
        shoppingCartPage.clickProduct(product);


    }

    @And("^Check if the Shopping Cart button is displayed at Top Menu and other from right top menu$")
    public void checkIfTheShoppingCartButtonIsDisplayedAtTopMenuAndOtherFromRightTopMenu() {
        shoppingCartPage.isAddToCartButton1Displayed();
        shoppingCartPage.isShoppingCartButtonDisplayed();
    }

    @Then("^Repeat step three without uploading the File in productpage$")
    public void repeatStepWithoutUploadingTheFileInProductpage(DataTable table) {

            List<Map<String, String>> data = table.asMaps(String.class, String.class);
            shoppingCartPage.selectRadioButton(data.get(0).get("Radio"));
            shoppingCartPage.selectCheckBox(data.get(0).get("Checkbox"));
            shoppingCartPage.clearTextBox();
            shoppingCartPage.selectColor(data.get(0).get("Select"));
            shoppingCartPage.Textarea(data.get(0).get("Textarea"));
            shoppingCartPage.dateSelector(data.get(0).get("Date"));
            shoppingCartPage.timeSelector(data.get(0).get("Time"));
            shoppingCartPage.dateTimeSelector(data.get(0).get("DateTime"));
            shoppingCartPage.setQuantity(data.get(0).get("Quantity"));
    }
    @Then("^check if the error message is displayed$")
    public void checkIfTheErrorMessageIsDisplayed() {
        assertTrue(shoppingCartPage.checkIfTheErrorMessageIsDisplayed());
    }

    @Then("^Clear all products from cart$")
    public void clearAllProductsFromCart() {
        shoppingCartPage.clickCartTotal();
        shoppingCartPage.removeAllItemsFromCart();
    }
}
