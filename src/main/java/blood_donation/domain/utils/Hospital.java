package blood_donation.domain.utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import javax.persistence.*;

@Entity
@Table(name = "Hospitals")
public class Hospital
{
    private Location location;

    @FXML
    private final IntegerProperty id = new SimpleIntegerProperty();

    @FXML
    private final StringProperty locationProperty = new SimpleStringProperty("location");

    @FXML
    private SimpleStringProperty name = new SimpleStringProperty();


    public Hospital()
    {
    }


    public Hospital(Location location, String name)
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

    public String getName()
    {
        return name.get();
    }

    public StringProperty locationProperty() { return locationProperty; }

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
