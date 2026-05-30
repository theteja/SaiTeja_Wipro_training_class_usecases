package Day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox {

    public static void main(String[] args)throws InterruptedException {

        
        WebDriver driver = new ChromeDriver();

   
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/checkbox");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Expand all']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Desktop']")).click();
        Thread.sleep(2000);
        String result = driver.findElement(By.id("result")).getText();

        System.out.println(result);

        // Close Browser
        driver.quit();
    }
}