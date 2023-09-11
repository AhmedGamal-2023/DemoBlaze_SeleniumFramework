package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ItemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static StepDefinitions.Hooks.driver;

public class Step5_Checkout {
    SoftAssert soft = new SoftAssert();
    DataDriven.JSonDataReader Reader =new DataDriven.JSonDataReader();

    HomePage home =new HomePage(driver);
    ItemPage item =new ItemPage(driver);
    CartPage cart =new CartPage(driver);
    @Given("user open HomePage and click on Item")
    public void ClickOnItem(){
        home.ClickOnNokiaItem();
    }
    @When("click Add to Cart In ItemPage and navigate to CartPage")
    public void ClickAddToCartAndNavigateToCartPage(){
        item.ClickOnAdd();
    }
    @And("Click on Place Order")
    public void ClickOnOrder(){
       cart.ClickOnOrder();
    }
    @And("Fills required Data")
    public void FillsRequiredData() throws IOException, ParseException {
        Reader.jsonReader();
      cart.FillsRequiredData(Reader.name, Reader.country, Reader.city, Reader.CardNumber, Reader.month, Reader.year);
    }
    @Then("Assert that display Successfully message {string}")
    public void AssertDisplaySuccessfullyMessage(String message){
        String ExpectedResult = message;
        String ActualResult= cart.AssertDisplaySuccessfullyMessage();
        soft.assertEquals(ActualResult,ExpectedResult);
    }
}
