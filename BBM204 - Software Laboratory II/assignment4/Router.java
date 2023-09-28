import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Router implements Serializable
{
    static final long serialVersionUID = 33L;
    private String ipAddress;
    private boolean isDown = false;
    private boolean isPassed = false;
    private Network network;
    private RoutingTable routingTable;

    public Stack<Link> routerStack;
    public Stack<Link> lastStack;

    public double dist;

    public Router(String ipAddress, Network network)
    {
        this.ipAddress = ipAddress;
        this.network = network;
        this.routingTable = new RoutingTable(this);

        routerStack = new Stack<>();
        lastStack = new Stack<>();
    }


    public boolean isPassed()
    {
        return isPassed;
    }

    public void setPassed(boolean passed)
    {
        isPassed = passed;
    }

    public boolean isDown()
    {
        return isDown;
    }

    public void setDown(boolean down)
    {
        isDown = down;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public RoutingTable getRoutingTable()
    {
        return routingTable;
    }

    public Network getNetwork()
    {
        return network;
    }

    public void setNetwork(Network network)
    {
        this.network = network;
    }


    @Override
    public String toString()
    {
        return "Router{" +
                "ipAddress='" + ipAddress + '\'' +
                ", isDown=" + isDown +
                ", dist=" + dist +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Router router = (Router) o;
        return isDown == router.isDown() && Objects.equals(ipAddress, router.getIpAddress());
    }


    public void setRoutingTable(RoutingTable routingTable)
    {
        this.routingTable = routingTable;
    }
}
