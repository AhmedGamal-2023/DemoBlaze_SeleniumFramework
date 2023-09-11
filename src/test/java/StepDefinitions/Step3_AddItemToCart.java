package StepDefinitions;

import DataDriven.RandomReader;
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

public class Step3_AddItemToCart {
    SoftAssert soft = new SoftAssert();
    DataDriven.JSonDataReader Reader =new DataDriven.JSonDataReader();

    HomePage home =new HomePage(driver);
    ItemPage item =new ItemPage(driver);
    CartPage cart =new CartPage(driver);
    @Given("User open HomePage and login")
    public void UserLogin() throws IOException, ParseException {
        Reader.jsonReader();
        home.UserLogin(Reader.UserName, Reader.password);
    }
    @When("Click on Samsung galaxy s6 Item")
    public void ClickOnItem(){
    home.ClickOnItem();
    }
    @And("Click on Add To Cart")
    public void ClickOnAdd(){
    item.ClickOnAdd();
    }
    @Then("Assert that display {string} Item in CartPage")
    public void AssertDisplayItem(String item){
        String ExpectedResult = item;
        String ActualResult= cart.AssertTableItems();
        soft.assertTrue(ActualResult.contains(ExpectedResult));
    }
}
