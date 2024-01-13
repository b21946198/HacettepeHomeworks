import java.util.ArrayList;

public class Triangle extends Jewel                                                 // subclass of Jewel
{
    public Triangle(String symbol, int point)
    {
        super(symbol, point);
    }


    public int[][] checkMatch(ArrayList<ArrayList<String>> grid, int x, int y)          // override the method
    {
        if(x >= 2)
        {
            if (grid.get(x - 1).get(y).equals(symbol) && grid.get(x - 2).get(y).equals(symbol))
            {
                int[][] array = new int[2][2];
                array[0][0] = x - 1;
                array[0][1] = y;
                array[1][0] = x - 2;
                array[1][1] = y;
                return array;
            }
        }

        if(x < grid.size() - 2)
        {
            if (grid.get(x + 1).get(y).equals(symbol) && grid.get(x + 2).get(y).equals(symbol))
            {
                int[][] array = new int[2][2];
                array[0][0] = x + 1;
                array[0][1] = y;
                array[1][0] = x + 2;
                array[1][1] = y;
                return array;
            }
        }

        return new int[][]{};                                                       // if returned array length is 0 then there is no match
    }
}
