package blood_donation.domain.people;

import blood_donation.domain.blood.Blood;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;


@Entity
@DiscriminatorValue("patient")
public class Patient extends Person
{

    //private List<Blood> requiredBlood;
    //private List<String> antiBodies;

}
