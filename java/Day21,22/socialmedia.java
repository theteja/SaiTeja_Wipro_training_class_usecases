package Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class socialmedia {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(15));

        // OPEN DEMO APPLICATION
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

        // LOGIN
        driver.findElement(By.name("username"))
                .sendKeys("Admin");

        driver.findElement(By.name("password"))
                .sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(5000);

        // OPEN PROFILE MENU
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"))
                .click();

        Thread.sleep(3000);

        // OPEN MY INFO PAGE
        driver.findElement(By.linkText("My Info"))
                .click();

        Thread.sleep(5000);

        // UPDATE FIRST NAME
        WebElement firstName =
                driver.findElement(By.name("firstName"));

        firstName.clear();

        firstName.sendKeys("John");

        Thread.sleep(2000);

        // UPDATE LAST NAME
        WebElement lastName =
                driver.findElement(By.name("lastName"));

        lastName.clear();

        lastName.sendKeys("Smith");

        Thread.sleep(2000);

        // SAVE PROFILE
        driver.findElement(
                By.xpath("(//button[@type='submit'])[1]"))
                .click();

        Thread.sleep(5000);

        // UPLOAD PROFILE IMAGE
        WebElement upload =
                driver.findElement(
                        By.xpath("//input[@type='file']"));

        upload.sendKeys("https://www.google.com/imgres?q=photos&imgurl=https%3A%2F%2Fstatic.vecteezy.com%2Fvite%2Fassets%2Fphoto-masthead-375-BoK_p8LG.webp&imgrefurl=https%3A%2F%2Fwww.vecteezy.com%2Ffree-photos&docid=ibTdn4unYxO9nM&tbnid=7F8_kUgVrrg0YM&vet=12ahUKEwiz5OmN1MKUAxWdzTgGHeE8GiAQnPAOegQIGhAB..i&w=750&h=864&hcb=2&ved=2ahUKEwiz5OmN1MKUAxWdzTgGHeE8GiAQnPAOegQIGhAB");

        Thread.sleep(5000);

        // SAVE IMAGE
        driver.findElement(
                By.xpath("//button[@type='submit']"))
                .click();

        Thread.sleep(5000);

        // LOGOUT
        driver.findElement(
                By.xpath("//span[@class='oxd-userdropdown-tab']"))
                .click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Logout"))
                .click();

        Thread.sleep(3000);

        System.out.println("Profile updated successfully");

        driver.quit();
    }
}