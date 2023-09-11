package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ItemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import static StepDefinitions.Hooks.driver;

public class Step4_RemoveItem {
    SoftAssert soft = new SoftAssert();
    DataDriven.JSonDataReader Reader =new DataDriven.JSonDataReader();

    HomePage home =new HomePage(driver);
    ItemPage item =new ItemPage(driver);
    CartPage cart =new CartPage(driver);
    @When("click on Cart Page")
    public void ClickOnCart(){
     home.ClickOnCartPage();
    }
    @And("Click on Delete Item")
    public void ClickOnDelete(){
     cart.ClickOnDelete();
    }
    @Then("Assert That Item {string} not found in CartList")
    public void AssertNotFound(String Item){
     String ExpectedNotFound = Item;
     String ActualResult= cart.AssertTableItems();
     soft.assertFalse(ActualResult.contains(ExpectedNotFound));
    }
}
