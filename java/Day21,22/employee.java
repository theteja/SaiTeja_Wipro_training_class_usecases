package Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class employee {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Open Website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(4000);

        // LOGIN
        driver.findElement(By.name("username"))
                .sendKeys("Admin");

        driver.findElement(By.name("password"))
                .sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(5000);

        // OPEN PIM MODULE
        driver.findElement(By.xpath("//span[text()='PIM']"))
                .click();

        Thread.sleep(4000);

        // ADD EMPLOYEE
        driver.findElement(By.xpath("//input[@class='oxd-button oxd-button--medium oxd-button--secondary']"))
                .click();

        Thread.sleep(3000);

        // ENTER EMPLOYEE DETAILS
        driver.findElement(By.name("firstName"))
                .sendKeys("John");

        driver.findElement(By.name("lastName"))
                .sendKeys("Doe");
        
       
        Thread.sleep(2000);

        // SAVE EMPLOYEE
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(2000);

        // CAPTURE EMPLOYEE ID
        WebElement empId =
                driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));

        String employeeId = empId.getAttribute("value");

        System.out.println("Employee ID: " + employeeId);

        Thread.sleep(3000);

        // GO TO EMPLOYEE LIST
        driver.findElement(By.xpath("//a[text()='Employee List']"))
                .click();

        Thread.sleep(4000);

        // SEARCH EMPLOYEE
        WebElement searchBox =
                driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));

        searchBox.sendKeys("John");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(5000);

        // UPDATE EMPLOYEE
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-pencil-fill'])[1]"))
                .click();

        Thread.sleep(4000);

        // UPDATE LAST NAME
        WebElement lastName =
                driver.findElement(By.name("lastName"));

        lastName.clear();

        lastName.sendKeys("Smith");

        Thread.sleep(2000);

        // SAVE UPDATED DETAILS
        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(5000);

        // DELETE EMPLOYEE
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-trash'])[1]")).click();
        //driver.findElement(By.xpath("(//button[i[contains(@class,'bi-trash')]])[1]").click();
        Thread.sleep(3000);

        // CONFIRM DELET
        driver.findElement(By.xpath("//button[contains(.,'Yes, Delete')]"))
                .click();

        Thread.sleep(5000);

        System.out.println("Employee deleted successfully");

        // CLOSE BROWSER
        driver.quit();
    }
}
