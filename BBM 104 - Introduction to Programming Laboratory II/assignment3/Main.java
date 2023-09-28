import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException
    {
        Bejeweled bejeweled = new Bejeweled(args[0], args[1]);
        bejeweled.play();                                   // initiate the game

    }
}
