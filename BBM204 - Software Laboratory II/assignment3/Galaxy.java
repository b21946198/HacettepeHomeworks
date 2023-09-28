import java.util.*;

public class Galaxy
{

    private final List<Planet> planets;
    private List<SolarSystem> solarSystems;
    private boolean flag;


    public Galaxy(List<Planet> planets)
    {
        this.planets = planets;
        flag = true;
    }


    public List<SolarSystem> exploreSolarSystems()
    {
        solarSystems = new ArrayList<>();
        int counter = 0;

        int N = planets.size();
        boolean[] marked = new boolean[N];

        while(counter != planets.size())
        {
            int a = checkMarks(marked);

            if(a == -1)
                break;

            Planet planet = planets.get(a);
            SolarSystem s1 = new SolarSystem();
            dfs(marked, planet, s1);
            counter += s1.getPlanets().size();
            solarSystems.add(s1);
        }

        return new ArrayList<>(solarSystems);
    }


    public void dfs(boolean[] marked, Planet planet, SolarSystem solarSystem)
    {

        if(flag)
        {
            makeUndirected();
            flag = false;
        }

        Planet temp;
        int idx = planetPlace(planet.getId());
        marked[idx] = true;
        solarSystem.addPlanet(planet);

        for(int i = 0; i < planet.getNeighbors().size(); i++)
        {
            temp = obtainPlanet(planet.getNeighbors().get(i));

            int x = planetPlace(temp.getId());

            if(!marked[x])
                dfs(marked, temp, solarSystem);
        }

    }


    public void makeUndirected()
    {
        for(int i = 0; i < planets.size(); i++)
        {
            for(int j = 0; j < planets.get(i).getNeighbors().size(); j++)
            {
                Planet temp = obtainPlanet(planets.get(i).getNeighbors().get(j));

                if(!(temp.getNeighbors().contains(planets.get(i).getId())))
                {
                    temp.getNeighbors().add(planets.get(i).getId());
                }
            }
        }
    }


    public int checkMarks(boolean[] marked)
    {
        for(int i = 0; i < marked.length; i++)
            if(!marked[i])
                return i;

        return -1;
    }

    public List<SolarSystem> getSolarSystems()
    {
        return solarSystems;
    }

    // FOR TESTING
    public List<Planet> getPlanets()
    {
        return planets;
    }

    // FOR TESTING
    public int getSolarSystemIndexByPlanetID(String planetId)
    {
        for (int i = 0; i < solarSystems.size(); i++)
        {
            SolarSystem solarSystem = solarSystems.get(i);
            if (solarSystem.hasPlanet(planetId))
            {
                return i;
            }
        }
        return -1;
    }


    public void printSolarSystems(List<SolarSystem> solarSystems)
    {
        System.out.printf("%d solar systems have been discovered.%n", solarSystems.size());
        for (int i = 0; i < solarSystems.size(); i++)
        {
            SolarSystem solarSystem = solarSystems.get(i);
            List<Planet> planets = new ArrayList<>(solarSystem.getPlanets());
            Collections.sort(planets);
            System.out.printf("Planets in Solar System %d: %s", i + 1, planets);
            System.out.println();
        }
    }


    public int planetPlace(String id)
    {
        for(int i = 0; i < planets.size(); i++)
            if(planets.get(i).getId().equals(id))
                return i;

        return -1;
    }


    public Planet obtainPlanet(String id)
    {
        for(int i = 0; i < planets.size(); i++)
            if(planets.get(i).getId().equals(id))
                return planets.get(i);

        return null;
    }
}
