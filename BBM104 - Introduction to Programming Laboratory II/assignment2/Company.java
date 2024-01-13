public class Company extends Property
{
    public Company(int id, String name, int cost)
    {
        super(id, name, cost);
    }


    public int calculateRent(int diceNumber)
    {
        return 4 * diceNumber;
    }                   // calculate the rent of the company

}
