package blood_donation.domain.people;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="doctor")
public class Doctor extends Person
{


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