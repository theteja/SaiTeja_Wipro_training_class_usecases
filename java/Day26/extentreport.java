package Day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreport {

    public static void main(String[] args) {

        // Create Extent Spark Reporter

        ExtentSparkReporter reporter =
            new ExtentSparkReporter(
                "reports/ExtentReport.html"
            );

        // Create Extent Reports Object

        ExtentReports extent =
            new ExtentReports();

        extent.attachReporter(reporter);

        // Create Test

        ExtentTest test =
            extent.createTest(
                "SauceDemo Login Test"
            );

        // Launch Browser

        WebDriver driver =
            new ChromeDriver();

        test.info("Browser Launched");

        // Open Website

        driver.get("https://www.saucedemo.com");

        test.info("Opened SauceDemo Website");

        // Enter Username

        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        test.pass("Username Entered");

        // Enter Password

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        test.pass("Password Entered");

        // Click Login Button

        driver.findElement(By.id("login-button"))
              .click();

        test.pass("Login Button Clicked");

        // Validate Login

        String title = driver.getTitle();

        if(title.contains("Swag Labs")) {

            test.pass("Login Test Passed");
        }
        else {

            test.fail("Login Test Failed");
        }

        // Close Browser

        driver.quit();

        test.info("Browser Closed");

        // Generate Report

        extent.flush();

        System.out.println(
            "Extent Report Generated Successfully"
        );
    }
}