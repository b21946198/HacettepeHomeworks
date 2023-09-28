import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public abstract class Constants                                                                     // an abstract class for containing constant values such as Title
{
    public static String TITLE;
    public static int MAXIMUM_ERROR_WITHOUT_BLOCKED;
    public static int BLOCK_TIME;
    public static int DISCOUNT_PERCENTAGE;


    public static void prepareConstants(String pathName) throws IOException
    {
        ArrayList<String> list = ReadFile.readFileToArrayList(pathName);
        prepareTitle(list);
        prepareBlockCount(list);
        prepareBlockTime(list);
        prepareDiscount(list);
    }


    private static void prepareDiscount(ArrayList<String> list)
    {
        for(String item : list)
        {
            if(item.contains("discount"))
            {
                String[] temp = item.split("=");
                DISCOUNT_PERCENTAGE = Integer.parseInt(temp[1]);
            }
        }
    }


    private static void prepareBlockTime(ArrayList<String> list)
    {
        for(String item : list)
        {
            if(item.contains("time"))
            {
                String[] temp = item.split("=");
                BLOCK_TIME = Integer.parseInt(temp[1]);
                break;
            }
        }
    }


    private static void prepareBlockCount(ArrayList<String> list)
    {
        for(String item : list)
        {
            if(item.contains("error"))
            {
                String[] temp = item.split("=");
                MAXIMUM_ERROR_WITHOUT_BLOCKED = Integer.parseInt(temp[1]);
                break;
            }
        }
    }


    private static void prepareTitle(ArrayList<String> list)
    {
        for(String item : list)
        {
            if(item.contains("title"))
            {
                String[] temp = item.split("=");
                TITLE = temp[1];
                break;
            }
        }
    }


    public static String hashPassword(String password)
    {
        byte[] bytesOfPassword = password . getBytes(StandardCharsets.UTF_8);
        byte[] md5Digest = new byte[0];
        try
        {
            md5Digest = MessageDigest.getInstance("MD5").digest(bytesOfPassword);
        }
        catch(NoSuchAlgorithmException e)
        {
            return null;
        }
        return Base64.getEncoder().encodeToString(md5Digest);
    }
}
