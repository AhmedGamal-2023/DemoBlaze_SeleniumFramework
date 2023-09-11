package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends BasePage{
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    private final By AddToCartLocator = By.xpath("//a[contains(text(),'Add to cart')]");
    private final By CartLocator = By.id("cartur");



    public void ClickOnAdd(){

        wait.until(ExpectedConditions.elementToBeClickable(AddToCartLocator)).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        wait.until(ExpectedConditions.elementToBeClickable(CartLocator)).click();
    }


}
