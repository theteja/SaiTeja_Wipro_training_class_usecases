package Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class saucedemo {

    public static void main(String[] args)throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
        driver.get("https://www.saucedemo.com/");

       
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(3000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);
      
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        Thread.sleep(3000);
     
        driver.findElement(By.id("add-to-cart")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(3000);
       
        driver.findElement(By.id("first-name")).sendKeys("Sai");
        Thread.sleep(3000);

        driver.findElement(By.id("last-name")).sendKeys("Teja");
        Thread.sleep(3000);
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("finish")).click();
        Thread.sleep(3000);
      
        String confirmation =
                driver.findElement(
                        By.xpath("//h2[@class='complete-header']"))
                        .getText();

        if (confirmation.equals("Thank you for your order!")) {

            System.out.println("Order placed successfully");

        } else {

            System.out.println("Order failed");
        }

        
        driver.quit();
    }
}
