public class ActionSquare extends Square
{
    private static final int[] CHANCE_SQUARES = {7, 22, 36};
    private static final int[] COMMUNITY_CHEST_SQUARES = {2, 17, 33};

    private Action action;


    public ActionSquare(Action action)
    {
        this.action = action;

    }


    public Action getAction()
    {
        return action;
    }


    public static boolean isCommunityChest(int position)
    {
        for(int elt : COMMUNITY_CHEST_SQUARES)
            if(elt == position)
                return true;

        return false;
    }


    public static boolean isChance(int position)
    {
        for(int elt : CHANCE_SQUARES)
            if(elt == position)
                return true;

        return false;
    }
}
