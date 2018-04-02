package blood_donation.domain.people;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="doctor")
public class Doctor extends Person
{
    private String hospital;

    public Doctor(String firstName, String lastName, String username, String password, String hospital) {
        super(firstName, lastName, username, password);
        this.hospital = hospital;
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