public abstract class Property
{
    protected int id;
    protected String name;
    protected int cost;


    public Property(int id, String name, int cost)
    {
        this.id = id;
        this.name = name;                           // constructor
        this.cost = cost;
    }


    public String toString()
    {
        return this.id + " " + this.name + " " + this.cost;
    }               // toString method for writing to the o/p file


    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }                   // 3 getter methods

    public int getCost() { return cost; }

}
