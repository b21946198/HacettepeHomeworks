public class PropertySquare extends Square
{
    private static final int[] LAND_SQUARES = {1, 3, 6, 8, 9, 11, 13, 14, 16, 18, 19, 21, 23, 24, 26, 27, 29, 31, 32, 34, 37, 39};      // squares which contain land
    private static final int[] RAILROAD_SQUARES = {5, 15, 25, 35};                  // squares which contain railroad
    private static final int[] COMPANY_SQUARES = {12, 28};                          // squares which contain company

    private Property property;


    public PropertySquare(Property property)
    {
        this.property = property;
    }


    public Property getProperty()
    {
        return property;
    }


    public static boolean isLand(int position)
    {
        for(int elt : LAND_SQUARES)
            if(elt == position)                     // if it is a land return true
                return true;

        return false;
    }


    public static boolean isRailroad(int position)
    {
        for(int elt : RAILROAD_SQUARES)
            if(elt == position)
                return true;                            // if it is a railroad return true

        return false;
    }


    public static boolean isCompany(int position)
    {
        for(int elt : COMPANY_SQUARES)
            if(elt == position)                     // if it is a land company true
                return true;

        return false;
    }
}
