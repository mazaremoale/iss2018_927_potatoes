package blood_donation.domain.utils;

import blood_donation.Main;

import javax.persistence.*;

@Entity
@Table(name = "Distances")
public class Distance
{
    private int id;
    private Location location1;
    private Location location2;
    private int distance;

    public Distance(Location location1, Location location2, int distance)
    {
        this.location1 = location1;
        this.location2 = location2;
        this.distance = distance;
    }

    public Distance()
    {
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

    @ManyToOne
    @JoinColumn(name = "location1ID")
    public Location getLocation1()
    {
        return location1;
    }

    public void setLocation1(Location location1)
    {
        this.location1 = location1;
    }

    @ManyToOne
    @JoinColumn(name = "location2ID")
    public Location getLocation2()
    {
        return location2;
    }

    public void setLocation2(Location location2)
    {
        this.location2 = location2;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }
}