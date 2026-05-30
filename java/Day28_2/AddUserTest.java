package Day28_2;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import utils.ExcelUtils;

public class AddUserTest {

    @DataProvider(name = "excelData")
    public Object[][] getData() {

        return ExcelUtils.getExcelData();
    }

    @Test(dataProvider = "excelData")

    public void addUser(String firstName,
                        String lastName,
                        String age) {

        String requestBody = "{\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"age\": " + age + "\n" +
                "}";

        Response response = given()

                .baseUri("https://reqres.in/api")

                .header("Content-Type",
                        "application/json")

                .body(requestBody)

        .when()

                .post("/users/add");

        Assert.assertEquals(response.getStatusCode(), 201);

        response.prettyPrint();
    }
}