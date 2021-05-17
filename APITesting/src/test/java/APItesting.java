import groovy.json.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APItesting {

    @Test
    public void sampleTest()
    {
                given()
                        .contentType(ContentType.JSON)
                .when()
                        .get("https://reqres.in/api/users")
                .then()
                        .assertThat().statusCode(200)
                        .log().all();
    }

    @Test
    public void testWithBodyParam()
    {
                given()
                        .contentType(ContentType.JSON)
                        .pathParam("user",4)
                .when()
                        .get("https://reqres.in/api/users/{user}")
                .then()
                        .assertThat().statusCode(200)
                        .log().all();

    }

    @Test
    public void shouldCreateUser()
    {
        given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Tom\"}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat().statusCode(201)
                .log().all();

        //asserting the created response using response object
        Response res=given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Tom\"}")
                .when()
                .post("https://reqres.in/api/users");

        Assert.assertEquals(res.jsonPath().get("name"),"Tom");

    }

    @Test
    public void sampleTestWithQueryParam()
    {

    }

}
