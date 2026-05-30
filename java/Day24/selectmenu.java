package Day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class selectmenu {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/select-menu");


        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));


        Select select = new Select(dropdown);

 
        select.selectByVisibleText("Purple");

       


        driver.quit();
    }
}
