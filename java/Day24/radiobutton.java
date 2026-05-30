package Day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class radiobutton {

    public static void main(String[] args) throws InterruptedException {

        
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

    
        driver.get("https://demoqa.com/radio-button");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();

        Thread.sleep(2000);
        String result = driver.findElement(By.className("text-success")).getText();

        
        System.out.println("Selected Radio Button : " + result);

     
        driver.quit();
    }
}