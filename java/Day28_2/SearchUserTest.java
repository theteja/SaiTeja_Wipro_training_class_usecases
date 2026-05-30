package Day28_2;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class SearchUserTest {

    @Test
    public void searchUser() {

        Response response = given()

                .baseUri("https://reqres.in/api")

                .queryParam("firstName", "Rahul")

        .when()

                .get("/users/search");

        Assert.assertEquals(response.getStatusCode(), 200);

        response.prettyPrint();
    }
}
