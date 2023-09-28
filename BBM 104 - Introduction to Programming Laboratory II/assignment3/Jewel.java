import java.util.ArrayList;

public abstract class Jewel                                     // an abstract class for blueprint all the jewels
{
    protected String symbol;
    protected final int POINT;

    public Jewel(String symbol, int point)
    {
        this.symbol = symbol;
        POINT = point;
    }

    public abstract int[][] checkMatch(ArrayList<ArrayList<String>> grid, int x, int y);                // an abstract method

    public String getSymbol()
    {
        return symbol;
    }
                                                                        // getter methods
    public int getPOINT()
    {
        return POINT;
    }
}
