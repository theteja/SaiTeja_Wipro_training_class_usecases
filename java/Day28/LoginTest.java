package Day28;


import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import utils.ExtentManager;

public class LoginTest {

    @Test
    public void userLogin() {

        ExtentReports extent =
                ExtentManager.getReportObject();

        ExtentTest test =
                extent.createTest("Login API Test");

        String requestBody = "{\n" +
                "  \"username\": \"emilys\",\n" +
                "  \"password\": \"emilyspass\"\n" +
                "}";

        Response response = given()

                .header("Content-Type",
                        "application/json")

                .body(requestBody)

        .when()

                .post("https://dummyjson.com/user/login");

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath js = response.jsonPath();

        String token =
                js.getString("accessToken");

        System.out.println("Access Token: "
                + token);

        response.prettyPrint();

        test.pass("Login API executed successfully");

        extent.flush();
    }
}
