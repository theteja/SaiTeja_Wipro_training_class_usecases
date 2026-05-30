package Day28_2;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetUserTest {

    @Test
    public void getUser() {

        Response response = given()

                .baseUri("https://reqres.in/api")

        .when()

                .get("/users/1");

        Assert.assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();
    }
}