package blood_donation.domain.utils;

import blood_donation.domain.people.Patient;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "BloodRequests")
public class BloodRequest
{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    //private Patient patient;
    private String status = "waiting";

    public BloodRequest(Patient patient)
    {
        //this.patient = patient;
    }

    public BloodRequest()
    {
    }

    public void process()
    {

    }
}
