package Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class flight {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Open Website
        driver.get("https://phptravels.net/");

        Thread.sleep(5000);

        // Click Flights Tab
        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/nav/button[2]")) // /html/body/div[2]/div[3]/div/nav/button[2] //button[contains(.,'Flights')]
                .click();

        Thread.sleep(3000);

        // Departure From
        WebElement from =
                driver.findElement(By.xpath("//input[@placeholder='Departure City or Airport']")); // 

        from.click();
        from.sendKeys("Dubai");

        Thread.sleep(3000);

        from.sendKeys(Keys.ARROW_DOWN);
        from.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        // Arrival To
        WebElement to =
                driver.findElement(By.xpath("//input[@placeholder='Arrival City or Airport']"));

        to.click();
        to.sendKeys("London");

        Thread.sleep(3000);

        to.sendKeys(Keys.ARROW_DOWN);
        to.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        // Departure Date
        WebElement date =
                driver.findElement(By.xpath("/html/body/div[19]"));// /html/body/div[19]

        date.click();

        Thread.sleep(2000);

        // Select current date
        driver.findElement(By.xpath("//td[@class='day active']")).click();

        Thread.sleep(3000);

        // Passenger Dropdown
        driver.findElement(By.xpath("//select[contains(@class,'passengers')]"))
                .click();

        Thread.sleep(2000);

        // Select 2 Passengers
        driver.findElement(By.xpath("//option[contains(text(),'2 Passenger')]"))
                .click();

        Thread.sleep(2000);

        // Search Flights
        driver.findElement(By.xpath("//button[contains(text(),'Search Flights')]"))
                .click();

        Thread.sleep(8000);

        // Validation
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("flights")) {

            System.out.println("Flight search successful");

        } else {

            System.out.println("Flight search failed");
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
