import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile
{
    public static ArrayList<String> readFileToArrayList(String pathName) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));
        ArrayList<String> list = new ArrayList<>();
        String line = bufferedReader.readLine();

        while(line != null)
        {
            list.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }
}
