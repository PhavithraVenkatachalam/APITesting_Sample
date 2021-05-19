package updateUser.response;

public class UpdateUserResponse {

    private String updatedAt;

    private int statusCode;

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public void setStatuscode(int code)
    {
        this.statusCode=code;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

}
