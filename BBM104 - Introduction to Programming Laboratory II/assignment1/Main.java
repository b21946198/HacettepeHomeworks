import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        CalorieCalculationSystem calorieCalculationSystem = new CalorieCalculationSystem(args[0]);
        calorieCalculationSystem.run();                    // initiate the program

    }
}
