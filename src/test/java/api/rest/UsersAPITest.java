package api.rest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UsersAPITest {
    @Test
    public void getAllUsersAPI(){

        given().
                when()
                .get("https://reqres.in/api/users")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }


    @Test
    public void createUserAPI(){
        String jsonBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat()
                .statusCode(201)
                .body("name" ,equalTo("morpheus"))
                .log().all();
    }
}
