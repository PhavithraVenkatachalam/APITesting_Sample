import createUser.request.CreateUserRequest;
import createUser.response.CreateUserResponse;
import getUser.request.GetUserRequest;
import getUser.response.GetUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import updateUser.request.UpdateUserRequest;
import updateUser.response.UpdateUserResponse;

import static io.restassured.RestAssured.given;

public class UserClient {

public Response getAllUsers() {
    return given()
            .contentType(ContentType.JSON)
            .when()
            .get("https://reqres.in/api/users");

}

    public GetUserResponse getSpecificUser(GetUserRequest userRequest) {
        return given()
                .contentType(ContentType.JSON)
                .pathParam("user", userRequest.getUserId())
                .when()
                .get("https://reqres.in/api/users/{user}")
                .as(GetUserResponse.class);
    }

    public CreateUserResponse createUser(CreateUserRequest userRequest) {

        String uname="Tom";
        JSONObject requestParams=new JSONObject();
        requestParams.put("name",userRequest.getUserName());
        CreateUserResponse response= given()
                .contentType(ContentType.JSON)
                .body(requestParams.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .as(CreateUserResponse.class);
        response.setStatuscode(201);
        return response;
    }

//    public UpdateUserResponse updateUser(UpdateUserRequest userRequest){
//        JSONObject requestParams=new JSONObject();
//        requestParams.put("first_name",userRequest.getUserName());
//
//        System.out.println(userRequest.getUserName());
//        UpdateUserResponse response=given()
//                .contentType(ContentType.JSON)
//                .body(requestParams.toJSONString())
//                .when()
//                .put("https://reqres.in/api/users/2")
//                .as(UpdateUserResponse.class);
//
//        response.setStatuscode(200);
//        return response;

    }
}
