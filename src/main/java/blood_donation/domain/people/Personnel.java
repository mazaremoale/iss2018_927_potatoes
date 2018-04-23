package blood_donation.domain.people;

import blood_donation.domain.utils.Clinic;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 */
@Entity
@DiscriminatorValue("personnel")
public class Personnel extends Person
{
    private Clinic clinic;
    private StringProperty clinicProperty = new SimpleStringProperty("clinic");

    public Personnel()
    {
    }

    public Personnel(String firstName, String lastName, String username, String password)
    {
        super(firstName, lastName, username, password);
    }

    public Personnel(String firstName, String lastName, String username, String password, Clinic clinic)
    {
        super(firstName, lastName, username, password);
        this.clinic = clinic;
        this.clinicProperty.set(clinic.toString());
    }


    public StringProperty clinicProperty()
    {
        return clinicProperty;
    }

    @ManyToOne
    @JoinColumn(name = "clinicID")
    public Clinic getClinic()
    {
        return clinic;
    }

    public void setClinic(Clinic clinic)
    {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                '}';
    }
}