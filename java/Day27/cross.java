package Day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class cross {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if(browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Title is : "
                + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}