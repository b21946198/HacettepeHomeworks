import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Monopoly monopoly = new Monopoly(args[0]);              // create Monopoly object
        monopoly.play();                                        // and start the game
    }
}
