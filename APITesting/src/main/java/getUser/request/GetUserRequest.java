package getUser.request;

public class GetUserRequest {

    private int id;
    private String name;

    public GetUserRequest(int id)
    {

        this.id=id;
    }

    public int getUserId()
    {

        return id;
    }

    public void setUserName(String name)
    {
        this.name=name;

    }

    public String getUserName()
    {

        return name;
    }
}
