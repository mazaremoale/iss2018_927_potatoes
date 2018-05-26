package blood_donation.domain.utils;

import blood_donation.domain.people.Personnel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Clinics")
public class Clinic
{
    private IntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private Location location;
    private StringProperty locationProperty = new SimpleStringProperty("location");


    public Clinic()
    {
    }

    public Clinic(Location location, String name)
    {
        this.location = location;
        this.name = new SimpleStringProperty(name);
        this.locationProperty.set(location.toString());
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


    public void setId(int id)
    {
        this.id.set(id);
    }

    public void setLocation(Location location)
    {
        this.location = location;
        if(location != null)
            locationProperty.set(location.toString());
    }

    public StringProperty locationProperty()
    {
        return locationProperty;
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String name)
    {
        this.name.set(name);
    }

    @Override
    public String toString()
    {
        return name.get() + " Clinic, " + location;
    }
}
