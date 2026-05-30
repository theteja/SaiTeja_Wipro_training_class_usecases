package Day28;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import utils.ExtentManager;

public class DeleteUser {

    @Test
    public void deleteUser() {

        // GET REPORT OBJECT

        ExtentReports extent =
                ExtentManager.getReportObject();

        // CREATE TEST

        ExtentTest test =
                extent.createTest("Delete User API Test");

        // DELETE API REQUEST

        Response response = given()

        .when()

            .delete("https://dummyjson.com/users/1");

        // STATUS CODE VALIDATION

        Assert.assertEquals(response.getStatusCode(), 200);

        // JSON PARSING

        JsonPath js = response.jsonPath();

        boolean isDeleted =
                js.getBoolean("isDeleted");

        System.out.println("User Deleted: "
                + isDeleted);

        response.prettyPrint();

        // REPORT STATUS

        test.pass("Delete User API executed successfully");

        // SAVE REPORT

        extent.flush();
    }
}