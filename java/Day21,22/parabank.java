package Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class parabank {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        driver.findElement(By.id("customer.firstName")).sendKeys("Sai");
        driver.findElement(By.id("customer.lastName")).sendKeys("Teja");
        driver.findElement(By.id("customer.address.street")).sendKeys(" Main Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("PGRL");
        driver.findElement(By.id("customer.address.state")).sendKeys("AP");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");

       
        driver.findElement(By.id("customer.username")).sendKeys("teja12345");
        driver.findElement(By.id("customer.password")).sendKeys("Password123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Password123");

        
        driver.findElement(By.xpath("//input[@value='Register']")).click();

       
        WebElement message = driver.findElement(By.xpath("//h1[@class='title']"));
        System.out.println("Registration Successful: " + message.getText());


        driver.quit();
    }
}