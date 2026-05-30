package Day25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class flight {

    public static void main(String[] args) {

   
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        
        driver.get("https://blazedemo.com/");

        WebElement fromPort =
            driver.findElement(By.name("fromPort"));

        fromPort.sendKeys("Boston");

        
        WebElement toPort =
            driver.findElement(By.name("toPort"));

        toPort.sendKeys("London");

      
        driver.findElement(
            By.xpath("//input[@value='Find Flights']")
        ).click();

   
        FluentWait<WebDriver> wait =
            new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

       
        WebElement flightsTable = wait.until(
            driver1 ->
                driver1.findElement(By.className("table"))
        );

       
        if(flightsTable.isDisplayed()) {
            System.out.println(
                "Flight results loaded successfully"
            );
        }

        driver.quit();
    }
}