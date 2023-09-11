package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private final By ItemsTableOfCartLocator = By.id("tbodyid");
    private final By DeleteLocator = By.xpath("//a[contains(text(),'Delete')]");
    private final By PlaceOrderLocator = By.xpath("//button[contains(text(),'Place Order')]");
    private final By nameLocator = By.id("name");
    private final By countryLocator = By.id("country");
    private final By cityLocator = By.id("city");
    private final By cardLocator = By.id("card");
    private final By monthLocator = By.id("month");
    private final By yearLocator = By.id("year");
    private final By PurchaseLocator = By.xpath("//button[contains(text(),'Purchase')]");
    private final By MessageLocator = By.xpath("//h2[contains(text(),'Thank')]");
    public String AssertTableItems(){
        StringBuilder divText = new StringBuilder();
        List<WebElement> divElements = driver.findElements(ItemsTableOfCartLocator);
        for (WebElement divElement : divElements) {
            divText.append(divElement.getText()).append("\n");
        }
        return divText.toString();
    }
    public void ClickOnDelete(){
        wait.until(ExpectedConditions.elementToBeClickable(DeleteLocator)).click();
    }
    public void ClickOnOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(PlaceOrderLocator)).click();
    }
    public void FillsRequiredData(String name,String country,String city,String card,String month,String year){
        wait.until(ExpectedConditions.elementToBeClickable(nameLocator)).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(countryLocator)).sendKeys(country);
        wait.until(ExpectedConditions.elementToBeClickable(cityLocator)).sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(cardLocator)).sendKeys(card);
        wait.until(ExpectedConditions.elementToBeClickable(monthLocator)).sendKeys(month);
        wait.until(ExpectedConditions.elementToBeClickable(yearLocator)).sendKeys(year);
        wait.until(ExpectedConditions.elementToBeClickable(PurchaseLocator)).click();
    }
    public String AssertDisplaySuccessfullyMessage(){
        return MessageLocator.findElement(driver).getText();
    }
}
