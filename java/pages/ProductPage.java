package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By backpack =
        By.id("add-to-cart-sauce-labs-backpack");

    By bikeLight =
        By.id("add-to-cart-sauce-labs-bike-light");

    // Actions
    public void addProducts() {

        driver.findElement(backpack).click();

        driver.findElement(bikeLight).click();
    }
}