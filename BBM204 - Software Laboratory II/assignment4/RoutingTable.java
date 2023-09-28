import java.io.Serializable;
import java.util.*;

public class RoutingTable implements Serializable
{
    static final long serialVersionUID = 99L;
    private final Router router;
    private final Network network;
    private final List<RoutingTableEntry> entryList;

    public RoutingTable(Router router)
    {
        this.router = router;
        this.network = router.getNetwork();
        this.entryList = new ArrayList<>();
    }


    public void updateTable()
    {
        entryList.clear();

        for(Router neighbour : network.getRouters())
        {
            if(!neighbour.equals(this.router))
            {
                RoutingTableEntry rte = new RoutingTableEntry(this.router.getIpAddress(), neighbour.getIpAddress(), pathTo(neighbour));
                entryList.add(rte);
            }
        }
    }


    public Stack<Link> pathTo(Router destination)
    {
        for(Router rtr : network.getRouters())
        {
            rtr.lastStack.clear();
        }

        ArrayList<Router> dijkstra = new ArrayList<>();

        Router temp = this.router;
        temp.setPassed(true);

        initializeDistances();

        while(dijkstra.size() != network.getRouters().size())
        {
            for(Link link : network.getLinksOfRouter(temp))
            {
                if(link.getIpAddress1().equals(temp.getIpAddress()))
                {
                    Router cls = network.getRouterWithIp(link.getIpAddress2());
                    if(cls.dist > link.getCost() + temp.dist)
                    {
                        cls.dist = link.getCost() + temp.dist;


                        cls.routerStack.clear();

                        for(int i = 0; i < temp.routerStack.size(); i++)
                        {
                            cls.routerStack.push(temp.routerStack.get(i));
                        }
                        cls.routerStack.add(link);
                    }
                }

                else
                {
                    Router cls = network.getRouterWithIp(link.getIpAddress1());
                    if(cls.dist > link.getCost() + temp.dist)
                    {
                        cls.dist = link.getCost() + temp.dist;

                        cls.routerStack.clear();

                        for(int i = 0; i < temp.routerStack.size(); i++)
                        {
                            cls.routerStack.push(temp.routerStack.get(i));
                        }
                        cls.routerStack.add(link);
                    }
                }
            }

            for(Router rtr : network.getRouters())
            {
                if(rtr.dist != 0 && !rtr.isPassed())
                {
                    temp = rtr;
                    break;
                }
            }

            for(Router rtr : network.getRouters())
            {
                if(!rtr.isPassed() && rtr.dist < temp.dist)
                {
                    temp = rtr;
                }
            }

            temp.setPassed(true);

            dijkstra.add(temp);
        }

        for(Router rtr : network.getRouters())
        {
            while(!rtr.routerStack.empty())
            {
                rtr.lastStack.push(rtr.routerStack.pop());
            }
        }

        return destination.lastStack;
    }


    public void initializeDistances()
    {
        for(Router rtr : network.getRouters())
        {
            if(rtr.equals(this.router))
            {
                this.router.dist = 0;
            }

            else
            {
                rtr.dist = Double.POSITIVE_INFINITY;
            }

            rtr.setPassed(false);
        }
    }


    @Override
    public String toString()
    {
        return "RoutingTable{" +
                "router=" + router +
                ", network=" + network +
                ", entryList=" + entryList +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutingTable that = (RoutingTable) o;
        return router.equals(that.router) && entryList.equals(that.entryList);
    }

    public List<RoutingTableEntry> getEntryList() {
        return entryList;
    }


    public Router getRouter()
    {
        return router;
    }

    public Network getNetwork()
    {
        return network;
    }
}
