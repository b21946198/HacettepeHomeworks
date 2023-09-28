import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
        return list;                // return arraylist line by line
    }


    public static ArrayList<ArrayList<String>> parseList(ArrayList<String> list)
    {
        ArrayList<ArrayList<String>> parsedList = new ArrayList<>();

        for(String ele : list)
        {
            String[] str = ele.split("\t");
            ArrayList<String> temp = new ArrayList<>(Arrays.asList(str));
            parsedList.add(temp);
        }
        return parsedList;          // return arraylist of arraylists with each separate word
    }
}
