package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.people.Patient;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BloodRequests")
public class BloodRequest
{
    private int id;
    private Patient patient;
    private Status status = Status.PENDING;
    private Set<Blood> requiredBlood;

    public BloodRequest(Patient patient, Set<Blood> requiredBlood)
    {
        this.patient = patient;
        this.requiredBlood = requiredBlood;
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

    @ManyToOne
    @JoinColumn(name = "patientID")
    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    @OneToMany(mappedBy = "bloodRequest")
    public Set<Blood> getRequiredBlood()
    {
        return requiredBlood;
    }

    public void setRequiredBlood(Set<Blood> requiredBlood)
    {
        this.requiredBlood = requiredBlood;
    }

    public void process()
    {

    }
}
