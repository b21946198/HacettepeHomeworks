import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Bejeweled
{
    private ArrayList<ArrayList<String>> grid;
    private ArrayList<ArrayList<String>> commands;

    public Bejeweled(String gridFile, String commandFile) throws IOException            // constructor for read files and construct the grid
    {
        makeGrid(gridFile);
        createCommands(commandFile);
    }


    public void play() throws IOException                                                       // initiate the game
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter("monitoring.txt"));
        bw.write("Game grid:\n");
        printGrid(bw);
        int totalScore = 0;

        for(int i = 0; i < commands.size(); i++)                                                // read commands
        {
            if(!(commands.get(i).get(0).equals("E")))                                           // if command is not "E"
            {
                int x = Integer.parseInt(commands.get(i).get(0));
                int y = Integer.parseInt(commands.get(i).get(1));

                bw.write("Select coordinate or enter E to end the game: " + x + " " + y + "\n");

                String symbol = grid.get(x).get(y);

                if(symbol.equals(" "))
                {
                    bw.write("\nPlease enter a valid coordinate\n\n");
                    continue;
                }

                if(x < 0 || y < 0)
                {
                    bw.write("\nPlease enter a valid coordinate\n\n");
                    continue;
                }

                if(y > grid.size())
                {
                    bw.write("\nPlease enter a valid coordinate\n\n");
                    continue;
                }

                if(x > grid.get(y).size())
                {
                    bw.write("\nPlease enter a valid coordinate\n\n");
                    continue;
                }

                Jewel jewel = null;

                if(symbol.equals("D"))
                    jewel = new Diamond(symbol, 30);

                else if(symbol.equals("S"))
                    jewel = new Square(symbol, 15);

                else if(symbol.equals("T"))
                    jewel = new Triangle(symbol, 15);

                else if(symbol.equals("W"))
                    jewel = new Wildcard(symbol, 10);

                else if(symbol.equals("/"))
                    jewel = new Slash(symbol, 20);

                else if(symbol.equals("-"))
                    jewel = new Minus(symbol, 20);

                else if(symbol.equals("+"))
                    jewel = new Plus(symbol, 20);

                else if(symbol.equals("\\"))
                    jewel = new BackSlash(symbol, 20);

                else if(symbol.equals("|"))
                    jewel = new Bar(symbol, 20);

                assert jewel != null;

                int[][] tripletIndices = jewel.checkMatch(grid, x, y);                              // use Jewel's abstract method checkMatch (polymorphism)

                if(tripletIndices.length != 0)                                                      // if there is a match
                {
                    int score;
                    score = popTriplet(tripletIndices, x, y);
                    printGrid(bw);
                    bw.write("Score: " + score + " points\n\n");
                    totalScore += score;
                }

                else                                                                                // if there's no match there aren't any pop and score doesn't change
                {
                    printGrid(bw);
                    bw.write("Score: 0 points\n\n");
                }

            }

            else                                                                                    // if command is E game is done
            {
                bw.write("Select coordinate or enter E to end the game: E\n\n");

                String name = commands.get(i + 1).get(0);                                           // other command is name of the player
                ArrayList<Player> players = createPlayers("leaderboard.txt");
                Player player = new Player(name, totalScore);
                players.add(player);

                BufferedWriter bw2 = new BufferedWriter(new FileWriter("leaderboard.txt", true));
                bw2.write("\n" + player.getName() + " " + player.getPoint());

                bw.write("Total score: " + player.getPoint() + " points\n\n");
                bw.write("Enter name: " + player.getName() + "\n\n");

                Collections.sort(players, Collections.reverseOrder());
                
                int place = 0;
                
                for(int it = 0; it < players.size();it++)
                    if(players.get(it).getPoint() == player.getPoint())
                        place = it + 1;
                    
                if(place == 1)
                {
                    String otherName = players.get(place).getName();
                    int otherPoint = players.get(place).getPoint();
                    int diff = player.getPoint() - otherPoint;
                    bw.write("Your rank is " + place + "/" + players.size() + ", your score is " + diff + " points higher than " + otherName + "\n\n");
                }

                else if(place == players.size())
                {
                    String otherName = players.get(place - 2).getName();
                    int otherPoint = players.get(place - 2).getPoint();
                    int diff = Math.abs(player.getPoint() - otherPoint);
                    bw.write("Your rank is " + place + "/" + players.size() + ", your score is " + diff + " points lower than " + otherName + "\n\n");

                }

                else
                {
                    String higherName = players.get(place).getName();
                    int higherPoint = players.get(place).getPoint();
                    int diff1 = player.getPoint() - higherPoint;

                    String lowerName = players.get(place - 2).getName();
                    int lowerPoint = players.get(place - 2).getPoint();
                    int diff2 = Math.abs(player.getPoint() - lowerPoint);

                    bw.write("Your rank is " + place + "/" + players.size() + ", your score is " + diff1 + " points lower than " + lowerName + " and ");
                    bw.write(diff2 + " points higher than " + higherName + "\n\n");
                }

                bw.write("Good bye!");                          // game is finished

                bw2.close();
                break;
            }
        }

        bw.close();
    }


    public int popTriplet(int[][] tripletIndices, int x, int y)                         // pop the jewels and return the score
    {
        int x1 = tripletIndices[0][0];
        int y1 = tripletIndices[0][1];
        int x2 = tripletIndices[1][0];
        int y2 = tripletIndices[1][1];

        int score;
        score = calculateScore(tripletIndices, x, y);

        grid.get(x).set(y, " ");
        grid.get(x1).set(y1, " ");
        grid.get(x2).set(y2, " ");

        if(y == y1 && y1 == y2)                                     // if jewels are on the same column
        {
            int tmp = Math.min(x, x1);
            int min = Math.min(tmp, x2);
            int tmp2 = Math.max(x, x1);
            int max = Math.max(tmp2, x2);

            for(int u = min; u <= max; u++)
            {
                int z = u;
                int cnt = -1;
                cnt++;

                while(z > cnt)
                {
                    String temp = grid.get(z).get(y);
                    grid.get(z).set(y, grid.get(z - 1).get(y));
                    grid.get(z - 1).set(y, temp);
                    z--;
                }

            }

            return score;
        }

        while (x > 0)
        {
            String temp = grid.get(x).get(y);
            grid.get(x).set(y, grid.get(x - 1).get(y));
            grid.get(x - 1).set(y, temp);
            x--;
        }

        while (x1 > 0)
        {
            String temp = grid.get(x1).get(y1);
            grid.get(x1).set(y1, grid.get(x1 - 1).get(y1));
            grid.get(x1 - 1).set(y1, temp);
            x1--;
        }

        while (x2 > 0)
        {
            String temp = grid.get(x2).get(y2);
            grid.get(x2).set(y2, grid.get(x2 - 1).get(y2));
            grid.get(x2 - 1).set(y2, temp);
            x2--;
        }

        return score;
    }


    public int calculateScore(int[][] tripletIndices, int x, int y)                                     // calculate the triplets score
    {
        int x1 = tripletIndices[0][0];
        int y1 = tripletIndices[0][1];
        int x2 = tripletIndices[1][0];
        int y2 = tripletIndices[1][1];

        String symbol = grid.get(x).get(y);
        String symbol1 = grid.get(x1).get(y1);
        String symbol2 = grid.get(x2).get(y2);

        Jewel jewel = null;

        if(symbol.equals("D"))
            jewel = new Diamond(symbol, 30);

        else if(symbol.equals("S"))
            jewel = new Square(symbol, 15);

        else if(symbol.equals("T"))
            jewel = new Triangle(symbol, 15);

        else if(symbol.equals("W"))
            jewel = new Wildcard(symbol, 10);

        else if(symbol.equals("/"))
            jewel = new Slash(symbol, 20);

        else if(symbol.equals("-"))
            jewel = new Minus(symbol, 20);

        else if(symbol.equals("+"))
            jewel = new Plus(symbol, 20);

        else if(symbol.equals("\\"))
            jewel = new BackSlash(symbol, 20);

        else if(symbol.equals("|"))
            jewel = new Bar(symbol, 20);

        assert jewel != null;


        Jewel jewel2 = null;

        if(symbol1.equals("D"))
            jewel2 = new Diamond(symbol1, 30);

        else if(symbol1.equals("S"))
            jewel2 = new Square(symbol1, 15);

        else if(symbol1.equals("T"))
            jewel2 = new Triangle(symbol1, 15);

        else if(symbol1.equals("W"))
            jewel2 = new Wildcard(symbol1, 10);

        else if(symbol1.equals("/"))
            jewel2 = new Slash(symbol1, 20);

        else if(symbol1.equals("-"))
            jewel2 = new Minus(symbol1, 20);

        else if(symbol1.equals("+"))
            jewel2 = new Plus(symbol1, 20);

        else if(symbol1.equals("\\"))
            jewel2 = new BackSlash(symbol1, 20);

        else if(symbol1.equals("|"))
            jewel2 = new Bar(symbol1, 20);


        assert jewel2 != null;


        Jewel jewel3 = null;

        if(symbol2.equals("D"))
            jewel3 = new Diamond(symbol2, 30);

        else if(symbol2.equals("S"))
            jewel3 = new Square(symbol2, 15);

        else if(symbol2.equals("T"))
            jewel3 = new Triangle(symbol2, 15);

        else if(symbol2.equals("W"))
            jewel3 = new Wildcard(symbol2, 10);

        else if(symbol.equals("/"))
            jewel3 = new Slash(symbol, 20);

        else if(symbol.equals("-"))
            jewel3 = new Minus(symbol, 20);

        else if(symbol.equals("+"))
            jewel3 = new Plus(symbol, 20);

        else if(symbol.equals("\\"))
            jewel3 = new BackSlash(symbol, 20);

        else if(symbol.equals("|"))
            jewel3 = new Bar(symbol, 20);

        assert jewel3 != null;

        return jewel.getPOINT() + jewel2.getPOINT() + jewel3.getPOINT();                        // sum of the 3 jewels' points
    }


    public void printGrid(BufferedWriter bw) throws IOException                                 // write grid into the file
    {
        bw.write("\n");
        for(ArrayList<String> temp : grid)
        {
            for(String st : temp)
            {
                bw.write(st + " ");
            }
            bw.write("\n");
        }
        bw.write("\n");
    }


    private ArrayList<Player> createPlayers(String playersFile) throws IOException              // create Player's list according to the leaderboard.txt
    {
        ArrayList<String> temp = ReadFile.readFileToArrayList(playersFile);
        ArrayList<ArrayList<String>> content = ReadFile.parseList(temp);
        ArrayList<Player> players = new ArrayList<>();

        for(ArrayList<String> ars : content)
        {
            String name = ars.get(0);
            int score = Integer.parseInt(ars.get(1));

            Player player = new Player(name, score);
            players.add(player);
        }

        return players;
    }


    private void makeGrid(String gridFile) throws IOException                                   // create the grid
    {
        ArrayList<String> temp = ReadFile.readFileToArrayList(gridFile);
        grid = ReadFile.parseList(temp);
    }


    private void createCommands(String commandFile) throws IOException                          // parse the commands
    {
        ArrayList<String> temp = ReadFile.readFileToArrayList(commandFile);
        commands = ReadFile.parseList(temp);

    }
}
