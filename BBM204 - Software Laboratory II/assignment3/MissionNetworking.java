import java.util.List;

public class MissionNetworking
{
    public SubspaceCommunicationNetwork createNetwork(List<SolarSystem> solarSystems)
    {
        return new SubspaceCommunicationNetwork(solarSystems);
    }


    public void printMinimumCostCommunicationNetwork(SubspaceCommunicationNetwork network)
    {
        List<HyperChannel> hyperChannels = network.getMinimumCostCommunicationNetwork();
        network.printMinimumCostCommunicationNetwork(hyperChannels);
    }
}
