package blood_donation.domain.people;

import blood_donation.domain.blood.Blood;

import javax.persistence.*;
import java.util.List;


@Entity
@DiscriminatorValue("patient")
public class Patient extends Person
{
    public Patient(String firstName, String lastName, String username, String password)
    {
        super(firstName, lastName, username, password);
    }

    public Patient()
    {
    }

    //private List<Blood> requiredBlood;
    //private List<String> antibodies;

}
