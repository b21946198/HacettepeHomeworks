import java.util.ArrayList;

public class Plus extends MathematicalJewel                                 // subclass of MathematicalJewel
{
    public Plus(String symbol, int point)
    {
        super(symbol, point);
    }


    public int[][] checkMatch(ArrayList<ArrayList<String>> grid, int x, int y)              // override the method
    {
        if (y >= 2)
        {
            if (isInMathSymbols(grid.get(x).get(y - 1)) && isInMathSymbols(grid.get(x).get(y - 2)))
            {
                int[][] array = new int[2][2];
                array[0][0] = x;
                array[0][1] = y - 1;
                array[1][0] = x;
                array[1][1] = y - 2;
                return array;
            }
        }

        if (y < grid.size() - 2)
        {
            if (isInMathSymbols(grid.get(x).get(y + 1)) && isInMathSymbols(grid.get(x).get(y + 2)))
            {
                int[][] array = new int[2][2];
                array[0][0] = x;
                array[0][1] = y + 1;
                array[1][0] = x;
                array[1][1] = y + 2;
                return array;
            }
        }

        if (x >= 2)
        {
            if (isInMathSymbols(grid.get(x - 1).get(y)) && isInMathSymbols(grid.get(x - 2).get(y)))
            {
                int[][] array = new int[2][2];
                array[0][0] = x - 1;
                array[0][1] = y;
                array[1][0] = x - 2;
                array[1][1] = y;
                return array;
            }
        }

        if (x < grid.size() - 2)
        {
            if (isInMathSymbols(grid.get(x + 1).get(y)) && isInMathSymbols(grid.get(x + 2).get(y)))
            {
                int[][] array = new int[2][2];
                array[0][0] = x + 1;
                array[0][1] = y;
                array[1][0] = x + 2;
                array[1][1] = y;
                return array;
            }
        }

        return new int[][]{};                                     // if returned array length is 0 then there is no match
    }
}
