package Day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class textbox {

    public static void main(String[] args) throws InterruptedException {

       
        WebDriver driver = new ChromeDriver();

    
        driver.manage().window().maximize();

       
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("Teja");
        Thread.sleep(2000);
        driver.findElement(By.id("userEmail")).sendKeys("Teja@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("currentAddress")).sendKeys("AP, India");

        Thread.sleep(2000);
        driver.findElement(By.id("permanentAddress")).sendKeys("AP, India");
        Thread.sleep(2000);

        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("currentAddress")).clear();
        driver.findElement(By.id("permanentAddress")).clear();
        
        driver.quit();
    }
}
