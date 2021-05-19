package updateUser.response;

public class UpdateUserResponse {

    private String name;

    private String job;

    private String updatedAt;

    private int statusCode;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getJob ()
    {
        return job;
    }

    public void setJob (String job)
    {
        this.job = job;
    }

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
