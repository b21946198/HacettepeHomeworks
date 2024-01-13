import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Monopoly
{
    private ArrayList<ArrayList<String>> commands;

    private Player player1;
    private Player player2;                     // game has 2 players and a banker
    private Banker banker;

    private static ArrayList<PropertySquare> propertySquares;
    private ArrayList<ActionSquare> actionSquares;

    private static boolean flg = false;

    public Monopoly(String commandsFileName) throws IOException
    {
        prepareCommandsFile(commandsFileName);              // read files
        createUsers();                                      // initiate users which are banker and players
        prepareSquares();                                   // prepare squares according to the given instructions
        Action.prepareActions(actionSquares);
    }


    public void play() throws IOException
    {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));           // create a o/p file
        int cnt = 0;

        for(ArrayList<String> command : commands)                   // reading commands one-by-one
        {
            cnt++;

            if(flg || player2.getMoney() == 0)                      // if 2nd player money is 0 finish the game
            {
                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                if(player1.getMoney() > player2.getMoney())
                    bufferedWriter.write("Winner " + player1.getName());
                else if(player1.getMoney() < player2.getMoney())
                    bufferedWriter.write("Winner " + player2.getName());
                else
                    bufferedWriter.write("Draw");

                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------\n");
                break;
            }

            if(player1.getMoney() == 0)                     // if 1st player money is 0 wait 1 more turn to finish the game at 2nd player's turn
            {
                flg = true;
            }

            if(command.get(0).equals(player1.getName()))                            // Player 1 actions
            {
                int dice = Integer.parseInt(command.get(1));

                if(player1.getJailCounter() > 0)
                {
                    player1.waitJail();
                    int count = Math.abs(player1.getJailCounter() - 3);
                    bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                    bufferedWriter.write(player1.getName() + " in jail (count=" + count + ")\n");
                }

                else
                {
                    player1.move(dice, banker);
                    PropertySquare propertySquare = obtainPropertySquare((player1.getPosition() + 1));
                    assert propertySquare != null;

                    if(PropertySquare.isLand(player1.getPosition()))
                    {
                        if(player2.hasPlace(propertySquare.getProperty()))
                        {
                            player1.payRent(propertySquare.getProperty(), dice);
                            player2.takeRent(propertySquare.getProperty(), dice);
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " paid rent for " + propertySquare.getProperty().getName() + "\n");
                        }
                        else if(player1.hasPlace(propertySquare.getProperty()))
                        {
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " has " + propertySquare.getProperty().getName() + "\n");
                        }
                        else
                        {
                            if(player1.getMoney() < propertySquare.getProperty().getCost())
                            {
                                bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                                bufferedWriter.write(player1.getName() + " goes bankrupt\n");
                                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                                if(player1.getMoney() > player2.getMoney())
                                    bufferedWriter.write("Winner " + player1.getName());
                                else if(player1.getMoney() < player2.getMoney())
                                    bufferedWriter.write("Winner " + player2.getName());
                                else
                                    bufferedWriter.write("Draw");

                                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                                break;
                            }

                            player1.buyPlace(propertySquare.getProperty());
                            banker.sellPlace(propertySquare.getProperty());
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " bought " + propertySquare.getProperty().getName() + "\n");
                        }

                    }

                    else if(PropertySquare.isRailroad(player1.getPosition()))
                    {
                        if(player2.hasPlace(propertySquare.getProperty()))
                        {
                            player1.payRent(propertySquare.getProperty(), dice);
                            player2.takeRent(propertySquare.getProperty(), dice);
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " paid rent for " + propertySquare.getProperty().getName() + "\n");
                        }
                        else if(player1.hasPlace(propertySquare.getProperty()))
                        {
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " has " + propertySquare.getProperty().getName() + "\n");
                        }
                        else
                        {
                            if(player1.getMoney() < propertySquare.getProperty().getCost())
                            {
                                bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                                bufferedWriter.write(player1.getName() + " goes bankrupt\n");
                                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                                if(player1.getMoney() > player2.getMoney())
                                    bufferedWriter.write("Winner " + player1.getName());
                                else if(player1.getMoney() < player2.getMoney())
                                    bufferedWriter.write("Winner " + player2.getName());
                                else
                                    bufferedWriter.write("Draw");

                                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                                break;
                            }

                            player1.buyPlace(propertySquare.getProperty());
                            player1.buyARailroad();
                            banker.sellPlace(propertySquare.getProperty());
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " bought " + propertySquare.getProperty().getName() + "\n");
                        }
                    }

                    else if(PropertySquare.isCompany(player1.getPosition()))
                    {
                        if(player2.hasPlace(propertySquare.getProperty()))
                        {
                            player1.payRent(propertySquare.getProperty(), dice);
                            player2.takeRent(propertySquare.getProperty(), dice);
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " paid rent for " + propertySquare.getProperty().getName() + "\n");
                        }
                        else if(player1.hasPlace(propertySquare.getProperty()))
                        {
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " has " + propertySquare.getProperty().getName() + "\n");
                        }
                        else
                        {
                            if(player1.getMoney() < propertySquare.getProperty().getCost())
                            {
                                bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                                bufferedWriter.write(player1.getName() + " goes bankrupt\n");
                                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                                if(player1.getMoney() > player2.getMoney())
                                    bufferedWriter.write("Winner " + player1.getName());
                                else if(player1.getMoney() < player2.getMoney())
                                    bufferedWriter.write("Winner " + player2.getName());
                                else
                                    bufferedWriter.write("Draw");

                                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                                break;
                            }

                            player1.buyPlace(propertySquare.getProperty());
                            banker.sellPlace(propertySquare.getProperty());
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " bought " + propertySquare.getProperty().getName() + "\n");
                        }
                    }

                    else if(SpecialSquare.checkDice(player1.getPosition()))
                    {
                        SpecialSquare.applySpecialThing(player1.getPosition(), player1, banker, bufferedWriter, dice, player2);

                        if(SpecialSquare.flg)
                        {
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }
                    }

                    else if(ActionSquare.isCommunityChest(player1.getPosition()))
                    {
                        Action.applyCommunityChest(player1, player2, bufferedWriter, dice, banker);

                        if(Action.flg)
                        {
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }

                        else if(Action.flgAnother)
                        {
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }
                    }

                    else if(ActionSquare.isChance(player1.getPosition()))
                    {
                        Action.applyChance(player1, player2, banker, bufferedWriter, dice);

                        if(Action.flg)
                        {
                            bufferedWriter.write(player1.getName() + "\t" + dice + "\t" + ((player1.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }
                    }
                }

            }

            else if(command.get(0).equals(player2.getName()))                   // Player 2 actions
            {
                int dice = Integer.parseInt(command.get(1));

                if(player2.getJailCounter() > 0)
                {
                    player2.waitJail();
                    int count = Math.abs(player2.getJailCounter() - 3);
                    bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                    bufferedWriter.write(player2.getName() + " in jail (count=" + count + ")\n");
                }

                else
                {
                    player2.move(dice, banker);
                    PropertySquare propertySquare = obtainPropertySquare((player2.getPosition()) + 1);
                    assert propertySquare != null;

                    if(PropertySquare.isLand(player2.getPosition()))
                    {
                        if(player1.hasPlace(propertySquare.getProperty()))
                        {
                            player2.payRent(propertySquare.getProperty(), dice);
                            player1.takeRent(propertySquare.getProperty(), dice);
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " paid rent for " + propertySquare.getProperty().getName() + "\n");
                        }
                        else if(player2.hasPlace(propertySquare.getProperty()))
                        {
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " has " + propertySquare.getProperty().getName() + "\n");
                        }
                        else
                        {
                            if(player2.getMoney() < propertySquare.getProperty().getCost())
                            {
                                bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                                bufferedWriter.write(player2.getName() + " goes bankrupt\n");
                                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                                if(player1.getMoney() > player2.getMoney())
                                    bufferedWriter.write("Winner " + player1.getName());
                                else if(player1.getMoney() < player2.getMoney())
                                    bufferedWriter.write("Winner " + player2.getName());
                                else
                                    bufferedWriter.write("Draw");

                                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                                break;
                            }

                            player2.buyPlace(propertySquare.getProperty());
                            banker.sellPlace(propertySquare.getProperty());
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " bought " + propertySquare.getProperty().getName() + "\n");
                        }

                    }

                    else if(PropertySquare.isRailroad(player2.getPosition()))
                    {
                        if(player1.hasPlace(propertySquare.getProperty()))
                        {
                            player2.payRent(propertySquare.getProperty(), dice);
                            player1.takeRent(propertySquare.getProperty(), dice);
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " paid rent for " + propertySquare.getProperty().getName() + "\n");
                        }
                        else if(player2.hasPlace(propertySquare.getProperty()))
                        {
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " has " + propertySquare.getProperty().getName() + "\n");
                        }
                        else
                        {
                            if(player2.getMoney() < propertySquare.getProperty().getCost())
                            {
                                bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                                bufferedWriter.write(player2.getName() + " goes bankrupt\n");
                                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                                if(player1.getMoney() > player2.getMoney())
                                    bufferedWriter.write("Winner " + player1.getName());
                                else if(player1.getMoney() < player2.getMoney())
                                    bufferedWriter.write("Winner " + player2.getName());
                                else
                                    bufferedWriter.write("Draw");

                                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                                break;
                            }

                            player2.buyPlace(propertySquare.getProperty());
                            player2.buyARailroad();
                            banker.sellPlace(propertySquare.getProperty());
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " bought " + propertySquare.getProperty().getName() + "\n");
                        }
                    }

                    else if(PropertySquare.isCompany(player2.getPosition()))
                    {
                        if(player1.hasPlace(propertySquare.getProperty()))
                        {
                            player2.payRent(propertySquare.getProperty(), dice);
                            player1.takeRent(propertySquare.getProperty(), dice);
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " paid rent for " + propertySquare.getProperty().getName() + "\n");
                        }
                        else if(player2.hasPlace(propertySquare.getProperty()))
                        {
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " has " + propertySquare.getProperty().getName() + "\n");
                        }
                        else
                        {
                            if(player2.getMoney() < propertySquare.getProperty().getCost())
                            {
                                bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                                bufferedWriter.write(player2.getName() + " goes bankrupt\n");
                                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                                if(player1.getMoney() > player2.getMoney())
                                    bufferedWriter.write("Winner " + player1.getName());
                                else if(player1.getMoney() < player2.getMoney())
                                    bufferedWriter.write("Winner " + player2.getName());
                                else
                                    bufferedWriter.write("Draw");

                                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                                break;
                            }

                            player2.buyPlace(propertySquare.getProperty());
                            banker.sellPlace(propertySquare.getProperty());
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " bought " + propertySquare.getProperty().getName() + "\n");
                        }
                    }

                    else if(SpecialSquare.checkDice(player2.getPosition()))
                    {
                        SpecialSquare.applySpecialThing(player2.getPosition(), player2, banker, bufferedWriter, dice, player1);

                        if(SpecialSquare.flg)
                        {
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }
                    }

                    else if(ActionSquare.isCommunityChest(player2.getPosition()))
                    {
                        Action.applyCommunityChest(player2, player1, bufferedWriter, dice, banker);

                        if(Action.flg)
                        {
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }

                        else if(Action.flgAnother)
                        {
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player1.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }
                    }

                    else if(ActionSquare.isChance(player2.getPosition()))
                    {
                        Action.applyChance(player2, player1, banker, bufferedWriter, dice);

                        if(Action.flg)
                        {
                            bufferedWriter.write(player2.getName() + "\t" + dice + "\t" + ((player2.getPosition() + 1)) + "\t" + player1.getMoney() + "\t" + player2.getMoney() + "\t");
                            bufferedWriter.write(player2.getName() + " goes bankrupt\n");
                            bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                            bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                            bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                            bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                            if(player1.getMoney() > player2.getMoney())
                                bufferedWriter.write("Winner " + player1.getName());
                            else if(player1.getMoney() < player2.getMoney())
                                bufferedWriter.write("Winner " + player2.getName());
                            else
                                bufferedWriter.write("Draw");

                            bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
                            break;
                        }
                    }
                }

            }

            else                        // if the command is show() command
            {
                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                if(player1.getMoney() > player2.getMoney())
                    bufferedWriter.write("Winner " + player1.getName());
                else if(player1.getMoney() < player2.getMoney())
                    bufferedWriter.write("Winner " + player2.getName());
                else
                    bufferedWriter.write("Draw");

                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------\n");

            }

            if(cnt == commands.size())
            {
                bufferedWriter.write("-------------------------------------------------------------------------------------------------------------------------\n");
                bufferedWriter.write(player1.getName() + "\t" + player1.getMoney() + "\t" + "have: " + player1.obtainProperties() + "\n");
                bufferedWriter.write(player2.getName() + "\t" + player2.getMoney() + "\t" + "have: " + player2.obtainProperties() + "\n");
                bufferedWriter.write(banker.getName() + "\t" + banker.getMoney() + "\n");
                if(player1.getMoney() > player2.getMoney())
                    bufferedWriter.write("Winner " + player1.getName());
                else if(player1.getMoney() < player2.getMoney())
                    bufferedWriter.write("Winner " + player2.getName());
                else
                    bufferedWriter.write("Draw");

                bufferedWriter.write("\n-------------------------------------------------------------------------------------------------------------------------");
            }
        }

        bufferedWriter.close();                     // close the o/p file
    }


    public static PropertySquare obtainPropertySquare(int id)                   // obtain property square by id
    {
        for(PropertySquare ps : propertySquares)
        {
            if(ps.getProperty().getId() == id)
                return ps;
        }

        return null;
    }


    private void prepareCommandsFile(String commandsFileName) throws IOException
    {
        ArrayList<String> temp = ReadFile.readFileToArrayList(commandsFileName);
        commands = ReadFile.parseList(temp);
    }


    private void prepareSquares()
    {
        PropertyJsonReader pjs = new PropertyJsonReader();
        propertySquares = pjs.getSquares();
                                                                    // create file objects to read files
        ListJsonReader ljs = new ListJsonReader();
        actionSquares = ljs.getActionSquares();
    }


    private void createUsers()
    {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");                       // create users
        banker = new Banker("Banker");
    }
}
