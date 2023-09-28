import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Initiator
{
    public static ArrayList<ArrayList<String>> initializeDatabase(String pathName) throws IOException
    {
        ArrayList<ArrayList<String>> data = new ArrayList<>();

        File file = new File(pathName);

        if(file.exists())
        {
            ArrayList<String> temp = ReadFile.readFileToArrayList(pathName);
            data = ReadFile.parseList(temp);
        }

        else                                                                        // if there is no file namely backup.dat create 1 user which is admin
        {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("user");
            temp.add("admin");
            temp.add("password");
            temp.add("true");
            temp.add("true");

            data.add(temp);
        }

        return data;
    }
}
