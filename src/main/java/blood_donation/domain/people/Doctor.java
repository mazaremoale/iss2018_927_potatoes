package blood_donation.domain.people;

import blood_donation.domain.utils.Hospital;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="doctor")
public class Doctor extends Person
{
    @ManyToOne
    @JoinColumn(name = "hospitalID")
    private Hospital hospital;

    public Doctor(String firstName, String lastName, String username, String password, Hospital hospital)
    {
        super(firstName, lastName, username, password);
        this.hospital = hospital;
    }

    public Doctor(Hospital hospital)
    {
        this.hospital = hospital;
    }

    public Doctor()
    {
    }

    public void request()
    {
        // TODO implement here
    }


    @Override
    public String toString()
    {
        return "Doctor{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                '}';
    }
}