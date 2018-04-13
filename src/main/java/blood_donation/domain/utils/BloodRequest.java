package blood_donation.domain.utils;

import blood_donation.domain.people.Patient;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "BloodRequests")
public class BloodRequest
{
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void process()
    {

    }
}
