package blood_donation.domain.people;

import blood_donation.domain.blood.Blood;

import javax.persistence.*;
import java.util.List;


@Entity
@DiscriminatorValue("patient")
public class Patient extends Person
{
    //private List<Blood> requiredBlood;

    @ElementCollection
    @CollectionTable(name="Antibodies", joinColumns=@JoinColumn(name="PatientID"))
    private List<String> antibodies;

}
