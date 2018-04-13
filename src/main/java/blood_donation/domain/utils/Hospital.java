package blood_donation.domain.utils;

import blood_donation.domain.people.Doctor;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Hospitals")
public class Hospital
{
    private IntegerProperty id = new SimpleIntegerProperty();
    private Location location;
    private SimpleStringProperty name = new SimpleStringProperty();

    public Hospital()
    {
    }


    public Hospital(Location location, String name)
    {
        this.location = location;
        this.name = new SimpleStringProperty(name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id.get();
    }

    @ManyToOne
    @JoinColumn(name = "locationID")
    public Location getLocation()
    {
        return location;
    }

    public String getName()
    {
        return name.get();
    }

    public void setId(int id)
    {
        this.id.set(id);
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public void setName(String name)
    {
        this.name.set(name);

    }

    @Override
    public String toString()
    {
        return name.get() + ", " + location;
    }
}
