package Day25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ecommerce {

    public static void main(String[] args) {

        
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        
        driver.get("https://www.saucedemo.com/");

        
        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

       
        WebDriverWait wait =
            new WebDriverWait(driver,
                Duration.ofSeconds(200));

        
        WebElement cartButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-sauce-labs-backpack")
            )
        );

       
        cartButton.click();

        System.out.println("Product added to cart successfully");

        driver.quit();
    }
}