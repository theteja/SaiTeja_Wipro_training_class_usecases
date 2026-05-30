package Day28;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import utils.ExtentManager;

public class GetCurrentUser {

    @Test
    public void getCurrentUserData() {

        ExtentReports extent =
                ExtentManager.getReportObject();

        ExtentTest test =
                extent.createTest("Get Current User Data API Test");

        // LOGIN BODY

        String loginBody = "{\n" +
                "  \"username\": \"emilys\",\n" +
                "  \"password\": \"emilyspass\"\n" +
                "}";

        // LOGIN API

        Response loginResponse = given()

                .header("Content-Type",
                        "application/json")

                .body(loginBody)

        .when()

                .post("https://dummyjson.com/user/login");

        // EXTRACT TOKEN

        JsonPath loginJson =
                loginResponse.jsonPath();

        String token =
                loginJson.getString("accessToken");

        // GET CURRENT USER DATA

        Response response = given()

                .header("Authorization",
                        "Bearer " + token)

        .when()

                .get("https://dummyjson.com/user/me");

        Assert.assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();

        test.pass("Get Current User Data API executed successfully");

        extent.flush();
    }
}