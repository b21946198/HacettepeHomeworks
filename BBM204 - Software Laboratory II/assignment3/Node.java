import java.util.ArrayList;

public class Node
{
    private int id;
    private ArrayList<Integer> adjList;

    public Node(int id, ArrayList<Integer> adjList)
    {
        this.id = id;
        this.adjList = adjList;
    }


    public int getId()
    {
        return this.id;
    }

    public ArrayList<Integer> getAdjList()
    {
        return this.adjList;
    }
}
