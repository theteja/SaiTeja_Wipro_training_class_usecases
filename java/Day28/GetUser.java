package Day28;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import utils.ExtentManager;

public class GetUser{

    @Test
    public void getUser() {

        ExtentReports extent =
                ExtentManager.getReportObject();

        ExtentTest test =
                extent.createTest("Get User API Test");

        Response response = given()

        .when()

            .get("https://dummyjson.com/users/1");

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath js = response.jsonPath();

        String firstName =
                js.getString("firstName");

        System.out.println("First Name: "
                + firstName);

        response.prettyPrint();

        test.pass("Get User API executed successfully");

        extent.flush();
    }
}