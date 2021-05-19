package createUser.request;

public class CreateUserRequest {


    private String name;

    public CreateUserRequest(String name) {

        this.name=name;
    }


    public String getUserName() {

        return name;
    }
}
