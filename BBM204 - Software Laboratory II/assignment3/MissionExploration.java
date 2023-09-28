import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MissionExploration
{

    /**
     * Given a Galaxy object, prints the solar systems within that galaxy.
     * Uses exploreSolarSystems() and printSolarSystems() methods of the Galaxy object.
     *
     * @param galaxy a Galaxy object
     */
    public void printSolarSystems(Galaxy galaxy)
    {
        List<SolarSystem> solarSystems = galaxy.exploreSolarSystems();
        galaxy.printSolarSystems(solarSystems);
    }


    public Galaxy readXML(String filename)
    {
        List<Planet> planetList = new ArrayList<>();

        try
        {
            File file = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Galaxy");

            for(int i = 0; i < nList.getLength(); i++)
            {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;

                NodeList pList = eElement.getElementsByTagName("Planet");

                for(int j = 0; j < pList.getLength(); j++)
                {
                    String planetID = eElement.getElementsByTagName("ID").item(j).getTextContent();
                    int techLevel = Integer.parseInt(eElement.getElementsByTagName("TechnologyLevel").item(j).getTextContent());

                    Node nNode2 = pList.item(j);
                    Element eElement2 = (Element) nNode2;

                    NodeList neList = eElement2.getElementsByTagName("PlanetID");

                    List<String> neighbors = new ArrayList<>();

                    for(int k = 0; k < neList.getLength(); k++)
                    {
                        Node nNode3 = neList.item(k);
                        Element eElement3 = (Element) nNode3;

                        String np = eElement3.getTextContent();
                        neighbors.add(np);

                    }

                    Planet planet = new Planet(planetID, techLevel, neighbors);
                    planetList.add(planet);
                }
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return new Galaxy(planetList);
    }
}
