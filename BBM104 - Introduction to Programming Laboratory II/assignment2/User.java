public abstract class User                      // abstract class can't instantiate
{
    protected String name;
    protected int money;


    public User(String name)
    {
        this.name = name;                   // constructor
    }


    public String getName()
    {
        return name;
    }
                                                    // 2 getter methods
    public int getMoney()
    {
        return money;
    }
}
