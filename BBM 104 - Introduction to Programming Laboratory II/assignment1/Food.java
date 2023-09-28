public class Food
{
    private String foodID;                  // fruits 10..  meals 11..  deserts 12..    nuts 13..
    private String nameOfFood;
    private int calorieCount;               // 1 portion is 100 grams for every food


    public Food(String foodID, String nameOfFood, int calorieCount)             // constructor
    {
        this.foodID = foodID;
        this.nameOfFood = nameOfFood;
        this.calorieCount = calorieCount;
    }


    public String getFoodID() {
        return foodID;
    }

    public String getNameOfFood() {
        return nameOfFood;
    }               // for access private fields

    public int getCalorieCount() {
        return calorieCount;
    }

}
