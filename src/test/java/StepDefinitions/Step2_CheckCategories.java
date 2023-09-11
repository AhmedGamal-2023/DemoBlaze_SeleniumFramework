package StepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import static StepDefinitions.Hooks.driver;

public class Step2_CheckCategories {
    SoftAssert soft = new SoftAssert();
    HomePage home =new HomePage(driver);
    @Given("user open HomePage")
    public void OpenHomePage(){}
    @When("click on Phones")
    public void clickOnPhones(){
     home.clickOnPhones();
    }
    @Then("Assert that results of Phones Contains {string}")
    public void AssertPhones(String Phone){
        String ExpectedResult = Phone;
        String ActualResult= home.Assert();
        soft.assertTrue(ActualResult.contains(ExpectedResult));
    }
    @When("click on laptops")
    public void ClickOnLaptops(){
        home.clickOnLaptops();
    }
    @Then("Assert that results of laptops Contains {string}")
    public void AssertLaptops(String Laptop){
        String ExpectedResult = Laptop;
        String ActualResult= home.Assert();
        soft.assertTrue(ActualResult.contains(ExpectedResult));
    }
    @When("click on monitors")
    public void ClickOnMonitors(){
        home.clickOnMonitors();
    }
    @Then("Assert that results of Monitors Contains {string}")
    public void AssertMonitors(String Monitor){
        String ExpectedResult = Monitor;
        String ActualResult= home.Assert();
        soft.assertTrue(ActualResult.contains(ExpectedResult));
    }
}
