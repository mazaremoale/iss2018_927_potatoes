package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Patient;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BloodRequests")
public class BloodRequest
{
    private int id;
    private Patient patient;
    private BloodGroup bloodGroup;
    private Integer quantity;
    private Priority priority = Priority.LOW;
    private Hospital hospital;
    private Status status = Status.PENDING;
    private Doctor doctor;
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

    @ManyToOne
    @JoinColumn(name = "bloodGroupID")
    public BloodGroup getBloodGroup() { return bloodGroup; }

    public void setBloodGroup(BloodGroup bloodGroup) { this.bloodGroup = bloodGroup; }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    @Enumerated(EnumType.STRING)
    public Priority getPriority()
    {
        return priority;
    }

    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }

    @ManyToOne
    @JoinColumn(name = "hospitalID")
    public Hospital getHospital()
    {
        return hospital;
    }

    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
    }

    @ManyToOne
    @JoinColumn(name = "doctorID")
    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public void process()
    {

    }
}
