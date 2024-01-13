import java.util.ArrayList;

public abstract class MathematicalJewel extends Jewel                               // an abstract class, subclass of Jewel
{
    protected static String[] mathSymbols = {"/", "-", "+", "|", "\\"};             // Math Symbols

    public MathematicalJewel(String symbol, int point)
    {
        super(symbol, point);
        //mathSymbols = new String[]{"/", "-", "+", "|", "\\"};
    }


    public abstract int[][] checkMatch(ArrayList<ArrayList<String>> grid, int x, int y);                // override the abstract method in abstract way


    public static boolean isInMathSymbols(String symbol)                                                // check whether a symbol is mathematical
    {
        for(String str : mathSymbols)
            if(symbol.equals(str))
                return true;

        return false;
    }
}
