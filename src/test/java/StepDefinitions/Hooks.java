package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.ByteArrayInputStream;
import java.time.Duration;


public class Hooks {

    public static WebDriver driver ;
    @Before
    public void openUrl(){
        if (driver==null){
            driver= new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit(); // Use quit() to close the entire browser session.
            driver = null; // Reset the driver to null.
        }
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed ScreenShot", new ByteArrayInputStream(screenshot));
        }
    }
}
