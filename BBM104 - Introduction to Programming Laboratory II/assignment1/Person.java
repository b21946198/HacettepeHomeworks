public class Person
{
    private String personID;
    private String name;
    private String gender;
    private int weight;
    private int height;
    private int dateOFBirth;
    private int dailyCalorieNeeds;
    private int gainCalories = 0;
    private int burnedCalories = 0;


    public Person(String personID, String name, String gender, int weight, int height, int dateOFBirth)         // constructor
    {
        this.personID = personID;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.dateOFBirth = dateOFBirth;
        calculateDailyCalorieNeeds();
    }


    public void addCalories(int calories)
    {
        this.gainCalories += calories;
    }

    public void addBurnCalories(int calories)
    {
        this.burnedCalories += calories;
    }


    private void calculateDailyCalorieNeeds()                   // calculate daily calorie need by gender
    {
        double temp;

        if(this.gender.equals("male"))
        {
            temp = 66 + (13.75 * this.weight) + (5 * this.height) - (6.8 * (2022 - this.dateOFBirth));
        }

        else
        {
            temp = 665 + (9.6 * this.weight) + (1.7 * this.height) - (4.7 * (2022 - this.dateOFBirth));
        }

        this.dailyCalorieNeeds = (int) Math.round(temp);
    }

    public String getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public int getDateOFBirth() {
        return dateOFBirth;
    }

    public int getDailyCalorieNeeds() {
        return dailyCalorieNeeds;
    }               // for access private fields

    public int getGainCalories() {
        return gainCalories;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

}
