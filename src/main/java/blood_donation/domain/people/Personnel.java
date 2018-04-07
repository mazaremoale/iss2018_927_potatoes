package blood_donation.domain.people;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue("personnel")
public class Personnel extends Person
{
    public Personnel()
    {
    }

    public Personnel(String firstName, String lastName, String username, String password)
    {
        super(firstName, lastName, username, password);
    }
}