import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Action
{
    private String item;

    private static ArrayList<String> communityChests = new ArrayList<>();
    private static ArrayList<String> chances = new ArrayList<>();

    public static boolean flg = false;
    public static boolean flgAnother = false;


    public Action(String item)
    {
        this.item = item;
    }


    public static void prepareActions(ArrayList<ActionSquare> actionSquares)
    {
        for(int i = 0; i < 6; i++)
        {
            chances.add(actionSquares.get(i).getAction().getItem());
        }

        for(int i = 6; i < actionSquares.size(); i++)
        {
            communityChests.add(actionSquares.get(i).getAction().getItem());
        }

    }

    public static void applyCommunityChest(Player player, Player anotherPlayer, BufferedWriter bufferedWriter, int dice, Banker banker) throws IOException
    {
        String temp = communityChests.get(0);
        switch (communityChests.size())                             // do some action according to the dice
        {
            case(11):
                player.setPosition(0);
                player.passGo();
                banker.payMoney(200);
                communityChests.remove(0);
                break;

            case(10):
                player.addMoney(75);
                banker.payMoney(75);
                communityChests.remove(0);
                break;

            case(9):
                if(player.getMoney() < 50)
                {
                    flg = true;
                    return;
                }
                player.payMoney(50);
                banker.addMoney(50);
                communityChests.remove(0);
                break;

            case(8):
                if(anotherPlayer.getMoney() < 10)
                {
                    flgAnother = true;
                    return;
                }
                anotherPlayer.payMoney(10);
                player.addMoney(10);
                communityChests.remove(0);
                break;

            case(7):
                if(anotherPlayer.getMoney() < 50)
                {
                    flgAnother = true;
                    return;
                }
                anotherPlayer.payMoney(50);
                player.addMoney(50);                                    // take 50 tl from another player
                communityChests.remove(0);
                break;

            case(6):
                player.addMoney(20);
                banker.payMoney(20);
                communityChests.remove(0);
                break;

            case(5):
                player.addMoney(100);
                banker.payMoney(100);                           // take 100 tl from banker
                communityChests.remove(0);
                break;

            case(4):
                if(player.getMoney() < 100)
                {
                    flg = true;
                    return;
                }
                player.payMoney(100);
                banker.addMoney(100);
                communityChests.remove(0);
                break;

            case(3):
                if(player.getMoney() < 50)
                {
                    flg = true;
                    return;
                }
                player.payMoney(50);
                banker.addMoney(50);
                communityChests.remove(0);
                break;

            case(2):
                player.addMoney(100);
                banker.payMoney(100);
                communityChests.remove(0);
                break;

            case(1):
                player.addMoney(50);
                banker.payMoney(50);
                communityChests.remove(0);
                break;
        }
        if(player.getName().equals("Player 1"))
            bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
        else
            bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");

        bufferedWriter.write(player.getName() + " draw Community Chest -" + temp + "\n");
    }


    public static void applyChance(Player player, Player anotherPlayer, Banker banker, BufferedWriter bufferedWriter, int dice) throws IOException
    {
        String temp = chances.get(0);
        boolean flag = false;
        boolean flag2 = false;
        boolean flag3 = false;

        switch (chances.size())
        {
            case(6):
                player.setPosition(0);
                player.passGo();
                banker.payMoney(200);
                chances.remove(0);
                break;

            case(5):

                if(player.getPosition() > 26)
                {
                    player.passGo();
                    banker.payMoney(200);
                }
                player.setPosition(26);

                PropertySquare propertySquare = Monopoly.obtainPropertySquare(27);
                assert propertySquare != null;

                if(anotherPlayer.hasPlace(propertySquare.getProperty()))
                {
                    if(player.getMoney() < propertySquare.getProperty().getCost())
                    {
                        flg = true;
                        return;
                    }

                    player.payRent(propertySquare.getProperty(), 0);
                    anotherPlayer.takeRent(propertySquare.getProperty(), 0);
                    if(player.getName().equals("Player 1"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    else if(player.getName().equals("Player 2"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    bufferedWriter.write( player.getName() + " paid rent for " + propertySquare.getProperty().getName() + "\n");
                    flag = true;
                }
                else if(player.hasPlace(propertySquare.getProperty()))
                {
                    if(player.getName().equals("Player 1"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    else if(player.getName().equals("Player 2"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    bufferedWriter.write(player.getName() + " has " + propertySquare.getProperty().getName() + "\n");
                    flag2 = true;
                }
                else
                {
                    if(player.getMoney() < propertySquare.getProperty().getCost())
                    {
                        flg = true;
                        return;
                    }

                    player.buyPlace(propertySquare.getProperty());
                    banker.sellPlace(propertySquare.getProperty());
                    if(player.getName().equals("Player 1"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    else if(player.getName().equals("Player 2"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    flag3 = true;
                    bufferedWriter.write(player.getName() + " bought " + propertySquare.getProperty().getName() + "\n");
                }
                chances.remove(0);
                break;

            case(4):
                player.setPosition(player.getPosition() - 3);

                PropertySquare propertySquare1 = Monopoly.obtainPropertySquare((player.getPosition() + 1));
                assert propertySquare1 != null;

                if(anotherPlayer.hasPlace(propertySquare1.getProperty()))
                {
                    if(player.getMoney() < propertySquare1.getProperty().getCost())
                    {
                        flg = true;
                        return;
                    }

                    flag = true;
                    player.payRent(propertySquare1.getProperty(), 0);
                    anotherPlayer.takeRent(propertySquare1.getProperty(), 0);
                    if(player.getName().equals("Player 1"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    else if(player.getName().equals("Player 2"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }

                    bufferedWriter.write(player.getName() + " paid rent for " + propertySquare1.getProperty().getName() + "\n");
                }
                else if(player.hasPlace(propertySquare1.getProperty()))
                {
                    flag2 = true;
                    if(player.getName().equals("Player 1"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    else if(player.getName().equals("Player 2"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }

                    bufferedWriter.write(player.getName() + " has " + propertySquare1.getProperty().getName() + "\n");
                }
                else
                {
                    if(player.getMoney() < propertySquare1.getProperty().getCost())
                    {
                        flg = true;
                        return;
                    }

                    flag3 = true;
                    player.buyPlace(propertySquare1.getProperty());
                    banker.sellPlace(propertySquare1.getProperty());

                    if(player.getName().equals("Player 1"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }
                    else if(player.getName().equals("Player 2"))
                    {
                        bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");
                        bufferedWriter.write(player.getName() + " draw " + temp + " ");
                    }

                    bufferedWriter.write(player.getName() + " bought " + propertySquare1.getProperty().getName() + "\n");
                }
                chances.remove(0);
                break;

            case(3):
                if(player.getMoney() < 15)
                {
                    flg = true;
                    return;
                }

                player.payMoney(15);
                banker.addMoney(15);
                chances.remove(0);
                break;

            case(2):
                player.addMoney(150);
                banker.payMoney(150);
                chances.remove(0);
                break;

            case(1):
                player.addMoney(100);
                banker.payMoney(100);
                chances.remove(0);
                break;
        }

        if(player.getName().equals("Player 1") && !flag2 && !flag && !flag3)
        {
            bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
            bufferedWriter.write(player.getName() + " draw " + temp + "\n");
        }
        else if(player.getName().equals("Player 2") && !flag2 && !flag && !flag3)
        {
            bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1)) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");
            bufferedWriter.write(player.getName() + " draw " + temp + "\n");
        }

    }


    public String toString()
    {
        return this.item;
    }


    public String getItem() { return this.item; }
}
