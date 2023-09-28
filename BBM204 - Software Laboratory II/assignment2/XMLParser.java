import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser
{
    public static Map<String, Malware> parse(String filename)
    {
        Map<String, Malware> map = new LinkedHashMap<>();

        try
        {
            File file = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");

            for(int i = 0; i < nList.getLength(); i++)
            {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                String hash = eElement.getElementsByTagName("hash").item(0).getTextContent();
                int level = Integer.parseInt(eElement.getElementsByTagName("level").item(0).getTextContent());
                Malware malware = new Malware(title, level, hash);
                map.put(hash, malware);
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return map;
    }
}
