package blood_donation.domain.utils;

import blood_donation.domain.people.Personnel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Clinics")
public class Clinic
{
    private IntegerProperty id = new SimpleIntegerProperty();
    private Location location;
    private List<Personnel> personnelList;

    public Clinic()
    {
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

    @OneToMany
    @JoinColumn(name = "clinicID")
    public List<Personnel> getPersonnelList()
    {
        return personnelList;
    }

    public void setId(int id)
    {
        this.id.set(id);
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public void setPersonnelList(List<Personnel> personnelList)
    {
        this.personnelList = personnelList;
    }
}
