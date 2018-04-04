package blood_donation.domain.utils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Locations")
public class Location
{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    //private Map<Location,Integer> distances;


    public Location()
    {
    }

    public Location(String name)
    {
        this.name = name;
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
        // return distances;
        return null;
    }

    public void setDistances(Map<Location, Integer> distances)
    {
        //this.distances = distances;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
