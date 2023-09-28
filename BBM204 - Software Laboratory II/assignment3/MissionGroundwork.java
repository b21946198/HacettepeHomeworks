import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class MissionGroundwork
{
    public void printSchedule(List<Project> projectList)
    {
        for(Project project : projectList)
        {
            int[] schedule = project.getEarliestSchedule();
            project.printSchedule(schedule);
        }
    }


    public List<Project> readXML(String filename)
    {
        List<Project> projectList = new ArrayList<>();

        try
        {
            File file = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Project");

            for(int i = 0; i < nList.getLength(); i++)
            {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                String projectName = eElement.getElementsByTagName("Name").item(0).getTextContent();

                NodeList tList = eElement.getElementsByTagName("Task");

                List<Task> tasks = new ArrayList<>();

                for(int j = 0; j < tList.getLength(); j++)
                {
                    Node nNode2 = tList.item(j);
                    Element eElement2 = (Element) nNode2;
                    int taskID = Integer.parseInt(eElement2.getElementsByTagName("TaskID").item(0).getTextContent());
                    String description = eElement2.getElementsByTagName("Description").item(0).getTextContent();
                    int duration = Integer.parseInt(eElement2.getElementsByTagName("Duration").item(0).getTextContent());

                    List<Integer> dependencies = new ArrayList<>();

                    NodeList dList = eElement2.getElementsByTagName("DependsOnTaskID");

                    for(int k = 0; k < dList.getLength(); k++)
                    {
                        Node nNode3 = dList.item(k);
                        Element eElement3 = (Element) nNode3;

                        int dd = Integer.parseInt(eElement3.getTextContent());

                        dependencies.add(dd);
                    }

                    Task task = new Task(taskID, description, duration, dependencies);
                    tasks.add(task);
                }

                Project project = new Project(projectName, tasks);
                projectList.add(project);
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

        return projectList;
    }
}
