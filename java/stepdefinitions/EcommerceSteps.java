package stepdefinitions;



import base.BaseClass;
import io.cucumber.java.en.*;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

public class EcommerceSteps extends BaseClass {

    LoginPage lp;

    ProductPage pp;

    CartPage cp;

    @Given("user launches browser")
    public void launch_browser() {

        System.out.println("Browser Started");
    }

    @When("user enters username {string}")
    public void enter_username(String uname) {

        lp = new LoginPage(driver);

        lp.enterUsername(uname);
    }

    @When("user enters password {string}")
    public void enter_password(String pwd) {

        lp.enterPassword(pwd);
    }

    @When("user clicks login button")
    public void click_login() {

        lp.clickLogin();
    }

    @Then("user should login successfully")
    public void login_success() {

        System.out.println("Login Successful");
    }

    @When("user adds products to cart")
    public void add_products() {

        pp = new ProductPage(driver);

        pp.addProducts();
    }

    @When("user removes one product")
    public void remove_product() {

        cp = new CartPage(driver);

        cp.openCart();

        cp.removeProduct();
    }

    @When("user proceeds to checkout")
    public void checkout() {

        cp.checkout();
    }
}