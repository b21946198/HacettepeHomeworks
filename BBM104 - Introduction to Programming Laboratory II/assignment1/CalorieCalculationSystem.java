import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CalorieCalculationSystem
{
    private ArrayList<ArrayList<String>> peopleList;
    private ArrayList<ArrayList<String>> foodsList;
    private ArrayList<ArrayList<String>> sportsList;
    private ArrayList<ArrayList<String>> commandsList;
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Sport> sports = new ArrayList<>();


    public CalorieCalculationSystem(String commandsFile) throws IOException
    {
        prepareFiles(commandsFile);

        createPeople(peopleList);
        createFoods(foodsList);             // read files and store data
        createSports(sportsList);

    }


    private void prepareFiles(String commandsFile) throws IOException
    {
        ArrayList<String> arrayList = ReadFile.readFileToArrayList("people.txt");
        peopleList = ReadFile.parseList(arrayList);

        ArrayList<String> arrayList2 = ReadFile.readFileToArrayList("food.txt");
        foodsList = ReadFile.parseList(arrayList2);

        ArrayList<String> arrayList3 = ReadFile.readFileToArrayList("sport.txt");
        sportsList = ReadFile.parseList(arrayList3);

        ArrayList<String> arrayList4 = ReadFile.readFileToArrayList(commandsFile);
        commandsList = ReadFile.parseList(arrayList4);

    }


    private void createPeople(ArrayList<ArrayList<String>> peopleList)
    {
        for(ArrayList<String> arr : peopleList)
        {
            String personID = arr.get(0);
            String name = arr.get(1);
            String gender = arr.get(2);
            int weight = Integer.parseInt(arr.get(3));
            int height = Integer.parseInt(arr.get(4));
            int dateOfBirth = Integer.parseInt(arr.get(5));

            Person person = new Person(personID, name, gender, weight, height, dateOfBirth);
            people.add(person);
        }
    }


    private void createFoods(ArrayList<ArrayList<String>> foodsList)
    {
        for(ArrayList<String> arr : foodsList)
        {
            String foodID = arr.get(0);
            String foodName = arr.get(1);
            int calorieCount = Integer.parseInt(arr.get(2));

            Food food = new Food(foodID, foodName, calorieCount);
            foods.add(food);
        }
    }


    private void createSports(ArrayList<ArrayList<String>> sportsList)
    {
        for(ArrayList<String> arr : sportsList)
        {
            String sportID = arr.get(0);
            String nameOfSport = arr.get(1);
            int calorieBurned = Integer.parseInt(arr.get(2));

            Sport sport = new Sport(sportID, nameOfSport, calorieBurned);
            sports.add(sport);
        }
    }


    public void run() throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("monitoring.txt", true));
        RunSystem.runCommands(commandsList, people, foods, sports, bw);                                     // run the system
        bw.close();

    }
}
