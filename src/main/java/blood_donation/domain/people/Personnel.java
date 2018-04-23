package blood_donation.domain.people;

import blood_donation.domain.utils.Clinic;

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

    public Personnel()
    {
    }

    public Personnel(String firstName, String lastName, String username, String password)
    {
        super(firstName, lastName, username, password);
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
}