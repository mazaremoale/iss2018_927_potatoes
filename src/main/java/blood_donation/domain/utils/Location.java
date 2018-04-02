package blood_donation.domain.utils;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
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
    private String name;

    private Map<Location,Integer> distances;


    public Location(String name, Map<Location, Integer> distances)
    {
        this.name = name;
        //this.distances = distances;
    }

    public Location()
    {
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
}
