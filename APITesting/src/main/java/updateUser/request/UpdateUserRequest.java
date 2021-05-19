package updateUser.request;

public class UpdateUserRequest {


    private String name;

    public UpdateUserRequest(String name) {

        this.name=name;
    }

    public String getUserName() {
        return name;
    }
}
