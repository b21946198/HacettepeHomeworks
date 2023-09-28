import java.io.BufferedWriter;
import java.io.IOException;

public class SpecialSquare extends Square                   // inherited from abstract class Square
{
    // private int goSquareId = 0;
    // private int[] taxSquareIds = {4, 38};
    // private int jailSquareId = 10;
    // private int freeParkingSquareId = 20;
    // private int goToJailSquareId = 30;

    private static final int[] SPECIAL_SQUARES = {0, 4, 10, 20, 30, 38};            // squares which contain Special Things

    public static boolean flg = false;


    public static boolean checkDice(int position)
    {
        for(int elt : SPECIAL_SQUARES)
            if(elt == position)
                return true;

        return false;
    }


    public static void applySpecialThing(int position, Player player, Banker banker, BufferedWriter bufferedWriter, int dice, Player anotherPlayer) throws IOException
    {
        String temp = "";                               // action something according to the dice

        switch (position)
        {
            case(0):
                temp = "is in GO square";               // go back to the GO square
                break;

            case(4):
                temp = "paid Tax";                     // paid taxes
                if(player.getMoney() < 100)
                {
                    flg = true;
                    return;
                }
                player.payMoney(100);
                banker.addMoney(100);
                break;

            case(10):
                temp = "went to jail";              // player is going to the jail
                player.setJailCounter(3);
                break;

            case(20):
                temp = "is in free parking";
                player.setJailCounter(1);
                break;

            case(30):
                temp = "went to jail";
                player.setPosition(10);
                player.setJailCounter(3);
                break;

            case(38):
                temp = "paid Tax";
                if(player.getMoney() < 100)
                {
                    flg = true;
                    return;
                }
                player.payMoney(100);
                banker.addMoney(100);
                break;

        }
        if(player.getName().equals("Player 1"))
            bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1) % 40) + "\t" + player.getMoney() + "\t" + anotherPlayer.getMoney() + "\t");
        else
            bufferedWriter.write(player.getName() + "\t" + dice + "\t" + ((player.getPosition() + 1) % 40) + "\t" + anotherPlayer.getMoney() + "\t" + player.getMoney() + "\t");

        bufferedWriter.write(player.getName() + " " + temp + "\n");
    }


}
