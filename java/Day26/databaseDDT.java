package Day26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class databaseDDT {

    public static void main(String[] args) throws Exception {

     

        Connection con = DriverManager.getConnection(

            "jdbc:mysql://localhost:3306/ddt", "root", "pass@word1");

    

        Statement stmt = con.createStatement();

       

        ResultSet rs = stmt.executeQuery(

            "SELECT * FROM users"
        );

        // Loop Through Database Records

        while(rs.next()) {

            // Read Database Values

            String Username = rs.getString("username");

            String Password = rs.getString("password");

            // Launch Browser

            WebDriver driver = new ChromeDriver();

            // Open Website

            driver.get("https://www.saucedemo.com");

            driver.manage().window().maximize();

            System.out.println("Website Opened");

            // Enter Username

            driver.findElement(By.id("user-name"))
                  .sendKeys(Username);

            System.out.println(
                "Username Entered : " + Username);

            // Enter Password

            driver.findElement(By.id("password"))
                  .sendKeys(Password);

            System.out.println("Password Entered");

            // Click Login

            driver.findElement(By.id("login-button"))
                  .click();

            System.out.println(
                "Login Button Clicked");

      

            System.out.println(
                "Login Test Completed Successfully");

       

            driver.quit();

            System.out.println("Browser Closed");

            System.out.println(
                "----------------------------------");
        }

        // Close Database Connection

        con.close();

        System.out.println(
            "All Database DDT Test Cases Executed Successfully");
    }
}