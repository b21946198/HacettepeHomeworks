import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class PropertyJsonReader
{
     private ArrayList<PropertySquare> squares = new ArrayList<>();

     public PropertyJsonReader()                    // Json file reader
     {
         JSONParser processor = new JSONParser();

         try (Reader file = new FileReader("property.json"))
         {
             JSONObject jsonfile = (JSONObject) processor.parse(file);
             JSONArray Land = (JSONArray) jsonfile.get("1");

             for(Object i : Land)
             {
				 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                 String name = (String) ((JSONObject) i).get("name");
                 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));

                 Property land = new Land(id, name, cost);
                 PropertySquare square = new PropertySquare(land);
                 squares.add(square);
             }

             JSONArray RailRoad = (JSONArray) jsonfile.get("2");

             for(Object i : RailRoad)
             {
                 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                 String name = (String) ((JSONObject) i).get("name");
                 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));

                 Property railroad = new Railroad(id, name, cost);
                 PropertySquare square = new PropertySquare(railroad);
                 squares.add(square);
             }
			 
             JSONArray Company = (JSONArray) jsonfile.get("3");

             for(Object i : Company)
             {
                 int id = Integer.parseInt((String)((JSONObject)i).get("id"));
                 String name = (String) ((JSONObject) i).get("name");
                 int cost = Integer.parseInt((String)((JSONObject)i).get("cost"));

                 Property company = new Company(id, name, cost);
                 PropertySquare square = new PropertySquare(company);
                 squares.add(square);
             }
             
         }

         catch (IOException | ParseException e)
         {
             e.printStackTrace();
         }
     }

    public ArrayList<PropertySquare> getSquares()
    {
        return squares;
    }

}