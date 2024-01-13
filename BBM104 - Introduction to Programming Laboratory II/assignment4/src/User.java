public class User
{
    private String username;
    private String password;
    private boolean isClubMember;
    private boolean isAdmin;

    public User(String username, String password, boolean isClubMember, boolean isAdmin)
    {
        this.username = username;
        this.password = password;
        this.isClubMember = isClubMember;
        this.isAdmin = isAdmin;
    }


    @Override
    public String toString()
    {
        return "User: {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isClubMember=" + isClubMember +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean getIsClubMember()
    {
        return isClubMember;
    }

    public void setIsClubMember(boolean isClubMember)
    {
        this.isClubMember = isClubMember;
    }

    public boolean getIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }
}
