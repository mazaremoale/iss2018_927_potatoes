package blood_donation.domain.utils;

import blood_donation.domain.people.Patient;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Requests")
public class Request
{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    private Patient patient;
    private String status = "waiting";

    public Request(Patient patient)
    {
        this.patient = patient;
    }

    public void process()
    {

    }
}
