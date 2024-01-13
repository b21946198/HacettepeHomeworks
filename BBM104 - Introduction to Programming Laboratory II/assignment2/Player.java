import java.util.ArrayList;

public class Player extends User                    // inherited from abstract class User
{
    private int position;
    private ArrayList<Property> ownedPlaces = new ArrayList<>();
    private int numberOfRailroads = 0;
    private int jailCounter = 0;


    public Player(String name)                   // has 15 000 tl
    {
        super(name);
        this.money = 15000;                     // constructor initiate the initial values
        this.position = 0;
    }


    public void buyPlace(Property property)             // buy a property if available
    {
        ownedPlaces.add(property);
        this.money -= property.getCost();
    }


    public void move(int step, Banker banker)           // move according to the dice
    {
        this.position += step;

        if(this.position > 39)
        {
            this.money += 200;
            this.position %= 40;
            banker.payMoney(200);
        }

    }



    public boolean hasPlace(Property property)                  // player's owned places
    {
        for(Property prp : ownedPlaces)
        {
            if(prp.getId() == (property.getId()))
                return true;
        }

        return false;
    }


    public void payRent(Property property, int dice)                // pay the rent to the another player
    {
        if(property instanceof Land)
            this.money -= ((Land) property).calculateRent();

        else if(property instanceof Company)
            this.money -= ((Company) property).calculateRent(dice);

        else if(property instanceof Railroad)
            this.money -= 25 * this.numberOfRailroads;

    }


    public void takeRent(Property property, int dice)               // take the rent from the another player
    {
        if(property instanceof Land)
            this.money += ((Land) property).calculateRent();

        else if(property instanceof Company)
            this.money += ((Company) property).calculateRent(dice);

        else if(property instanceof Railroad)
            this.money += 25 * this.numberOfRailroads;
    }


    public String obtainProperties()                                // all owned places
    {
        if(ownedPlaces.size() == 0)
            return "";

        String temp = "";

        for(Property property : ownedPlaces)
        {
            if(property.equals(ownedPlaces.get(ownedPlaces.size() - 1)))
            {
                temp += property.getName();
            }
            else
                temp += property.getName() + ", ";
        }
        return temp;
    }


    public void buyARailroad()
    {
        this.numberOfRailroads++;
    }

    public int getPosition()
    {
        return this.position;
    }

    public void setPosition(int position) { this.position = position; }

    public void passGo() { this.money += 200; }

    public void addMoney(int money) { this.money += money; }

    public void payMoney(int money) { this.money -= money; }

    public int getJailCounter()
    {
        return jailCounter;
    }

    public void setJailCounter(int jailCounter)
    {
        this.jailCounter = jailCounter;
    }

    public void waitJail()              // waiting in the jail until the turns are over for waiting
    {
        this.jailCounter--;
        if(this.jailCounter < 0)
            this.jailCounter = 0;
    }
}
