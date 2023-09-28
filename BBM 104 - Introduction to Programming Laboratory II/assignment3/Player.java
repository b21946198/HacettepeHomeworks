public class Player implements Comparable<Player>                   // class for hold Player who played bejeweled
{
    private final String name;
    private final int point;

    public Player(String name, int point)
    {
        this.name = name;
        this.point = point;
    }


    public int compareTo(Player player)                     // override the compareTo method
    {
        if(this.point > player.getPoint())
            return 1;
        return -1;
    }


    public String getName()
    {
        return name;
    }

    public int getPoint()
    {
        return point;
    }

}
