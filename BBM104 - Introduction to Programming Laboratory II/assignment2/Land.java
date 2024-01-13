public class Land extends Property
{
    public Land(int id, String name, int cost)
    {
        super(id, name, cost);
    }


    public int calculateRent()                      // calculate the rent for Land
    {
        if(this.cost > 0 && this.cost <= 2000)
            return (int) (this.cost * 0.4);

        else if(this.cost > 2000 && this.cost <= 3000)
            return (int) (this.cost * 0.3);

        else
            return (int) (this.cost * 0.35);
    }
}
