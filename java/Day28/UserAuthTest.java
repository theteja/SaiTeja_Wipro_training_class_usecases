package Day28;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UserAuthTest {

    ExtentReports extent;

    @BeforeSuite
    public void setupReport() {

        ExtentSparkReporter reporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Test
    public void AuthTest() {

        ExtentTest test =
                extent.createTest("Authenticated User API Test");

        String requestBody = "{"
                + "\"username\":\"emilys\","
                + "\"password\":\"emilyspass\","
                + "\"expiresInMins\":30"
                + "}";

        try {

            test.info("Generating Access Token");

            String token = given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                .when()
                    .post("https://dummyjson.com/user/login")
                .then()
                    .extract()
                    .path("accessToken");

            test.info("Token Generated Successfully");

            int statusCode = given()
                    .header("Authorization", "Bearer " + token)
                .when()
                    .get("https://dummyjson.com/user/me")
                .then()
                    .log().all()
                    .extract()
                    .statusCode();

            Assert.assertEquals(statusCode, 200);

            test.pass("Authenticated User API Test Passed");

        } catch (Exception e) {

            test.fail("Authenticated User API Test Failed");
            test.fail(e.getMessage());
        }
    }

    @AfterSuite
    public void tearDownReport() {

        extent.flush();
    }
}