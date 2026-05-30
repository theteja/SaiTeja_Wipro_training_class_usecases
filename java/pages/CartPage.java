package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators
    By cart = By.className("shopping_cart_link");

    By removeBtn =
        By.id("remove-sauce-labs-bike-light");

    By checkoutBtn =
        By.id("checkout");

    // Actions
    public void openCart() {

        driver.findElement(cart).click();
    }

    public void removeProduct() {

        driver.findElement(removeBtn).click();
    }

    public void checkout() {

        driver.findElement(checkoutBtn).click();
    }
}