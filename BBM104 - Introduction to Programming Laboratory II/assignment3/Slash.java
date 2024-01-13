import java.util.ArrayList;

public class Slash extends MathematicalJewel                                            // subclass of MathematicalJewel
{

    public Slash(String symbol, int point)
    {
        super(symbol, point);
    }


    public int[][] checkMatch(ArrayList<ArrayList<String>> grid, int x, int y)                  // override the method
    {

        if(x >= 2 && y < grid.size() - 2)
        {
            if (isInMathSymbols(grid.get(x - 1).get(y + 1)) && isInMathSymbols(grid.get(x - 2).get(y + 2)))
            {
                int[][] array = new int[2][2];
                array[0][0] = x - 1;
                array[0][1] = y + 1;
                array[1][0] = x - 2;
                array[1][1] = y + 2;
                return array;
            }
        }


        if(x < grid.size() - 2 && y >= 2)
        {
            if (isInMathSymbols(grid.get(x + 1).get(y - 1)) && isInMathSymbols(grid.get(x + 2).get(y - 2)))
            {
                int[][] array = new int[2][2];
                array[0][0] = x + 1;
                array[0][1] = y - 1;
                array[1][0] = x + 2;
                array[1][1] = y - 2;
                return array;
            }
        }

        return new int[][]{};                                        // if returned array length is 0 then there is no match
    }
}
