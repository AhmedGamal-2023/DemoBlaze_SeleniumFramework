package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }


    private final By SignUpLocator = By.id("signin2");
    private final By UserNameLocator = By.id("sign-username");
    private final By PasswordLocator = By.id("sign-password");
    private final By RegisterButtonLocator = By.cssSelector("button[onclick='register()']");
    private final By LoginLocator = By.id("login2");
    private final By loginUsernameLocator = By.id("loginusername");
    private final By loginPasswordLocator = By.id("loginpassword");
    private final By LoginButtonLocator = By.cssSelector("button[onclick='logIn()']");
    private final By WelcomeLocator = By.id("nameofuser");

    private final By PhonesLocator = By.xpath("//a[contains(text(),'Phones')]");
    private final By LaptopsLocator = By.xpath("//a[contains(text(),'Laptops')]");
    private final By MonitorsLocator = By.xpath("//a[contains(text(),'Monitors')]");
    private final By TableLocator = By.id("tbodyid");
    private final By ItemLocator = By.xpath("//a[contains(text(),'Samsung galaxy s6')]");
    private final By CartLocator = By.id("cartur");
    private final By NokiaItemLocator = By.xpath("//a[contains(text(),'Nokia')]");


    public void clickOnSignUp(){
        wait.until(ExpectedConditions.elementToBeClickable(SignUpLocator)).click();
    }
    public void EnterUsernameAndPassword(String userName, String password){
        wait.until(ExpectedConditions.elementToBeClickable(UserNameLocator)).sendKeys(userName);
        wait.until(ExpectedConditions.elementToBeClickable(PasswordLocator)).sendKeys(password);
    }
    public void ClickOnRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(RegisterButtonLocator)).click();
    }
    public void AssertThatUserCanLoginByValidData(String userName, String password)  {

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();


        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginUsernameLocator)).sendKeys(userName);
        driver.findElement(loginPasswordLocator).sendKeys(password);
        driver.findElement(LoginButtonLocator).click();


    }
    public String AssertDisplayMessage(){
        return  WelcomeLocator.findElement(driver).getText();
    }
    public void clickOnPhones(){
        wait.until(ExpectedConditions.elementToBeClickable(PhonesLocator)).click();
    }
    public String Assert(){
        StringBuilder divText = new StringBuilder();
        List<WebElement> divElements = driver.findElements(TableLocator);
        for (WebElement divElement : divElements) {
            divText.append(divElement.getText()).append("\n");
        }
        return divText.toString();
    }
    public void clickOnLaptops(){
        wait.until(ExpectedConditions.elementToBeClickable(LaptopsLocator)).click();
    }
    public void clickOnMonitors(){
        wait.until(ExpectedConditions.elementToBeClickable(MonitorsLocator)).click();
    }
    public void UserLogin(String userName,String password){

        wait.until(ExpectedConditions.elementToBeClickable(LoginLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginUsernameLocator)).sendKeys(userName);
        driver.findElement(loginPasswordLocator).sendKeys(password);
        driver.findElement(LoginButtonLocator).click();

    }
    public void ClickOnItem() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(ItemLocator))));
        driver.findElement(ItemLocator).click(); // Click the element after it becomes stable
    }

    public void ClickOnCartPage(){
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(CartLocator))));
        driver.findElement(CartLocator).click();
    }
    public void ClickOnNokiaItem(){
        wait.until(ExpectedConditions.elementToBeClickable(NokiaItemLocator)).click();
    }

}
