import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Network implements Serializable
{
    static final long serialVersionUID = 55L;
    private List<Router> routers = new ArrayList<>();
    private List<Link> links = new ArrayList<>();


    public Network(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine())
        {
            String line = sc.nextLine();

            if(line.contains("Router"))
            {
                String[] temp = line.split(":");
                Router router = new Router(temp[1], this);
                routers.add(router);
            }

            else if(line.contains("Link"))
            {
                String[] temp = line.split(":");

                String[] temp2 = temp[1].split(" ");

                String[] linkArray = temp2[0].split("-");

                String[] temp3 = temp[2].split(" ");
                int bandWith = Integer.parseInt(temp3[0]);

                Link link = new Link(linkArray[0], linkArray[1], bandWith);

                links.add(link);
            }
        }

        sc.close();

        updateAllRoutingTables();
    }


    public static String routerRegularExpression()                          // not fully correct
    {
        String regex = "(\\d+\\.\\d+\\.\\d+\\.\\d+)()";

        return regex;
    }


    public static String linkRegularExpression()                            // not fully correct
    {
        String regex = "(\\d+\\.\\d+\\.\\d+\\.\\d+)-(\\d+\\.\\d+\\.\\d+\\.\\d+.*?)([0-9]{3,4})";

        return regex;
    }

    public List<Router> getRouters()
    {
        return routers;
    }

    public List<Link> getLinks()
    {
        return links;
    }

    public List<RoutingTable> getRoutingTablesOfAllRouters()
    {
        if (routers != null)
        {
            List<RoutingTable> routingTableList = new ArrayList<>();
            for (Router router : routers)
                routingTableList.add(router.getRoutingTable());
            return routingTableList;
        }
        return null;
    }

    public Router getRouterWithIp(String ip)
    {
        if (routers != null) {
            for (Router router : routers)
            {
                if (router.getIpAddress().equals(ip))
                    return router;
            }
        }
        return null;
    }

    public Link getLinkBetweenRouters(String ipAddr1, String ipAddr2)
    {
        if (links != null)
        {
            for (Link link : links)
            {
                if (link.getIpAddress1().equals(ipAddr1) && link.getIpAddress2().equals(ipAddr2)
                        || link.getIpAddress1().equals(ipAddr2) && link.getIpAddress2().equals(ipAddr1))
                    return link;
            }
        }
        return null;
    }

    public List<Link> getLinksOfRouter(Router router)
    {
        List<Link> routersLinks = new ArrayList<>();
        if (links != null)
        {
            for (Link link : links)
            {
                if (link.getIpAddress1().equals(router.getIpAddress()) ||
                        link.getIpAddress2().equals(router.getIpAddress()))
                {
                    routersLinks.add(link);
                }
            }
        }
        return routersLinks;
    }

    public void updateAllRoutingTables()
    {
        for (Router router : getRouters())
        {
            router.getRoutingTable().updateTable();
        }
    }


    public void changeLinkCost(Link link, double newCost)
    {
        for(Link lnk : this.links)
        {
            if(lnk.getIpAddress1().equals(link.getIpAddress1()) && lnk.getIpAddress2().equals(link.getIpAddress2()) && lnk.getCost() == link.getCost())
            {
                link.setCost(newCost);
                break;
            }
        }

        updateAllRoutingTables();
    }


    public void addLink(Link link)
    {
        this.links.add(link);
        updateAllRoutingTables();
    }


    public void addRouter(Router router)
    {
        this.routers.add(router);
        updateAllRoutingTables();
    }


    public void removeLink(Link link)
    {
        for(Link lnk : this.links)
        {
            if(lnk.getIpAddress1().equals(link.getIpAddress1()) && lnk.getIpAddress2().equals(link.getIpAddress2()) && lnk.getCost() == link.getCost())
            {
                this.links.remove(lnk);
                break;
            }
        }
        updateAllRoutingTables();
    }


    public void removeRouter(Router router)
    {
        List<Link> linksOfRouter = this.getLinksOfRouter(router);

        for(Link link : linksOfRouter)
        {
            this.links.remove(link);
        }

        for(Router rtr : this.routers)
        {
            if(rtr.getIpAddress().equals(router.getIpAddress()))
            {
                this.routers.remove(router);
                break;
            }
        }

        updateAllRoutingTables();
    }


    public void changeStateOfRouter(Router router, boolean isDown)
    {
        for(Router rtr : this.routers)
        {
            if(rtr.getIpAddress().equals(router.getIpAddress()))
            {
                rtr.setDown(isDown);
            }
        }

        List<Link> linksOfRouter = this.getLinksOfRouter(router);

        for(Link link : linksOfRouter)
        {
            this.links.remove(link);
        }


        updateAllRoutingTables();
    }


    public void setRouters(List<Router> routers)
    {
        this.routers = routers;
    }

    public void setLinks(List<Link> links)
    {
        this.links = links;
    }


    @Override
    public String toString()
    {
        return "Network{" +
                "routers=" + routers +
                ", links=" + links +
                '}';
    }
}
