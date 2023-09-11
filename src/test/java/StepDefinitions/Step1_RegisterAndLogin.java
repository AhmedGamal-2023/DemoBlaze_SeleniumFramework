package StepDefinitions;

import DataDriven.RandomReader;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static StepDefinitions.Hooks.driver;



public class Step1_RegisterAndLogin {
    SoftAssert soft = new SoftAssert();
    DataDriven.JSonDataReader Reader =new DataDriven.JSonDataReader();
    RandomReader randomReader =new RandomReader();
    HomePage home =new HomePage(driver);
    @Given("user open HomePage and click on login")
    public void clickOnSignUp(){
    home.clickOnSignUp();
    }
    @When("user Enter Username, Password")
    public void EnterUsernameAndPassword() throws IOException, ParseException {
        Reader.jsonReader();
     randomReader.randomReader();
     home.EnterUsernameAndPassword(randomReader.UserName, Reader.password);
    }
    @And("user click on Register button")
    public void ClickOnRegister() throws InterruptedException {
    home.ClickOnRegister();

    }
    @Then("Assert that user can login by Username, Password and display Welcome username in HomePage")
    public void AssertThatUserCanLoginByValidData() throws IOException, ParseException {
        Reader.jsonReader();
      home.AssertThatUserCanLoginByValidData(Reader.UserName, Reader.password);

     String ExpectedResult = "Welcome";
     String ActualResult= home.AssertDisplayMessage();
        soft.assertTrue(ActualResult.contains(ExpectedResult));
    }

}
