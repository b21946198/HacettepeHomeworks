public class Banker extends User                    // inherited from abstract class User
{
    public Banker(String name)                       // has 100 000 tl
    {
        super(name);
        this.money = 100000;
    }


    public void sellPlace(Property property)
    {
        this.money += property.getCost();
    }

    public void addMoney(int money) { this.money += money; }

    public void payMoney(int money) { this.money -= money; }
}
