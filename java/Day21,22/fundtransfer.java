package Day22;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class fundtransfer {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(15));

        // OPEN WEBSITE
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        Thread.sleep(3000);

        // LOGIN
        driver.findElement(By.name("username"))
                .sendKeys("john");

        driver.findElement(By.name("password"))
                .sendKeys("demo");

        driver.findElement(By.xpath("//input[@value='Log In']"))
                .click();

        Thread.sleep(5000);

        // OPEN TRANSFER FUNDS PAGE
        driver.findElement(By.linkText("Transfer Funds"))
                .click();

        Thread.sleep(4000);

        // ENTER AMOUNT
        driver.findElement(By.id("amount"))
                .sendKeys("500");

        Thread.sleep(2000);

        // FROM ACCOUNT
        WebElement fromAccount =
                driver.findElement(By.id("fromAccountId"));

        Select fromDropdown = new Select(fromAccount);

        fromDropdown.selectByIndex(0);

        Thread.sleep(2000);

        // TO ACCOUNT
        WebElement toAccount =
                driver.findElement(By.id("toAccountId"));

        Select toDropdown = new Select(toAccount);

        toDropdown.selectByIndex(1);

        Thread.sleep(2000);

        // CLICK TRANSFER
        driver.findElement(
                By.xpath("//input[@value='Transfer']"))
                .click();

        Thread.sleep(5000);

        // VALIDATE SUCCESS MESSAGE
        String successMessage =
                driver.findElement(
                        By.xpath("//h1[@class='title']"))
                        .getText();

        if (successMessage.contains("Transfer Complete")) {

            System.out.println("Fund Transfer Successful");

        } else {

            System.out.println("Fund Transfer Failed");
        }

        Thread.sleep(3000);

        // LOGOUT
        driver.findElement(By.linkText("Log Out"))
                .click();

        Thread.sleep(3000);

        System.out.println("Logged out successfully");

        driver.quit();
    }
}

