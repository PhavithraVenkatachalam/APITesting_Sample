import createUser.request.CreateUserRequest;
import createUser.response.CreateUserResponse;
import deleteUser.DeleteUserRequest;
import getUser.request.GetUserRequest;
import getUser.response.GetUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import updateUser.request.UpdateUserRequest;
import updateUser.response.UpdateUserResponse;

import static io.restassured.RestAssured.given;

public class APItesting {

    UserClient userClient;

    @BeforeClass
    public void beforeClass()
    {

        userClient=new UserClient();
    }

    @Test
    public void shouldGetAllUsers()
    {
                userClient.getAllUsers()
                        .then()
                        .assertThat().statusCode(200)
                        .log().all();
    }


    @Test
    public void shouldGetUser()
    {
                GetUserRequest userRequest=new GetUserRequest(2);
                GetUserResponse userResponse=userClient.getSpecificUser(userRequest);
                System.out.println(userResponse.getData());
    }


    @Test
    public void shouldCreateUser()
    {
        CreateUserRequest userRequest=new CreateUserRequest("Tom");
        CreateUserResponse userResponse= userClient.createUser(userRequest);

        Assert.assertEquals(userResponse.getName(),"Tom");
        Assert.assertEquals(userResponse.getStatusCode(),201);
    }

    @Test
    public void shouldUpdateUser()
    {
        UpdateUserRequest userRequest=new UpdateUserRequest("Hari");
        UpdateUserResponse response = userClient.updateUser(userRequest);
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void shouldDeleteSpecificUser()
    {
        DeleteUserRequest userRequest=new DeleteUserRequest(3);
        Response response = userClient.deleteUser(userRequest);
        Assert.assertEquals(response.getStatusCode(),204);
    }


    @Test
    public void sampleTestWithQueryParam()
    {
        given()
                .contentType(ContentType.JSON)
                .queryParam("brewed_before","11-2020")
                .queryParam("abv_gt",6)
                .when()
                .get("https://api.punkapi.com/v2/beers")
                .then()
                .assertThat().statusCode(200);
    }

}
