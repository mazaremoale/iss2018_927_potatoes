package blood_donation.domain.utils;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Distances")
public class Distance
{
    @EmbeddedId
    private LocationID id;

    private int distance;

    @ManyToOne
    @JoinColumn(name = "Location1ID")
    private Location location1;

    @ManyToOne
    @JoinColumn(name = "Location2ID")
    private Location location2;

    public Distance()
    {
    }


    public Distance(Location location1, Location location2, int distance)
    {
        this.distance = distance;
        this.location1 = location1;
        this.location2 = location2;
    }

    public LocationID getId()
    {
        return id;
    }

    public void setId(LocationID id)
    {
        this.id = id;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public Location getLocation1()
    {
        return location1;
    }

    public void setLocation1(Location location1)
    {
        this.location1 = location1;
    }

    public Location getLocation2()
    {
        return location2;
    }

    public void setLocation2(Location location2)
    {
        this.location2 = location2;
    }

    @Embeddable
    public static class LocationID implements Serializable
    {
        private int location1ID;
        private int location2ID;

        public boolean equals(Object o)
        {
            if (o == null)
                return false;

            if (!(o instanceof LocationID))
                return false;

            LocationID other = (LocationID) o;
            if (!(other.location1ID == location2ID))
                return false;

            return other.location2ID == location2ID;
        }

    }
}
