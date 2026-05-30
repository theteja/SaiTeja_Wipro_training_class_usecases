package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class parabank {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "ParaBank | Welcome | Online Banking");

        System.out.println("Home Page Title Validation Passed");
    }

    @Test(priority = 2)
    public void loginTest() {

        driver.findElement(By.name("username"))
              .sendKeys("john");

        driver.findElement(By.name("password"))
              .sendKeys("demo");

        driver.findElement(By.xpath("//input[@value='Log In']"))
              .click();

        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("overview"));

        System.out.println("Login Test Passed");
    }

    @Test(priority = 3)
    public void verifyAccountOverviewPage() {

        driver.findElement(By.name("username"))
              .sendKeys("john");

        driver.findElement(By.name("password"))
              .sendKeys("demo");

        driver.findElement(By.xpath("//input[@value='Log In']"))
              .click();

        String pageText =
                driver.findElement(By.className("title")).getText();

        Assert.assertEquals(pageText, "Accounts Overview");

        System.out.println("Accounts Overview Page Validation Passed");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}

