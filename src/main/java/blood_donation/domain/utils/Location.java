package blood_donation.domain.utils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Locations")
public class Location
{
    private int id;
    private String name;
    private List<Distance> distances;


    public Location()
    {
    }

    @OneToMany(mappedBy = "location1")
    public List<Distance> getDistances()
    {
        return distances;
    }

    public void setDistances(List<Distance> distances)
    {
        this.distances = distances;
    }

    public Location(String name)
    {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(unique = true)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }




    @Override
    public String toString()
    {
        return name;
    }
}


