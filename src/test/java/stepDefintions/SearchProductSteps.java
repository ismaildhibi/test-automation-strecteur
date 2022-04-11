package stepDefintions;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchProductPage;

public class SearchProductSteps extends Base {
    SearchProductPage searchproduct;

    @Given("The user access to the site")
    public void theUserAccessToTheSite() {
        driver.navigate().to("https://www.chanel.com/us/");
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.chanel.com/us/";
        Assert.assertEquals("not equal", currentUrl,expectedUrl);

    }

    @And("The user click on the search bar")
    public void theUserClickOnTheSearchBar() {
        this.searchproduct = new SearchProductPage(driver);
        this.searchproduct.Clicksearchbutton();
    }

    @When("The User search for word into search bar {string}")
    public void theUserSearchForWordIntoSearchBar(String arg0) {
        this.searchproduct.setSearchInput(arg0);


    }

    @And("The user Check if the displayed list items contain the desired word")
    public void theUserCheckIfTheDisplayedListItemsContainTheDesiredWord() {
        this.searchproduct.listeofproduct();
    }

    @And("The user Select the second item from the list")
    public void theUserSelectTheSecondItemFromTheList() {
        this.searchproduct.savenameofproduct();
        this.searchproduct.clicktosecondeproduct();
    }


    @Then("Verify that the product name displayed is the same as the one previously selected..")
    public void verifyThatTheProductNameDisplayedIsTheSameAsTheOnePreviouslySelected() {
        this.searchproduct.getnameofproduct();
        this.searchproduct.verifynameofproduit();

    }

    @Given("The user access to the Makeup category")
    public void theUserAccessToTheMakeupCategory() throws InterruptedException {
        this.searchproduct = new SearchProductPage(driver);
        this.searchproduct.clicktomakeupbutton();
    }

    @And("The user Click on the RED ALLURE product")
    public void theUserClickOnTheREDALLUREProduct() {
        this.searchproduct.clicktoLipstickbutton();
        this.searchproduct.clicktorougeallure();

    }

    @And("Add product to cart")
    public void addProductToCart() {
        this.searchproduct.addproducttocart();

    }

    @Then("Verify the quantity and the total basket is equal to the price of the product")
    public void verifyTheQuantityAndTheTotalBasketIsEqualToThePriceOfTheProduct() throws InterruptedException {
        this.searchproduct.verifybagcart();
    }
}

