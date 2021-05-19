package deleteUser;

public class DeleteUserRequest {


    private int id;

    public DeleteUserRequest(int id) {

        this.id=id;
    }


    public int getUserId() {

        return id;
    }
}
