import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubspaceCommunicationNetwork
{
    private List<SolarSystem> solarSystems;


    public SubspaceCommunicationNetwork(List<SolarSystem> solarSystems)
    {
        this.solarSystems = solarSystems;
    }


    public List<HyperChannel> getMinimumCostCommunicationNetwork()
    {
        List<HyperChannel> minimumCostCommunicationNetwork = new ArrayList<>();
        ArrayList<Planet> planets = new ArrayList<>();

        for(int i = 0; i < solarSystems.size(); i++)
        {
            Planet temp = getHighestTechLevel(solarSystems.get(i));
            planets.add(temp);
        }

        int N = planets.size();
        ArrayList<Planet> MST = new ArrayList<>();

        while (MST.size() != N)
        {
            for (int i = 0; i < planets.size(); i++)
            {
                Planet p1 = null;
                Planet p2 = null;
                double min = 1e11;

                for (int j = 0; j < planets.size(); j++)
                {
                    if(j == i)
                        continue;

                    double average = (double) (planets.get(i).getTechnologyLevel() + planets.get(j).getTechnologyLevel()) / 2.0;
                    double cost = Constants.SUBSPACE_COMMUNICATION_CONSTANT / average;

                    if (cost < min)
                    {
                        min = cost;
                        p1 = planets.get(i);
                        p2 = planets.get(j);
                    }
                }

                if (!MST.contains(p1) || !MST.contains(p2))
                {
                    DecimalFormat df = new DecimalFormat("#.######");
                    df.format(min);

                    HyperChannel hyperChannel = new HyperChannel(p1, p2, min);
                    minimumCostCommunicationNetwork.add(hyperChannel);

                    if (!MST.contains(p1))
                        MST.add(p1);
                    if (!MST.contains(p2))
                        MST.add(p2);
                }

            }

        }

        return minimumCostCommunicationNetwork;
    }



    public Planet getHighestTechLevel(SolarSystem solarSystem)
    {
        Planet planet = solarSystem.getPlanets().get(0);

        for(Planet temp : solarSystem.getPlanets())
        {
            if(temp.getTechnologyLevel() > planet.getTechnologyLevel())
            {
                planet = temp;
            }
        }
        return planet;
    }


    public void printMinimumCostCommunicationNetwork(List<HyperChannel> network)
    {
        double sum = 0;
        for (HyperChannel channel : network)
        {
            Planet[] planets = {channel.getFrom(), channel.getTo()};
            Arrays.sort(planets);
            System.out.printf("Hyperchannel between %s - %s with cost %f", planets[0], planets[1], channel.getWeight());
            System.out.println();
            sum += channel.getWeight();
        }

        System.out.printf("The total cost of the subspace communication network is %f.", sum);
        System.out.println();
    }
}
