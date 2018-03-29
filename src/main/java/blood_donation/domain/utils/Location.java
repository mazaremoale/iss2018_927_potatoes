package blood_donation.domain.utils;

import java.util.Map;

public class Location
{
    private int id;
    private String name;
    private Map<Location,Integer> distances;

    public Location(String name, Map<Location, Integer> distances)
    {
        this.name = name;
        this.distances = distances;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Map<Location, Integer> getDistances()
    {
        return distances;
    }

    public void setDistances(Map<Location, Integer> distances)
    {
        this.distances = distances;
    }
}
