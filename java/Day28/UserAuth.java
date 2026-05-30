package Day28;

import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UserAuth {

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

        // Parameterized test data
        String username = "emilys";
        String password = "emilyspass";

        String requestBody = "{"
                + "\"username\":\"" + username + "\","
                + "\"password\":\"" + password + "\","
                + "\"expiresInMins\":30"
                + "}";

        try {

            // ---------------- LOGIN API ----------------

            test.info("Generating Access Token");

            Response loginResponse = given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                .when()
                    .post("https://dummyjson.com/user/login");

            // API Validation - Status Code
            int loginStatusCode = loginResponse.getStatusCode();
            Assert.assertEquals(loginStatusCode, 200);
            test.pass("Login API Status Code Validated");

            // API Validation - Response Time
            long responseTime = loginResponse.getTime();
            System.out.println("Login API Response Time: " + responseTime);

            Assert.assertTrue(responseTime < 3000);
            test.pass("Response Time Validated");

            // API Validation - Response Schema/Body
            String token = loginResponse.jsonPath().getString("accessToken");

            Assert.assertNotNull(token);
            test.pass("Access Token Generated Successfully");

            // ---------------- REQUEST CHAINING ----------------
            // Using generated token in next API request

            test.info("Calling User Profile API using Bearer Token");

            Response userResponse = given()
                    .header("Authorization", "Bearer " + token)
                .when()
                    .get("https://dummyjson.com/user/me");

            // Status Code Validation
            int userStatusCode = userResponse.getStatusCode();

            Assert.assertEquals(userStatusCode, 200);
            test.pass("User Profile API Status Code Validated");

            // Response Body Validation
            String firstName =
                    userResponse.jsonPath().getString("firstName");

            String email =
                    userResponse.jsonPath().getString("email");

            System.out.println("User Name: " + firstName);
            System.out.println("Email: " + email);

            Assert.assertEquals(firstName, "Emily");

            test.pass("User Details Validated Successfully");

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
