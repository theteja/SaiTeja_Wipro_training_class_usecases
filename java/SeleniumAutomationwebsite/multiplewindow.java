package example;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class multiplewindow {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Open application
        driver.get("https://demoqa.com/browser-windows");

        // Get parent window ID
        String parent = driver.getWindowHandle();

        System.out.println("Parent Window ID : " + parent);

        // Click button to open new window
        driver.findElement(By.id("windowButton")).click();

        // Get all window IDs
        Set<String> windows = driver.getWindowHandles();

        // Iterate through all windows
        for (String win : windows) {

            driver.switchTo().window(win);

            System.out.println("Window ID : " + win);

            System.out.println("Title : " + driver.getTitle());

            System.out.println("URL : " + driver.getCurrentUrl());

            // Check child window
            if (!win.equals(parent)) {

                String text = driver.findElement(By.id("sampleHeading")).getText();

                System.out.println("Child Window Text : " + text);

                // Close child window
                driver.close();
            }
        }

        // Switch back to parent window
        driver.switchTo().window(parent);

        System.out.println("Back To Parent Window");

        // Close browser
        driver.quit();
    }
}

