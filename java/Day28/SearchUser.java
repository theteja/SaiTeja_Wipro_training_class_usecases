package Day28;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import utils.ExtentManager;

public class SearchUser{

    @Test
    public void searchUser() {

        ExtentReports extent =
                ExtentManager.getReportObject();

        ExtentTest test =
                extent.createTest("Search User API Test");

        Response response = given()

        .queryParam("q", "John")

        .when()

            .get("https://dummyjson.com/users/search");

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath js = response.jsonPath();

        int totalUsers =
                js.getInt("total");

        System.out.println("Total Users: "
                + totalUsers);

        response.prettyPrint();

        test.pass("Search User API executed successfully");

        extent.flush();
    }
}