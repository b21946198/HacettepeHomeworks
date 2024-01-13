import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class ListJsonReader                                     // Json file reader
{
    private ArrayList<ActionSquare> actionSquares = new ArrayList<>();

    public ListJsonReader()
    {
        JSONParser processor = new JSONParser();

        try (Reader file = new FileReader("list.json"))
        {
            JSONObject jsonfile = (JSONObject) processor.parse(file);
            JSONArray chanceList = (JSONArray) jsonfile.get("chanceList");

            for(Object i : chanceList)
            {
                String item = ((String)((JSONObject)i).get("item"));
                Action action = new Action(item);
                ActionSquare actionSquare = new ActionSquare(action);
                actionSquares.add(actionSquare);
            }

            JSONArray communityChestList = (JSONArray) jsonfile.get("communityChestList");

            for(Object i : communityChestList)
            {
                String item = (String)((JSONObject) i).get("item");
                Action action = new Action(item);
                ActionSquare actionSquare = new ActionSquare(action);
                actionSquares.add(actionSquare);
            }
        }
        catch (IOException | ParseException e)
        {
            e.printStackTrace();
        }
    }


    public ArrayList<ActionSquare> getActionSquares()
    {
        return actionSquares;
    }
}

