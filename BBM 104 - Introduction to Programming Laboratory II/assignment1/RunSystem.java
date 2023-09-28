import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RunSystem
{
    public static void runCommands(ArrayList<ArrayList<String>> commandsList, ArrayList<Person> people,
                                   ArrayList<Food> foods, ArrayList<Sport> sports, BufferedWriter bw) throws IOException
    {
        ArrayList<Person> readPeople = new ArrayList<>();
        int i = 0;

        for(ArrayList<String> arr : commandsList)
        {
            i++;

            if(arr.get(0).contains("Warn"))                                 // for warn command
            {
                ArrayList<Person> temp = new ArrayList<>();

                for(Person person : readPeople)
                {
                    int result = -1 * (person.getDailyCalorieNeeds() - person.getGainCalories() + person.getBurnedCalories());      // calculate calories

                    if(result > 0)                      // if it warns added to the list
                        temp.add(person);
                }

                if(temp.size() == 0)
                {
                    bw.write("there\tis\tno\tsuch\tperson");

                    if(i != commandsList.size())
                        bw.write("\n***************");
                }

                else
                {
                    for(Person person : temp)
                    {
                        int age = 2022 - person.getDateOFBirth();
                        int result = -1 * (person.getDailyCalorieNeeds() - person.getGainCalories() + person.getBurnedCalories());

                        bw.write(person.getName() + "\t" + age + "\t" + person.getDailyCalorieNeeds() + "kcal" + "\t" +
                                person.getGainCalories() + "kcal" + "\t" + person.getBurnedCalories() + "kcal" + "\t" + "+" + result + "kcal" + "\n");
                    }
                    if(i != commandsList.size())
                        bw.write("***************");
                }
            }

            else if(arr.get(0).contains("List"))                            // for list command
            {
                for(Person person : readPeople)
                {
                    int age = 2022 - person.getDateOFBirth();
                    int result = -1 * (person.getDailyCalorieNeeds() - person.getGainCalories() + person.getBurnedCalories());

                    if(result > 0 )
                    {
                        if(i == commandsList.size() && person == readPeople.get(readPeople.size() - 1))
                            bw.write(person.getName() + "\t" + age + "\t" + person.getDailyCalorieNeeds() + "kcal" + "\t" +
                                    person.getGainCalories() + "kcal" + "\t" + person.getBurnedCalories() + "kcal" + "\t" + "+" + result + "kcal");

                        else
                            bw.write(person.getName() + "\t" + age + "\t" + person.getDailyCalorieNeeds() + "kcal" + "\t" +
                                    person.getGainCalories() + "kcal" + "\t" + person.getBurnedCalories() + "kcal" + "\t" + "+" + result + "kcal" + "\n");
                    }

                    else
                    {
                        if(i == commandsList.size() && person == readPeople.get(readPeople.size() - 1))
                            bw.write(person.getName() + "\t" + age + "\t" + person.getDailyCalorieNeeds() + "kcal" + "\t" +
                                    person.getGainCalories() + "kcal" + "\t" + person.getBurnedCalories() + "kcal" + "\t" + result + "kcal");

                        else
                            bw.write(person.getName() + "\t" + age + "\t" + person.getDailyCalorieNeeds() + "kcal" + "\t" +
                                    person.getGainCalories() + "kcal" + "\t" + person.getBurnedCalories() + "kcal" + "\t" + result + "kcal" + "\n");

                    }
                }

                if(i != commandsList.size())
                    bw.write("***************");
            }

            else if(arr.size() == 3)
            {
                String personID = arr.get(0);

                if(arr.get(1).charAt(0) == '1')
                {
                    String foodID = arr.get(1);
                    int numberOfPortions = Integer.parseInt(arr.get(2));

                    Person tempPerson = takePerson(personID, people);
                    Food tempFood = takeFood(foodID, foods);
                    assert tempFood != null;
                    assert tempPerson != null;

                    int calorie = numberOfPortions * tempFood.getCalorieCount();
                    tempPerson.addCalories(calorie);

                    addPerson(tempPerson, readPeople);

                    bw.write(personID + "\t" + "has" + "\t" + "taken" + "\t" + calorie + "kcal" + "\t" + "from" + "\t" + tempFood.getNameOfFood());

                }

                else
                {
                    String sportID = arr.get(1);
                    int minutes = Integer.parseInt(arr.get(2));

                    Person tempPerson = takePerson(personID, people);
                    Sport tempSport = takeSport(sportID, sports);
                    assert tempSport != null;
                    assert tempPerson != null;

                    int calorie = minutes * tempSport.getCalorieBurned() / 60;
                    tempPerson.addBurnCalories(calorie);

                    addPerson(tempPerson, readPeople);

                    bw.write(personID + "\t" + "has" + "\t" + "burned" + "\t" + calorie + "kcal" + "\t" + "thanks" + "\t" + "to" + "\t" + tempSport.getNameOfSport());

                }

                if(i != commandsList.size())
                    bw.write("\n***************");
            }

            else
            {
                String personID = arr.get(0).substring(6, 11);

                Person person = takePerson(personID, people);
                assert person != null;

                int age = 2022 - person.getDateOFBirth();

                int result = -1 * (person.getDailyCalorieNeeds() - person.getGainCalories() + person.getBurnedCalories());

                if(result > 0)
                {
                    bw.write(person.getName() + "\t" + age + "\t" + person.getDailyCalorieNeeds() + "kcal" + "\t" +
                            person.getGainCalories() + "kcal" + "\t" + person.getBurnedCalories() + "kcal" + "\t" + "+" + result + "kcal");
                }

                else
                {
                    bw.write(person.getName() + "\t" + age + "\t" + person.getDailyCalorieNeeds() + "kcal" + "\t" +
                            person.getGainCalories() + "kcal" + "\t" + person.getBurnedCalories() + "kcal" + "\t" + result + "kcal");
                }

                if(i != commandsList.size())
                    bw.write("\n***************");


            }

            if(i != commandsList.size())
                bw.write("\n");
        }


    }


    public static Person takePerson(String personID, ArrayList<Person> people)              // get person from id
    {
        for(Person person : people)
        {
            if(person.getPersonID().equals(personID))
                return person;
        }

        return null;
    }


    public static Food takeFood(String foodID, ArrayList<Food> foods)                       // get food from id
    {
        for(Food food : foods)
        {
            if(food.getFoodID().equals(foodID))
                return food;
        }

        return null;
    }


    public static Sport takeSport(String sportID, ArrayList<Sport> sports)                  // get sport from id
    {
        for(Sport sport : sports)
        {
            if(sport.getSportID().equals(sportID))
                return sport;
        }
        return null;
    }


    public static void addPerson(Person person, ArrayList<Person> readPeople)               // add person to the people list
    {
        boolean flag = true;

        for(Person person2 : readPeople)
        {
            if(person.getPersonID().equals(person2.getPersonID()))
            {
                flag = false;
                break;
            }
        }

        if(flag)
            readPeople.add(person);
    }
}
