package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.DriverManager;
import pages.LoginPage;
import utils.CsvUtil;
import utils.JsonUtil;

public class LoginTest {

    @BeforeMethod
    public void setup() {

        DriverManager.getDriver();

        DriverManager.getDriver()
                .get("https://www.saucedemo.com");
    }

    @DataProvider(name = "csvData")
    public Object[][] csvData() throws Exception {

        return CsvUtil.getCsvData();
    }

    @DataProvider(name = "jsonData")
    public Object[][] jsonData() throws Exception {

        return JsonUtil.getJsonData();
    }

    @Test(dataProvider = "csvData")
    public void loginUsingCsv(
            String username,
            String password) {

        LoginPage login =
                new LoginPage(
                        DriverManager.getDriver());

        login.login(username, password);

        Assert.assertTrue(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("inventory"));
    }

    @Test(dataProvider = "jsonData")
    public void loginUsingJson(
            String username,
            String password) {

        LoginPage login =
                new LoginPage(
                        DriverManager.getDriver());

        login.login(username, password);

        Assert.assertTrue(
                DriverManager.getDriver()
                        .getCurrentUrl()
                        .contains("inventory"));
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitBrowser();
    }
}